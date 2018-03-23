package com.example.zhuyuanshuju.mvvmtest.config;

import android.app.Application;

import com.example.zhuyuanshuju.mvvmtest.aautil.util.NetworkUtils;
import com.example.zhuyuanshuju.mvvmtest.http.HttpUtils;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by zhuyuanshuju on 2018/2/9.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        HttpUtils.init(this);
        NetworkUtils.init(this);
    }
}