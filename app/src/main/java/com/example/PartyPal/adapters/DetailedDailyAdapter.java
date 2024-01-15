package com.example.PartyPal.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.DatabaseHelper;
import com.example.PartyPal.R;
import com.example.PartyPal.models.DetailedDailyModel;

import java.util.List;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {

    List<DetailedDailyModel> list;

    public DetailedDailyAdapter(List<DetailedDailyModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DetailedDailyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedDailyAdapter.ViewHolder holder, int position) {
            holder.imageView.setImageResource(list.get(position).getImage());
            holder.price.setText(list.get(position).getPrice());
            holder.name.setText(list.get(position).getName());
            holder.description.setText(list.get(position).getDescription());
            holder.timing.setText(list.get(position).getTiming());
            holder.rating.setText(list.get(position).getRating());

            String price = holder.price.getText().toString();


            holder.addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //create operation
                    DatabaseHelper db = new DatabaseHelper(v.getContext());
                    db.addToCart(holder.name.getText().toString(), holder.timing.getText().toString()
                            , holder.rating.getText().toString(), Double.parseDouble(price));
                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,price,description,rating,timing;

        Button addToCart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.detailed_img);
            price=itemView.findViewById(R.id.detailed_price);
            name=itemView.findViewById(R.id.detailed_name);
            description=itemView.findViewById(R.id.detailed_des);
            rating=itemView.findViewById(R.id.detailed_rating);
            timing=itemView.findViewById(R.id.detailed_timing);
            addToCart=itemView.findViewById(R.id.dailyAddToCart);

        }
    }
}
