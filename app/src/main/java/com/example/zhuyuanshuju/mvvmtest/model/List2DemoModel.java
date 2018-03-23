package com.example.zhuyuanshuju.mvvmtest.model;

import android.content.Context;
import android.content.Intent;

import com.andview.refreshview.XRefreshView;
import com.example.zhuyuanshuju.mvvmtest.aautil.adapter.BaseAdapter;
import com.example.zhuyuanshuju.mvvmtest.aautil.inter.HttpValue;
import com.example.zhuyuanshuju.mvvmtest.aautil.inter.OnItemClickListener;
import com.example.zhuyuanshuju.mvvmtest.aautil.model.AllListModel;
import com.example.zhuyuanshuju.mvvmtest.aautil.util.ToastUtils;
import com.example.zhuyuanshuju.mvvmtest.activity.DetailActivity;
import com.example.zhuyuanshuju.mvvmtest.bean.NewsBean;
import com.example.zhuyuanshuju.mvvmtest.bean.SimpleNewsBean;
import com.example.zhuyuanshuju.mvvmtest.http.HttpUtils;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;
import retrofit2.Call;

/**
 * Created by kelin on 16-4-25.
 * https://github.com/evant/binding-collection-adapter/tree/databinding-v2
 * https://github.com/XRecyclerView/XRecyclerView
 */
public class List2DemoModel extends AllListModel<SimpleNewsBean,ItemBinding> implements OnItemClickListener<SimpleNewsBean> {
    private Context context;
    private BaseAdapter adapter;

    public List2DemoModel(Context context,XRefreshView pull,BaseAdapter adapter){
        super(pull);
        this.context = context;
        this.adapter =adapter;
        adapter.listener=this;

    }

    @Override
    public void getData(final int page) {
        http.sendData(HttpUtils.getRetrofit().getNewsData1("惗好"), new HttpValue<NewsBean>() {
            @Override
            public void success( NewsBean data) {
                stopAllState(data,adapter);
                if(data!=null){
                    List<NewsBean.OthersBean> othersBeanList = data.getOthers();
                    if (othersBeanList != null && othersBeanList.size() > 0) {
                        for (NewsBean.OthersBean othersBean : othersBeanList) {
                            String thumbnail = othersBean.getThumbnail();
                            String name = othersBean.getName();
                            String description = othersBean.getDescription();

                            //构造Adapter所需的数据源
                            SimpleNewsBean simpleNewsBean = new SimpleNewsBean();
                            simpleNewsBean.itemViewType = 0;
                            simpleNewsBean.isVis.set(1);
                            simpleNewsBean.thumbnail.set(thumbnail);
                            simpleNewsBean.name.set(name);
                            simpleNewsBean.description.set(description);
                            adapter.addData(simpleNewsBean);

                        }
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void onItemClick(SimpleNewsBean viewModel, int point) {
        ToastUtils.show(context,point+"====");
        context.startActivity(new Intent(context, DetailActivity.class));
    }
}
