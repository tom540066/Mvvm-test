package com.example.zhuyuanshuju.mvvmtest.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.databinding.ViewDataBinding;
import android.util.Log;

import com.example.zhuyuanshuju.mvvmtest.BR;
import com.example.zhuyuanshuju.mvvmtest.R;
import com.example.zhuyuanshuju.mvvmtest.aautil.util.ToastUtils;
import com.example.zhuyuanshuju.mvvmtest.databinding.ActivityListBinding;
import com.example.zhuyuanshuju.mvvmtest.model.ListDemoModel;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

/**
 * Created by zhuyuanshuju on 2018/3/7.
 */

public class ListActivity extends Activity implements  XRecyclerView.LoadingListener {

    private ActivityListBinding binding;
    private ListDemoModel listDemoModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this, R.layout.activity_list);
        listDemoModel = new ListDemoModel(this, binding.pull,R.layout.item_news);
        binding.setViewModel(listDemoModel);
        listDemoModel.startRefresh();
        //initRecyclerView();

       // onRefresh();

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
        //listDemoModel.loadNewsData(1,null);
    }

    @Override
    public void onLoadMore() {
        ToastUtils.show(this,"1231111");
//        binding.newsRv.loadMoreComplete(); //结束加载
//        binding.newsRv.refreshComplete(); //结束刷新
    }


}
