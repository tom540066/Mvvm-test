package com.ls.tomlibrary.model;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.kelin.mvvmlight.base.ViewModel;
import com.ls.tomlibrary.BR;
import com.ls.tomlibrary.confign.Config;
import com.ls.tomlibrary.inter.OnItemClickListener;
import com.ls.tomlibrary.inter.ViewModelItemClickListener;

import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * Created by zhuyuanshuju on 2018/3/12.
 */

public class AllListModel <T> implements ViewModel {

    private Context context;
    public ObservableList<T> itemViewModel = new ObservableArrayList<>(); ;
    public ItemBinding<T> itemView;
    public OnItemBind<T> itemView1;



    public AllListModel (Context context,int layout){
        init();
        //itemView = ItemBinding.of(BR.dataItem,layout);
        itemView = ItemBinding.<T>of(Config.itemLayout, layout)
                .bindExtra(Config.itemListen, listener);

    }

    public AllListModel(Context context, final int ...layout){
        init();
        itemView1 = new OnItemBind() {
            @Override
            public void onItemBind(ItemBinding itemView, int position, Object itemViewModel) {
                itemView.set(Config.itemLayout, layout[((ItemViewModel) itemViewModel).itemViewType]);
                itemView.bindExtra(Config.itemListen, listener);
            }
        };
    }

    private ViewModelItemClickListener listener = new ViewModelItemClickListener<T>() {
        @Override
        public void onItemClick(T viewModel ) {
            if(listener1!=null)
                listener1.onItemClick(viewModel,itemViewModel.indexOf(viewModel));
        }

    };

    private OnItemClickListener listener1;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener1 = listener;
    }


    private void init (){
        this.context=context;
    }
}
