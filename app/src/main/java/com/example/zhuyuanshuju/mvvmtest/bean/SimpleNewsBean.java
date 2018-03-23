package com.example.zhuyuanshuju.mvvmtest.bean;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.example.zhuyuanshuju.mvvmtest.aautil.model.ItemViewModel;
import com.kelin.mvvmlight.base.ViewModel;

/**
 * 作者： 周旭 on 2017年10月17日 0017.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public class SimpleNewsBean extends ItemViewModel {
    //context
    private Context context;

    public ObservableInt color = new ObservableInt();
    public ObservableField<String> thumbnail = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableInt id = new ObservableInt();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableBoolean isGood = new ObservableBoolean(); //是否点赞
    public ObservableInt isVis = new ObservableInt(); //是否隐藏

    /**
     * 点赞
     *
     * @param simpleNewsBean
     * @param position
     */
    public void click(SimpleNewsBean simpleNewsBean, int position) {
        if (simpleNewsBean.isGood.get()) {
            simpleNewsBean.isGood.set(false);
            //ToastUtils.show(mContext, "取消点赞 position=" + position);
        } else {
            simpleNewsBean.isGood.set(true);
            //ToastUtils.show(mContext, "点赞成功 position=" + position);
        }
    }
}
