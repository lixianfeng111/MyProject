package com.example.myproject.net;


import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 请求头拦截器
 */
public class OkHeaderIntorceptor implements Interceptor {

    private Context mContext;

    public OkHeaderIntorceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences user = mContext.getSharedPreferences("user", Context.MODE_PRIVATE);
        int userId = user.getInt("userId", -1);
        String sessionId = user.getString("sessionId", "");
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("Content-Type", "application/x-www-form-urlencoded");
        builder.addHeader("ak", "0110010010000");
        builder.addHeader("userId",userId+"");
        builder.addHeader("sessionId", sessionId);
        request = builder.build();
        return chain.proceed(request);
    }
}
