package com.example.unscrambleapk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import com.example.unscrambleapk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Context context;

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.setVar(mainViewModel);
        context = getApplicationContext();

        binding.button.setOnClickListener((v) -> {
            mainViewModel.check(context,String.valueOf(binding.editTextTextPersonName.getText()));
        });

        binding.setLifecycleOwner(this);
        mainViewModel.generateString();

    }
}