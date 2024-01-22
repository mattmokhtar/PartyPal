package com.example.PartyPal.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.R;
import com.example.PartyPal.adapters.HomeHorAdapter;
import com.example.PartyPal.adapters.HomeVerAdapter;
<<<<<<< Updated upstream
import com.example.PartyPal.adapters.UpdateVerticalRec;
import com.example.PartyPal.databinding.FragmentHomeBinding;
import com.example.PartyPal.models.HomeHorModel;
=======
>>>>>>> Stashed changes
import com.example.PartyPal.models.HomeVerModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements HomeVerAdapter.OnPartyLongClickListener {

<<<<<<< Updated upstream
    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;
=======
    private ArrayList<HomeVerModel> homeVerModelList;
    private HomeVerAdapter homeVerAdapter;
>>>>>>> Stashed changes

    ///////////////////////////vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

<<<<<<< Updated upstream
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
=======
        RecyclerView homeVerticalRec = root.findViewById(R.id.home_ver_rec);
        homeVerModelList = new ArrayList<>();
        homeVerAdapter = new HomeVerAdapter(getActivity(), homeVerModelList, this);
>>>>>>> Stashed changes


        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        return root;
    }

<<<<<<< Updated upstream
    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

=======
    private void fetchPartyData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                homeVerModelList.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // Retrieve data from the snapshot
                    String partyId = dataSnapshot.getKey(); // Get the unique ID of the party
                    String hostName = dataSnapshot.child("hostName").getValue(String.class);
                    String partyTitle = dataSnapshot.child("partyTitle").getValue(String.class);
                    String contactInformation = dataSnapshot.child("contactInformation").getValue(String.class);
                    String partyDescription = dataSnapshot.child("partyDescription").getValue(String.class);
                    String partyDate = dataSnapshot.child("partyDate").getValue(String.class);
                    String partyLocation = dataSnapshot.child("partyLocation").getValue(String.class);

                    // Create a HomeVerModel object with partyId
                    HomeVerModel party = new HomeVerModel(partyId, hostName, partyTitle, contactInformation, partyDescription, partyDate, partyLocation);

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
    public void onPartyLongClick(int position) {

        deleteParty(position);
>>>>>>> Stashed changes
    }

    private void deleteParty(int position) {
        if (position >= 0 && position < homeVerModelList.size()) {

            showDeleteConfirmationDialog(position);
        } else {
            Toast.makeText(getActivity(), "Invalid position", Toast.LENGTH_SHORT).show();
        }
    }

    private void showDeleteConfirmationDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Delete Party");
        builder.setMessage("Are you sure you want to delete this party?");

        builder.setPositiveButton("Yes", (dialog, which) -> {

            deleteConfirmedParty(position);
        });

        builder.setNegativeButton("No", (dialog, which) -> {

        });

        builder.show();
    }

    private void deleteConfirmedParty(int position) {
        if (position >= 0 && position < homeVerModelList.size()) {
            // Get the party ID from the selected position
            String partyIdToDelete = homeVerModelList.get(position).getPartyId();

            // Remove the party from the local list
            homeVerModelList.remove(position);
            homeVerAdapter.notifyItemRemoved(position);

            // Delete the party from Firebase
            deletePartyFromFirebase(partyIdToDelete);

            Toast.makeText(getActivity(), "Party deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Invalid position", Toast.LENGTH_SHORT).show();
        }
    }

    private void deletePartyFromFirebase(String partyId) {
        if (partyId != null) {
            DatabaseReference partyRef = databaseReference.child(partyId);
            partyRef.removeValue();
        }
    }

}
