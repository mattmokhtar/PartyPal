package com.example.PartyPal.ui.yourpost;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.R;
import com.example.PartyPal.adapters.YourPostAdapter;
import com.example.PartyPal.models.YourPostModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class YourPost extends Fragment {

    private List<YourPostModel> yourPostModels;
    private YourPostAdapter yourPostAdapter;
    private DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.your_post_fragment, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.yourPostRecyclerView);

        yourPostModels = new ArrayList<>();
        yourPostAdapter = new YourPostAdapter(yourPostModels);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(yourPostAdapter);

        // Set a layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("parties");

        // Fetch party data from Firebase
        fetchPartyData();

        return root;
    }

    private void fetchPartyData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                yourPostModels.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Retrieve data from the snapshot
                    String partyTitle = dataSnapshot.child("partyTitle").getValue(String.class);
                    String contactInformation = dataSnapshot.child("contactInformation").getValue(String.class);
                    String partyDescription = dataSnapshot.child("partyDescription").getValue(String.class);
                    String partyDate = dataSnapshot.child("partyDate").getValue(String.class);
                    String partyLocation = dataSnapshot.child("partyLocation").getValue(String.class);


                    YourPostModel party = new YourPostModel(contactInformation, partyDescription, partyDate, partyLocation, partyDate, partyTitle);

                    yourPostModels.add(party);
                }

                // Notify the adapter that the data has changed
                yourPostAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
                Log.e("YourPost", "Error fetching data: " + error.getMessage());
            }
        });
    }
}
