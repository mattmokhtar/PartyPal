package com.example.PartyPal.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.R;
import com.example.PartyPal.models.HomeHorModel;
import com.example.PartyPal.models.HomeVerModel;

import java.util.ArrayList;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {


    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza Kak Rozi", "10:00-23:00", "4.8", "Min-RM30"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza HUT", "9:00-23:00", "4.5", "Min-RM40"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza PAP", "9:30-22:00", "5.0", "Min-RM45"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Pizza REDONE", "10:30-23:00", "4.8", "Min-RM30"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
                ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                if (position == 0) {


                    homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "PIZZA KAK ROZI", "10:00-23:00", "4.8", "Min-RM30"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "PIZZA REDONE", "9:00-23:00", "4.5", "Min-RM40"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "PIZZA PAP", "9:30-22:00", "5.0", "Min-RM45"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "PIZZA KAFE ARAB", "10:30-23:00", "4.8", "Min-RM30"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 1) {
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "BURGER KAK ROZI", "17:00-23:00", "4.8", "Min-RM5"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger2, "BURGER REDONE", "16:00-23:00", "4.5", "Min-RM7"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger4, "BURGER PAP", "20:30-23:30", "5.0", "Min-RM4"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 2) {
                    homeVerModels.add(new HomeVerModel(R.drawable.fries1, "FRIES KAK ROZI", "06:00-23:00", "4.8", "Min-RM4"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries2, "FRIES REDONE", "10:00-23:00", "4.5", "Min-RM5"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries3, "FRIES PAP", "08:30-23:30", "5.0", "Min-RM6"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries4, "FRIES KAFE ARAB", "09:30-23:30", "5.0", "Min-RM4-"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 3) {
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "ICE CREAM KAK ROZI", "06:00-23:00", "4.8", "Min-RM2"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "ICE CREAM REDONE", "10:00-23:00", "4.5", "Min-RM2"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "ICE CREAM PAP", "08:30-23:30", "5.0", "Min-RM3"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream4, "ICE CREAM ARABIC", "09:30-23:30", "5.0", "Min-RM2-"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 4) {
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich1, "SANDWICH KAK ROZI", "06:00-23:00", "4.8", "Min-RM3"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich2, "SANDWICH REDONE", "10:00-23:00", "4.5", "Min-RM2"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich3, "SANDWISH PAP", "08:30-23:30", "5.0", "Min-RM2"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich4, "SANDWISH KAFE ARAB", "09:30-23:30", "5.0", "Min-RM4-"));

                    updateVerticalRec.callBack(position, homeVerModels);
                }
                else if (position == 5) {

                    homeVerModels.add(new HomeVerModel(R.drawable.t1,"Waffle","Waffle Biasa and Special","4.5","Min-RM10"));
                    homeVerModels.add(new HomeVerModel(R.drawable.t2,"Jagung Corn","Special Jagung Cup Cheese","4.4","Min-RM5"));
                    homeVerModels.add(new HomeVerModel(R.drawable.t3,"Spagetti Specialist","Pelbagai Jenis Spagetti Disediakan","4.0","Min-RM10"));
                    homeVerModels.add(new HomeVerModel(R.drawable.t4,"Satay Tok abah","Satay Wagyu Available","4.5","Min-RM15"));
                    homeVerModels.add(new HomeVerModel(R.drawable.t5,"Sata Terengganu","Makanan Dari Terengganu Ada disini","4.5","Min-RM9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.t6,"Mee Kari Rokiyah UMP","Mee Kari lagi Sedap Dari Maggi Kari","4.2","Min-RM9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.t8,"Mee Bandung Syahmi Adli UMP","Mee Bandung Orang Muar","4.8","Min-RM10"));

                    updateVerticalRec.callBack(position, homeVerModels);
                }
                else if (position == 6) {

                    homeVerModels.add(new HomeVerModel(R.drawable.c1, "Kopi 0 Tok Abah ", "4.4", "4", "Min-RM10"));
                    homeVerModels.add(new HomeVerModel(R.drawable.c2, "Kopi Ais Kak Rozi", "4.1", "3", "Min-RM10"));
                    homeVerModels.add(new HomeVerModel(R.drawable.c3, "Ice Americano", "4.5", "5", "Min-RM10"));

                    updateVerticalRec.callBack(position, homeVerModels);
                }
            }
        });

        if (select) {
            if (position == 0) {
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
                select =false;
            }
        } else {
            if (row_index == position) {
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
            } else {
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
            }

        }
    }





    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}

