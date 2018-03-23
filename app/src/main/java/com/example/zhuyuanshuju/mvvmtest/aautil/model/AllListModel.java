package com.example.zhuyuanshuju.mvvmtest.aautil.model;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.andview.refreshview.XRefreshView;
import com.example.zhuyuanshuju.mvvmtest.BR;
import com.example.zhuyuanshuju.mvvmtest.aautil.adapter.BaseAdapter;
import com.example.zhuyuanshuju.mvvmtest.aautil.http.XUtilHttp;
import com.example.zhuyuanshuju.mvvmtest.aautil.inter.OnItemClickListener;
import com.example.zhuyuanshuju.mvvmtest.aautil.inter.ViewModelItemClickListener;
import com.kelin.mvvmlight.base.ViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

public abstract class AllListModel<T, D> extends AllNavModel {

    public ObservableList<T> itemViewModel = new ObservableArrayList<>();
    public D itemView;

    public abstract void getData(int page);
    public XRefreshView pull;

    // private int [] layout;
    //public Object itemView1;
    public AllListModel(){}

    public AllListModel(XRefreshView pull){
        this.pull = pull;
        init();
    }

    public AllListModel(XRefreshView pull, int... layout) {
        this.pull = pull;
        init();
        if (layout.length == 1)
            itemView = (D) ItemBinding.<T>of(BR.dataItem, layout[0]).bindExtra(BR.listener, listener);
        else
            itemView = (D) new OnItemBind() {
                @Override
                public void onItemBind(ItemBinding itemView, int position, Object itemViewModel) {
                    itemView.set(BR.dataItem, layout[((ItemViewModel) itemViewModel).itemViewType]);
                    itemView.bindExtra(BR.listener, listener);
                }
            };
    }

//    public D itemView(){
//        if(layout.length==1)
//            return (D)ItemBinding.<T>of(BR.dataItem,layout[0]).bindExtra(BR.listener, listener);
//        return (D)new OnItemBind<T>() {
//            @Override
//            public void onItemBind(ItemBinding itemView, int position, Object itemViewModel) {
//                itemView.set(BR.dataItem,layout[((ItemViewModel) itemViewModel).itemViewType]);
//                itemView.bindExtra(BR.listener, listener);
//            }
//        };
//    }


    private ViewModelItemClickListener listener = new ViewModelItemClickListener<T>() {
        @Override
        public void onItemClick(T viewModel) {
            if (listener1 != null)
                listener1.onItemClick(viewModel, itemViewModel.indexOf(viewModel));
        }

    };

    private OnItemClickListener listener1;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener1 = listener;
    }


    private void init() {
        initRefresh(pull);
    }

    private int page=1;
    public XUtilHttp http = XUtilHttp.getIntenter();
    private void initRefresh(XRefreshView pull) {
        if(pull==null) return;
        pull.setPullLoadEnable(true);
        pull.setAutoLoadMore(false);
        //pull.setPinnedTime(1000);
        pull.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {

            @Override
            public void onRefresh() {
                page = 1;
               // itemViewModel.clear();
                getData(page);
                //refreshView.stopRefresh();

            }

            @Override
            public void onLoadMore(boolean isSlience) {
                page++;
                getData(page);
                //refreshView.stopLoadMore();
            }

            @Override
            public void onRelease(float direction) {
                super.onRelease(direction);
            }
        });
    }

    public void startRefresh(){
        if(pull!=null)
        pull.startRefresh();
    }

    public void stopAllState(){
        if(pull!=null)pull.stopAllState();
    }

    public void stopAllState(Object t){
        stopAllState();
        if(page==1) itemViewModel.clear();
        errorPage(t);
    }
    public void stopAllState(Object t,BaseAdapter adapter){

        stopAllState();
        if(page==1){ adapter.clearData();
            adapter.notifyDataSetChanged();
        }
        errorPage(t);
    }

    public void errorPage(Object t){
        if(t==null && page>0) page--;
    }
}
