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


public class FirstFragment extends Fragment {

    ///////////////////////Featured Hor RecyclerView///////////////////////////
    List<FeaturedModel> featuredModelsList;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;

    //////////////////////Featured Ver RecyclerView////////////////////////

    List<FeaturedVerModel> featuredVerModelsList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_first,container,false);


        ////////////////////Featured Hor RecyclerView//////////////////

        recyclerView  = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
         featuredModelsList= new ArrayList<FeaturedModel>();

        featuredModelsList.add(new FeaturedModel(R.drawable.breakfast1,"Nasi Lemak","Nasi Lemak Terbaik UMP"));
        featuredModelsList.add(new FeaturedModel(R.drawable.lunch1,"Nasi Kandar","Nasi Kandar UMP"));
        featuredModelsList.add(new FeaturedModel(R.drawable.dinner1,"Goreng-goreng","Makanan Bergoreng Enak"));

        featuredAdapter = new FeaturedAdapter(featuredModelsList);
        recyclerView.setAdapter(featuredAdapter);


        ////////////////////Featured Ver RecyclerView//////////////////

        recyclerView2 =view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        featuredVerModelsList= new ArrayList<FeaturedVerModel>();

        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.breakfast3,"Roti Canai","Special Menu: Roti Sarang Burung","4.5","7am to 10am"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.breakfast2,"Kuih Muih","Macam-macam ada","4.4","8am to 9am"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.lunch3,"Nasi Ayam","Nasi Ayam Johor","4.0","10am to 2pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.lunch2,"Lauk Pauk","Pelbagai Jenis Lauk Terhidang","4.5","12am to 4pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.dinner2,"Kuew Teow Specialist","Pelbagai Jenis Kuew Teow","4.5","7pm to 12pm"));
        featuredVerModelsList.add(new FeaturedVerModel(R.drawable.lunch4,"Nasi Kakwok","Nasi Kakwok Kak Rozi","4.2","11am to 2pm"));

        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelsList);
        recyclerView2.setAdapter(featuredVerAdapter);

        return view;
    }
}