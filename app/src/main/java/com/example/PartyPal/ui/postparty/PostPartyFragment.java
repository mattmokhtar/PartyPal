package com.example.PartyPal.ui.postparty;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.PartyPal.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostPartyFragment extends Fragment {

    private EditText editTextPartyTitle;
    private EditText editTextHostName;
    private EditText editTextContactInfo;
    private EditText editTextPartyDescription;
    private EditText editTextDateTime;
    private EditText editTextLocation;

    private DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_postparty, container, false);

        editTextPartyTitle = root.findViewById(R.id.editTextPartyTitle);
        editTextHostName = root.findViewById(R.id.editTextHostName);
        editTextContactInfo = root.findViewById(R.id.editTextContactInfo);
        editTextPartyDescription = root.findViewById(R.id.editTextPartyDescription);
        editTextDateTime = root.findViewById(R.id.editTextDateTime);
        editTextLocation = root.findViewById(R.id.editTextLocation);

        Button btnSubmit = root.findViewById(R.id.btnSubmit);

        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("parties");

        btnSubmit.setOnClickListener(v -> {
            // Get user input from the form fields
            String partyTitle = editTextPartyTitle.getText().toString();
            String hostName = editTextHostName.getText().toString();
            String contactInformation = editTextContactInfo.getText().toString();
            String partyDescription = editTextPartyDescription.getText().toString();
            String partyDate = editTextDateTime.getText().toString();
            String partyLocation = editTextLocation.getText().toString();

            // Create a PartyModel object
            PostPartyModel partyModel = new PostPartyModel(partyTitle, hostName, contactInformation, partyDescription, partyDate, partyLocation);

            // Insert into Firebase Database
            String partyId = databaseReference.push().getKey();
            assert partyId != null;
            databaseReference.child(partyId).setValue(partyModel)
                    .addOnSuccessListener(aVoid -> {
                        Log.d("Tag", "Party added successfully");
                        Toast.makeText(getContext(), "Party added successfully", Toast.LENGTH_SHORT).show();

                        // Finish the current activity and restart it
                        getActivity().finish();
                        startActivity(getActivity().getIntent());
                    })
                    .addOnFailureListener(e -> {
                        Log.e("Tag", "Error adding party", e);
                        Toast.makeText(getContext(), "Error adding party", Toast.LENGTH_SHORT).show();
                    });
        });

        return root;
    }
}
