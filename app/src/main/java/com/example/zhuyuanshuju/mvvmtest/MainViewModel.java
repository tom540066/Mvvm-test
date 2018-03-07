package com.example.zhuyuanshuju.mvvmtest;

import android.content.Context;
import android.databinding.ObservableField;

import com.kelin.mvvmlight.base.ViewModel;
import com.kelin.mvvmlight.command.ReplyCommand;

/**
 * Created by kelin on 16-4-28.
 */
public class MainViewModel implements ViewModel {
    // Token to Messenger append package name to be unique

    //context
    private Context context;

    // viewModel for recycler header viewPager
    public final ObservableField<String> imageUrl = new ObservableField<>();

    public ReplyCommand btnClick = new ReplyCommand(() -> {
        imageUrl.set("https://ss0.baidu.com/73F1bjeh1BF3odCf/it/u=2948899353,3289346405&fm=85&s=55162C726B4A504D586C8D53020010F3");
    });


    public MainViewModel(Context context) {
        this.context = context;
        imageUrl.set("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=314432927,1563517790&fm=27&gp=0.jpg");


    }
}
