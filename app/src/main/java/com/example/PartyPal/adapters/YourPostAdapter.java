package com.example.PartyPal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.R;
import com.example.PartyPal.models.YourPostModel;

import java.util.List;

public class YourPostAdapter extends RecyclerView.Adapter<YourPostAdapter.ViewHolder> {

    private final List<YourPostModel> list;

    public YourPostAdapter(List<YourPostModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        YourPostModel yourPost = list.get(position);

        // Bind data to ViewHolder views
        holder.partyTitleTextView.setText(yourPost.getPartyTitle());
        holder.hostNameTextView.setText(yourPost.getHostName());
        holder.contactInformationTextView.setText(yourPost.getContactInformation());
        holder.partyDescriptionTextView.setText(yourPost.getPartyDescription());
        holder.partyDateTextView.setText(yourPost.getPartyDate());
        holder.partyLocationTextView.setText(yourPost.getPartyLocation());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0; // Check for null to avoid NullPointerException
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView partyTitleTextView, hostNameTextView, contactInformationTextView,
                partyDescriptionTextView, partyDateTextView, partyLocationTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize views from the layout
            partyTitleTextView = itemView.findViewById(R.id.partyTitle);
            hostNameTextView = itemView.findViewById(R.id.hostName);
            contactInformationTextView = itemView.findViewById(R.id.contactInformation);
            partyDescriptionTextView = itemView.findViewById(R.id.partyDescription);
            partyDateTextView = itemView.findViewById(R.id.partyDate);
            partyLocationTextView = itemView.findViewById(R.id.partyLocation);


        }
    }
}
