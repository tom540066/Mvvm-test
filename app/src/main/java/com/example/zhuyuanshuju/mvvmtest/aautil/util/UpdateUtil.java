package com.example.zhuyuanshuju.mvvmtest.aautil.util;

import android.util.Log;

import com.example.zhuyuanshuju.mvvmtest.aautil.con.Confign;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Created by zhuyuanshuju on 2018/3/14.
 */

public class UpdateUtil {

    public static MultipartBody.Part [] initData(String [] path){
        return initData("file",path);
    }

    public static MultipartBody.Part [] initData(String key,String [] path){
        return  initData(new String[]{key},path);
    }

    public static MultipartBody.Part [] initData(String [] key,String [] path){

        MultipartBody.Part []  parts = new MultipartBody.Part[path.length];
        for(int i=0;i<path.length;i++ ){
            File file = new File(path[i]);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            if(key.length==1)
                parts[i] = MultipartBody.Part.createFormData(key[0], file.getName(), requestFile);
            else
                parts[i] = MultipartBody.Part.createFormData(key[i], file.getName(), requestFile);
        }
        return parts;
    }

    public static MultipartBody.Part  initData(String  key,String  path){
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData(key, file.getName(), requestFile);
        return part;
    }

    /*
    * 下载用的
    *
    * 其他
    * https://github.com/Tamicer/FastDownloader
    * */
    private boolean writeResponseBodyToDisk(ResponseBody body,String path) {
        try {
            File futureStudioIconFile = new File(Confign.sdDir  + path);

            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                byte[] fileReader = new byte[1024];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    ToastUtils.log("file download: " + fileSizeDownloaded + " of " + fileSize);
                }
                outputStream.flush();
                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }


}
