package com.example.PartyPal.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.PartyPal.R;
import com.example.PartyPal.adapters.DetailedDailyAdapter;
import com.example.PartyPal.models.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_deal_meal);

        String type = getIntent().getStringExtra("type");


        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.breakfast1, "Nasi Lemak", "Nasi Lemak UMP", "5.0", "5", "7am to 11am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.breakfast2, "Kuih-Muih", "Macam-macam ada", "4.4", "2", "8am to 9am"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.breakfast3, "Roti Canai", "Special Menu: Roti Sarang Burung", "4.5", "1.20", "7am to 10am"));
            dailyAdapter.notifyDataSetChanged();

        }
        if (type != null && type.equalsIgnoreCase("Lunch")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch1, "Nasi Kandar", "Nasi Kandar Terbaik UMP", "4.4", "20", "11am to 3pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch2, "Lauk Pauk", "Pelbagai Jenis Lauk Terhidang", "4.5", "10", "12am to 4pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch3, "Nasi Ayam", "Nasi Ayam Johor", "4.0", "8", "10am to 2pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.lunch4, "Nasi Kakwok", "Nasi Kakwok Kak Rozi", "4.2", "10", "11am to 2pm"));
            dailyAdapter.notifyDataSetChanged();

        }
        if (type != null && type.equalsIgnoreCase("Dinner")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dinner1, "Makanan Bergoreng", "Special Menu Nasi Goreng UMP", "4.4", "7", "7pm to 12pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dinner2, "Kuew Teow Specialist", "Pelbagai Jenis Kuew Teow", "4.5", "8", "7pm to 12pm"));
            dailyAdapter.notifyDataSetChanged();

        }
        if (type != null && type.equalsIgnoreCase("sweets")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1, "Gula-gula", "Macam-macam gula-gula disediakan", "3.4", "4", "10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2, "Donut Kak Rozi", "Donut Special", "4.4", "3", "10am to 9pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3, "Ice-Cream Project UMP", "Ice-Cream Terbaik Dari Ladang", "4.5", "5", "10am to 9pm"));
            dailyAdapter.notifyDataSetChanged();

        }
        if (type != null && type.equalsIgnoreCase("Coffee")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.c1, "Kopi 0 Tok Abah ", "Kopi Terbaik Ump", "4.4", "4", "10am to 6pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.c2, "Kopi Ais Kak Rozi", "Kopi Ais", "4.1", "3", "8am to 10pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.c3, "Ice Americano", "Ice Americano mantap", "4.5", "5", "7am to 10pm"));
            dailyAdapter.notifyDataSetChanged();
        }
        if (type != null && type.equalsIgnoreCase("Noodle")) {
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.t6, "Mee Kari Rokiyah UMP", "Mee Kari lagi Sedap Dari Maggi Kari", "4.2", "4", "11am to 2pm"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.t8, "Mee Bandung Syahmi Adli UMP", "Mee Bandung Orang Muar", "4.8", "3", "11am to 2pm"));

            dailyAdapter.notifyDataSetChanged();
        }
    }
}