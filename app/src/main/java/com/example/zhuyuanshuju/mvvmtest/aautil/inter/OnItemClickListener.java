package com.example.zhuyuanshuju.mvvmtest.aautil.inter;

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

public interface  OnItemClickListener<T> {
    void onItemClick(T viewModel,int point);
}