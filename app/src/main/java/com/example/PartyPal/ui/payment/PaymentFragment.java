package com.example.PartyPal.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.PartyPal.R;

public class PaymentFragment extends Fragment {



        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

            View root = inflater.inflate(R.layout.fragment_payment,container,false);


            return root;
        }


}
