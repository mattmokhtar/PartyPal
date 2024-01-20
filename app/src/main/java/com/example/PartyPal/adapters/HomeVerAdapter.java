package com.example.PartyPal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.R;
import com.example.PartyPal.models.HomeVerModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {

    private final ArrayList<HomeVerModel> list;

    // Firebase
    private final DatabaseReference databaseReference;

    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list) {
        this.list = list != null ? list : new ArrayList<>();
        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("parties");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeVerModel currentItem = list.get(position);

        holder.hostName.setText(currentItem.getHostName());
        holder.partyTitle.setText(currentItem.getPartyTitle());
        holder.contactInformation.setText(currentItem.getContactInformation());
        holder.partyDescription.setText(currentItem.getPartyDescription());
        holder.partyDate.setText(currentItem.getPartyDate());
        holder.partyLocation.setText(currentItem.getPartyLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView hostName, partyTitle, contactInformation, partyDescription, partyDate, partyLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hostName = itemView.findViewById(R.id.hostName);
            partyTitle = itemView.findViewById(R.id.partyTitle);
            contactInformation = itemView.findViewById(R.id.contactInformation);
            partyDescription = itemView.findViewById(R.id.partyDescription);
            partyDate = itemView.findViewById(R.id.partyDate);
            partyLocation = itemView.findViewById(R.id.partyLocation);
        }
    }
}
