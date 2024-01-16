package com.example.PartyPal.ui.postparty;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PostPartyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PostPartyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}