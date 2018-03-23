package com.example.zhuyuanshuju.mvvmtest.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.example.zhuyuanshuju.mvvmtest.BR;
import com.example.zhuyuanshuju.mvvmtest.R;
import com.example.zhuyuanshuju.mvvmtest.aautil.adapter.BaseAdapter;
import com.example.zhuyuanshuju.mvvmtest.aautil.adapter.BaseViewHolder;
import com.example.zhuyuanshuju.mvvmtest.aautil.util.ToastUtils;
import com.example.zhuyuanshuju.mvvmtest.bean.SimpleNewsBean;


/**
 * 作者： 周旭 on 2017年10月17日 0017.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public class NewsAdapter extends BaseAdapter<SimpleNewsBean, BaseViewHolder> {

    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder onCreateVH(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.item_news2, parent, false);
        return new BaseViewHolder(dataBinding);
    }

    @Override
    public void onBindVH(BaseViewHolder baseViewHolder, int position) {
        ViewDataBinding binding = baseViewHolder.getBinding();
        binding.setVariable(BR.dataItem, mList.get(position));
        binding.setVariable(BR.position,position);
        binding.setVariable(BR.adapter,this);
        binding.setVariable(BR.listener,listener);
        binding.executePendingBindings(); //防止闪烁
    }



    /**
     * 点赞
     *
     * @param simpleNewsBean
     * @param position
     */
    public void click(SimpleNewsBean simpleNewsBean, int position) {
        if (simpleNewsBean.isGood.get()) {
            simpleNewsBean.isGood.set(false);
            ToastUtils.show(mContext, "取消点赞 position=" + position);
        } else {
            simpleNewsBean.isGood.set(true);
            ToastUtils.show(mContext, "点赞成功 position=" + position);
        }
    }
}
