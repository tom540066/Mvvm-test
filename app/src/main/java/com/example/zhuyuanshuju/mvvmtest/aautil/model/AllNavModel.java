package com.example.zhuyuanshuju.mvvmtest.aautil.model;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.kelin.mvvmlight.base.ViewModel;

/**
 * Created by zhuyuanshuju on 2018/3/13.
 */

public class AllNavModel implements ViewModel {
   private Context context;

   public AllNavModel(){};

   public AllNavModel(Context context){
      this.context = context;
   }

   public ObservableField<String> navTitle = new ObservableField<>();

   public void backClick(View view){
      ((Activity) view.getContext()).finish();
   }
}
