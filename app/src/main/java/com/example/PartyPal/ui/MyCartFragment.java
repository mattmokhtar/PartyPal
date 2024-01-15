package com.example.PartyPal.ui;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.PartyPal.R;
import com.example.PartyPal.SuccessActivity;
import com.example.PartyPal.adapters.CartAdapter;
import com.example.PartyPal.models.CartModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MyCartFragment extends Fragment {

    List<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;


    public MyCartFragment() {
        // Required empty public constructor
    }
    /////////START FINGERPRINT SENSOR///////////////
    private BiometricPrompt getPrompt(){
        Executor executor = ContextCompat.getMainExecutor(getActivity());
        BiometricPrompt.AuthenticationCallback callback = new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                notifyUser(errString.toString());
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

                //remove items from cart
                notifyUser("Authentication Success!");


                Intent intent = new Intent(getContext(), SuccessActivity.class);
                getActivity().startActivity(intent);

            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                notifyUser("Authentication Failed!");
            }
        };

        BiometricPrompt biometricPrompt = new BiometricPrompt(this, executor, callback);
        return biometricPrompt;
    }

    ///////////END FINGERPRINT SENSOR//////////////////

    private void notifyUser(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        list = new ArrayList<>();
        /*
        list.add(new CartModel(R.drawable.s1, "Order 1", "10", "4.5"));
        list.add(new CartModel(R.drawable.s2, "Order 2", "15", "3.5"));
        list.add(new CartModel(R.drawable.s3, "Order 3", "21", "5."));
        list.add(new CartModel(R.drawable.fav3, "Order 4", "9", "4.2"));
        list.add(new CartModel(R.drawable.ver3, "Order 5", "10", "4.3"));
        list.add(new CartModel(R.drawable.fav1, "Order 6", "11", "4.4"));

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
*/

        // Open the database
        String path = "/data/data/com.example.fooddelivery/databases/";
        SQLiteDatabase db = openOrCreateDatabase(path + "FoodOrdering.db", null);

        // Execute the query to retrieve the data
        Cursor cursor = db.rawQuery("SELECT id, cart_name, cart_price, cart_rating FROM cart", null);

        double totPrice = 0;
        // Loop through the results and add each row to the ArrayList
        if (cursor.moveToFirst()) {
            do {
                int cartId = cursor.getColumnIndex("id");
                int cartIndex = cursor.getColumnIndex("cart_name");
                int priceIndex = cursor.getColumnIndex("cart_price");
                int ratingIndex = cursor.getColumnIndex("cart_rating");

                String id = String.valueOf(cursor.getInt(cartId));
                String order = cursor.getString(cartIndex);
                String price = String.valueOf(cursor.getDouble(priceIndex));
                String rating = cursor.getString(ratingIndex);

                totPrice += Double.parseDouble(price);

               list.add(new CartModel(R.drawable.s1, id, order, price, rating));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);

        // Close the cursor
        cursor.close();

        // Close the database
        db.close();

        // Create the adapter and set it on the RecyclerView
        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);


        TextView totalPrice = view.findViewById(R.id.totalPrice);

        totalPrice.setText("RM" + String.valueOf(totPrice));

        Button button = view.findViewById(R.id.btnOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                        .setTitle("Verify Biometric")
                        .setDescription("Please confirm your identity to confirm order")
                        .setNegativeButtonText("Cancel")
                        .build();

                getPrompt().authenticate(promptInfo);
            }
        });



    return view;
    }
}