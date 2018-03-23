package com.example.zhuyuanshuju.mvvmtest.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zhuyuanshuju.mvvmtest.R;
import com.example.zhuyuanshuju.mvvmtest.databinding.ActivityDetailBinding;
import com.example.zhuyuanshuju.mvvmtest.model.DetailModel;

/**
 * Created by zhuyuanshuju on 2018/3/13.
 */

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        DetailModel model = new DetailModel(this);
        binding.setViewModel(model);

    }
}
