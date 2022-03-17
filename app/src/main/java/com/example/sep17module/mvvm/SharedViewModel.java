package com.example.sep17module.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    MutableLiveData<String> data = new MutableLiveData<>();  //

    public MutableLiveData<String> getData() {
        return data;
    }

    public void setData(String name) {

        data.setValue(name);
    }
}
