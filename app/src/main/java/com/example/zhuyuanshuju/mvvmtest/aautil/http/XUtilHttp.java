package com.example.zhuyuanshuju.mvvmtest.aautil.http;

import android.util.Log;

import com.example.zhuyuanshuju.mvvmtest.aautil.inter.HttpValue;
import com.example.zhuyuanshuju.mvvmtest.aautil.util.ToastUtils;
import com.example.zhuyuanshuju.mvvmtest.bean.NewsBean;
import com.example.zhuyuanshuju.mvvmtest.bean.SimpleNewsBean;
import com.example.zhuyuanshuju.mvvmtest.http.HttpUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

public class XUtilHttp {
    private final static XUtilHttp xUtilHttp = new XUtilHttp();
    private String paramType = ",userId,userType,company_id,pageSize,";

    public static XUtilHttp getIntenter() {
        return xUtilHttp;
    }
    Disposable d1;

    public <T> Call<T> sendData (Call<T> call, HttpValue<T> suValue){

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                suValue.success(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                suValue.success(null);
            }
        });



        HttpUtils.getRetrofit().getBlogs().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).doOnDispose(() ->{
            ToastUtils.log("doOnDispose===zhixing");
        })
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        ToastUtils.log("Disposable===zhixing");
                        d1= d;
                    }

                    @Override
                    public void onNext(NewsBean result) {
                        ToastUtils.log("onNext===zhixing");
                        ToastUtils.log((result==null)+"==");
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.log("onError===zhixing");
                    }

                    @Override
                    public void onComplete() {
                        ToastUtils.log("onComplete===zhixing");
                    }

                });
       // d1.dispose();

        return call;



      //  call.cancel();

    }




    public void cancel(Call call){
        call.cancel();
    }
}
