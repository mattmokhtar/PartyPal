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
import com.example.PartyPal.adapters.HomeVerAdapter;
import com.example.PartyPal.adapters.UpdateVerticalRec;
import com.example.PartyPal.models.HomeVerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    private RecyclerView homeVerticalRec;
    private ArrayList<HomeVerModel> homeVerModelList;
    private HomeVerAdapter homeVerAdapter;

    private DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeVerticalRec = root.findViewById(R.id.home_ver_rec);
        homeVerModelList = new ArrayList<>();
        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList);

        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("parties");

        // Fetch party data from Firebase
        fetchPartyData();

        return root;
    }

    private void fetchPartyData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                homeVerModelList.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Retrieve data from the snapshot
                    String hostName = dataSnapshot.child("hostName").getValue(String.class);
                    String partyTitle = dataSnapshot.child("partyTitle").getValue(String.class);
                    String contactInformation = dataSnapshot.child("contactInformation").getValue(String.class);
                    String partyDescription = dataSnapshot.child("partyDescription").getValue(String.class);
                    String partyDate = dataSnapshot.child("partyDate").getValue(String.class);
                    String partyLocation = dataSnapshot.child("partyLocation").getValue(String.class);

                    // Create a HomeVerModel object
                    HomeVerModel party = new HomeVerModel(hostName, partyTitle, contactInformation, partyDescription, partyDate, partyLocation);

                    // Add the party to the list
                    homeVerModelList.add(party);
                }

                // Notify the adapter that the data has changed
                homeVerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        // Callback implementation if needed
    }
}
