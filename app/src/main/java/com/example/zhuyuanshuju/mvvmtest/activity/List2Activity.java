package com.example.zhuyuanshuju.mvvmtest.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zhuyuanshuju.mvvmtest.R;
import com.example.zhuyuanshuju.mvvmtest.aautil.util.ToastUtils;
import com.example.zhuyuanshuju.mvvmtest.adapter.NewsAdapter;
import com.example.zhuyuanshuju.mvvmtest.databinding.ActivityList2Binding;
import com.example.zhuyuanshuju.mvvmtest.model.List2DemoModel;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by zhuyuanshuju on 2018/3/7.
 */

public class List2Activity extends Activity implements  XRecyclerView.LoadingListener {

    private ActivityList2Binding binding;
    private List2DemoModel list2DemoModel;
    public NewsAdapter adapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this, R.layout.activity_list2);

        adapter = new NewsAdapter(this);
        list2DemoModel = new List2DemoModel(this,binding.pull,adapter);
        binding.setViewModel(list2DemoModel);
        binding.newsRv.setAdapter(adapter);


        //initRecyclerView();

       // binding.pull.startRefresh();

    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {

//        binding.newsRv.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
//        binding.newsRv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
//        binding.newsRv.setArrowImageView(R.mipmap.pull_down_arrow);
//        binding.newsRv.setLoadingListener(this);
//       // binding.newsRv.loadMoreComplete();
//        binding.newsRv.refresh();
    }

    @Override
    public void onRefresh() {
        list2DemoModel.getData(1);
        //listDemoModel.loadNewsData(1,null);
    }

    @Override
    public void onLoadMore() {
        ToastUtils.show(this,"1231111");
//        binding.newsRv.loadMoreComplete(); //结束加载
//        binding.newsRv.refreshComplete(); //结束刷新
    }


}
