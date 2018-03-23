package com.example.zhuyuanshuju.mvvmtest.aautil.activity;

import com.andview.refreshview.XRefreshView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

public abstract class ACActivity {

    public abstract  void getData();

//    public int page=0;
//    public Callback.Cancelable req;
//    public XRefreshView pull;
//    public XUtilHttp http=XUtilHttp.getIntenter();
//    public SharedPreXML xml = SharedPreXML.getIntenter();
//    public ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
//
//    public void init(){
//        pull = (XRefreshView) findViewById(R.id.pull);
//        pull.setPullLoadEnable(true);
//        pull.setAutoLoadMore(false);
//        //pull.setPinnedTime(1000);
//        pull.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
//
//            @Override
//            public void onRefresh() {
//                page=1;
//                getData();
//                //refreshView.stopRefresh();
//
//            }
//
//            @Override
//            public void onLoadMore(boolean isSlience) {
//                page++;
//                getData();
//                //refreshView.stopLoadMore();
//            }
//
//            @Override
//            public void onRelease(float direction) {
//                super.onRelease(direction);
//            }
//        });
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        reqCancel();
//    }
//
//    public void reqCancel(){
//        if (req!=null){
//            req.cancel();
//            req=null;
//        }
//    }
}
