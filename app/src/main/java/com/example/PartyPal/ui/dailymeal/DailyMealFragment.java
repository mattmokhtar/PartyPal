package com.example.PartyPal.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PartyPal.R;
import com.example.PartyPal.adapters.DailyMealAdapter;
import com.example.PartyPal.models.DailyMealModel;

import java.util.ArrayList;
import java.util.List;

public class DailyMealFragment extends Fragment {

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.daily_meal_fragment,container,false);

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();


        dailyMealModels.add(new DailyMealModel(R.drawable.breakfast,"Breakfast","30% OFF","All happiness depends on a leisurely breakfast.","breakfast"));
        dailyMealModels.add(new DailyMealModel(R.drawable.lunch,"Lunch","20% OFF","I believe in stopping work and eating lunch.","lunch"));
        dailyMealModels.add(new DailyMealModel(R.drawable.dinner,"Dinner","10% OFF","Dinner is better when we eat together.","dinner"));
        dailyMealModels.add(new DailyMealModel(R.drawable.sweets,"Sweets","5% OFF","You can't buy happiness, but you can buy dessert and that's kind of the same thing.","sweets"));
        dailyMealModels.add(new DailyMealModel(R.drawable.coffe,"Coffee","25% OFF","Three cups of coffee a day keeps the doctor away!","coffe"));
        dailyMealModels.add(new DailyMealModel(R.drawable.noodle,"Noodle","2% OFF","Heavenly taste in every slurp","Noodle"));

        dailyMealAdapter = new DailyMealAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();


        return root;
    }

}