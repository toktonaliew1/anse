package com.example.anse.mvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anse.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    public MutableLiveData<List<MainModel>> mutableLiveData = new MutableLiveData<>();
    public ArrayList<MainModel> list = new ArrayList<>();

    public ArrayList<MainModel> getList() {
        list.add(new MainModel("alex", "android 3"));
        list.add(new MainModel("alex", "android 3"));
        list.add(new MainModel("alex", "android 3"));
        list.add(new MainModel("alex", "android 3"));
        mutableLiveData.setValue(list);
        return list;
    }
}
