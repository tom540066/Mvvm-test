package com.example.zhuyuanshuju.mvvmtest.aautil.inter;

/**
 * 网络加载数据返回接口
 * @author 刘帅
 * */
public interface HttpValue<T> {
	void success(T data);
}
