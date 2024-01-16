package com.example.PartyPal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.R;
import com.example.PartyPal.adapters.HomeHorAdapter;
import com.example.PartyPal.adapters.HomeVerAdapter;
import com.example.PartyPal.adapters.UpdateVerticalRec;
import com.example.PartyPal.databinding.FragmentHomeBinding;
import com.example.PartyPal.models.HomeHorModel;
import com.example.PartyPal.models.HomeVerModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    ///////////////////////////vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        /////////////horizontal recyclerview
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.pizza, "Feed"));
        homeHorModelList.add(new HomeHorModel(R.drawable.hamburger, "Your Posts"));
       // homeHorModelList.add(new HomeHorModel(R.drawable.fries1, "Fries"));
       // homeHorModelList.add(new HomeHorModel(R.drawable.ice_cream, "Ice Cream"));
       // homeHorModelList.add(new HomeHorModel(R.drawable.sandwich, "Sandwich"));
       //homeHorModelList.add(new HomeHorModel(R.drawable.logo, "New"));
        //homeHorModelList.add(new HomeHorModel(R.drawable.coffee, "Coffee"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        /////////////vertical recyclerview

        homeVerModelList = new ArrayList<>();


        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}
