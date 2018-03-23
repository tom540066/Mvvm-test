package com.example.zhuyuanshuju.mvvmtest.aautil.util;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.zhuyuanshuju.mvvmtest.aautil.con.Confign;

/**
 * Created by mj
 * on 2017/5/22.
 */

public class ToastUtils {

    private static Toast toast;

    /**
     * show toast
     *
     * @param context context
     * @param msg     message string
     */
    public static void show(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * show toast
     *
     * @param context context
     * @param msgId   message resource id
     */
    public static void show(Context context, int msgId) {
        if (toast == null) {
            toast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(msgId);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void log(String str){
        if(Confign.isLog)
            Log.i("tom_i",str);
    }

}
