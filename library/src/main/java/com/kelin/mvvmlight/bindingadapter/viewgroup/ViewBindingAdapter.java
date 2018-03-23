package com.kelin.mvvmlight.bindingadapter.viewgroup;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kelin.mvvmlight.base.ViewModel;

import me.tatarka.bindingcollectionadapter2.ItemBinding;


/**
 * Created by kelin on 16-3-24.
 */
public final class ViewBindingAdapter {

    //  @BindingAdapter(value = {"itemView", "viewModels"}, requireAll = false)
    @BindingAdapter({"itemView","viewModels"})
    public static void addViews(ViewGroup viewGroup, final ItemBinding itemView, final ObservableList<ViewModel> viewModels) {
        if (viewModels != null && !viewModels.isEmpty()) {
            viewGroup.removeAllViews();
            for (ViewModel viewModel : viewModels) {
                ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        itemView.layoutRes(), viewGroup, true);
                binding.setVariable(itemView.variableId(), viewModel);
            }
        }
    }
}

