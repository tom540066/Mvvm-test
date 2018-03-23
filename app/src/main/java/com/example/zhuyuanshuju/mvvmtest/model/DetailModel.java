package com.example.zhuyuanshuju.mvvmtest.model;

import android.content.Context;

import com.example.zhuyuanshuju.mvvmtest.aautil.model.AllNavModel;
import com.kelin.mvvmlight.base.ViewModel;

/**
 * Created by zhuyuanshuju on 2018/3/13.
 */

public class DetailModel extends AllNavModel {

    public DetailModel(Context context){
        navTitle.set("详情");
    }

}
