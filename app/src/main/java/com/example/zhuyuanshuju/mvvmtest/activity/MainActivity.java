package com.example.zhuyuanshuju.mvvmtest.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zhuyuanshuju.mvvmtest.BR;
import com.example.zhuyuanshuju.mvvmtest.R;
import com.example.zhuyuanshuju.mvvmtest.model.MainViewModel;

public class MainActivity extends Activity {
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = new MainViewModel(this);

        binding.setVariable(BR.viewModel, model);


       // MainViewModel mon = new MainViewModel(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
