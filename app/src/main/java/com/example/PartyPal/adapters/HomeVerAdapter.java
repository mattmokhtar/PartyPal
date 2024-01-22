package com.example.PartyPal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.DatabaseHelper;
import com.example.PartyPal.R;
import com.example.PartyPal.databinding.BottomSheetLayoutBinding;
import com.example.PartyPal.models.HomeVerModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {

<<<<<<< Updated upstream

    private BottomSheetDialog bottomSheetDialog;
    Context context;
    ArrayList<HomeVerModel> list;

    public HomeVerAdapter(Context context,ArrayList<HomeVerModel>list){
        this.context = context;
        this.list = list;
=======
    private final ArrayList<HomeVerModel> list;
    private final DatabaseReference databaseReference;
    private final OnPartyLongClickListener onPartyLongClickListener;

    public interface OnPartyLongClickListener {
        void onPartyLongClick(int position);
    }

    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list, OnPartyLongClickListener listener) {
        this.list = list != null ? list : new ArrayList<>();
        this.onPartyLongClickListener = listener;
        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("parties");
>>>>>>> Stashed changes
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
<<<<<<< Updated upstream
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
=======
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false), onPartyLongClickListener);
>>>>>>> Stashed changes
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        final String mName = list.get(position).getName().toString();
        final String mTiming = list.get(position).getTiming();
        final String mRating = list.get(position).getRating();
        final String mPrice = list.get(position).getPrice();
        final int mImage = list.get(position).getImage();


        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
                sheetView.findViewById(R.id.btn_add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Map<String, Object> cartData = new HashMap<>();
                        cartData.put("name", mName);
                        cartData.put("timing", mTiming);
                        cartData.put("rating", mRating);
                        cartData.put("price", mPrice);

                        String price = mPrice.substring(mPrice.indexOf("RM") + 2);

                        //create operation
                        DatabaseHelper db = new DatabaseHelper(context);
                        db.addToCart(mName, mTiming, mRating, Double.parseDouble(price));

                       // Toast.makeText(context,"Added to Cart",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_name);
                TextView bottomPrice = sheetView.findViewById(R.id.bottom_price);
                TextView bottomRating = sheetView.findViewById(R.id.bottom_rating);

                bottomName.setText(mName);
                bottomPrice.setText(mPrice);
                bottomRating.setText(mRating);
                bottomImg.setImageResource(mImage);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

<<<<<<< Updated upstream
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,timing,rating,price;
        public ViewHolder(@NonNull View itemView){
=======
    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView hostName, partyTitle, contactInformation, partyDescription, partyDate, partyLocation;

        public ViewHolder(@NonNull View itemView, final OnPartyLongClickListener listener) {
>>>>>>> Stashed changes
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.name);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);


<<<<<<< Updated upstream
=======
            hostName = itemView.findViewById(R.id.hostName);
            partyTitle = itemView.findViewById(R.id.partyTitle);
            contactInformation = itemView.findViewById(R.id.contactInformation);
            partyDescription = itemView.findViewById(R.id.partyDescription);
            partyDate = itemView.findViewById(R.id.partyDate);
            partyLocation = itemView.findViewById(R.id.partyLocation);

            // Set long click listener on the item view
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onPartyLongClick(position);
                            return true; // Consume the long click event
                        }
                    }
                    return false;
                }
            });
>>>>>>> Stashed changes
        }

    }

}
