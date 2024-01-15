package com.example.PartyPal.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.PartyPal.R;
import com.example.PartyPal.adapters.FeaturedAdapter;
import com.example.PartyPal.adapters.FeaturedVerAdapter;
import com.example.PartyPal.models.FeaturedModel;
import com.example.PartyPal.models.FeaturedVerModel;

import java.util.ArrayList;
import java.util.List;


public class ThirdFragment extends Fragment {

    ///////////////////////Featured Hor RecyclerView///////////////////////////
    List<FeaturedModel> featuredModelsList;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;

    //////////////////////Featured Ver RecyclerView////////////////////////

    List<FeaturedVerModel> featuredVerModelsList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;


    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_first,container,false);


        ////////////////////Featured Ver RecyclerView//////////////////

        recyclerView2 =view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        featuredVerModelsList= new ArrayList<FeaturedVerModel>();

        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.t1,"Waffle","Waffle Biasa and Special","4.5","6pm to 10pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.t2,"Jagung Corn","Special Jagung Cup Cheese","4.4","6pm to 10pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.t3,"Spagetti Specialist","Pelbagai Jenis Spagetti Disediakan","4.0","2pm to 10pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.t4,"Satay Tok abah","Satay Wagyu Available","4.5","6.30pm to 11pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.t5,"Sata Terengganu","Makanan Dari Terengganu Ada disini","4.5","1pm to 10pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.t6,"Mee Kari Rokiyah UMP","Mee Kari lagi Sedap Dari Maggi Kari","4.2","11am to 2pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.t6,"Mee Bandung Syahmi Adli UMP","Mee Bandung Orang Muar","4.8","11am to 2pm"));

        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelsList);
        recyclerView2.setAdapter(featuredVerAdapter);

        return view;
    }
}