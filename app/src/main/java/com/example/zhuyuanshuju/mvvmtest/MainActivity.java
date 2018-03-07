package com.example.zhuyuanshuju.mvvmtest;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = new MainViewModel(this);

        binding.setVariable(com.example.zhuyuanshuju.mvvmtest.BR.viewModel, model);


       // MainViewModel mon = new MainViewModel(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
