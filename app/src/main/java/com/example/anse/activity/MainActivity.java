package com.example.anse.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.anse.mvm.MainViewModel;
import com.example.anse.adapter.Adapter;
import com.example.anse.databinding.ActivityMainBinding;
import com.example.anse.model.MainModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    MainViewModel viewModel;
    private Adapter adapter = new Adapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        addObserver();
        setupListener();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.homeRecycler.setAdapter(adapter);
    }

    private void addObserver() {
        viewModel.mutableLiveData.observe(this, new Observer<List<MainModel>>() {
            @Override
            public void onChanged(List<MainModel> mainModels) {
                adapter.setData(mainModels);
            }
        });
    }

    private void setupListener() {
        binding.displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addObserver();
                viewModel.getList();
                binding.displayBtn.setVisibility(View.GONE);
            }
        });
    }
}