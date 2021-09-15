package com.example.myproject.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.example.myproject.net.LogUtil;
import com.example.myproject.net.OkHttpUtil;
import com.example.myproject.util.SpzUtils;
import com.example.myproject.util.UtilManger;

//App类
public class App extends Application {
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        SpzUtils.init(sContext);
        OkHttpUtil.init(sContext);
        UtilManger.init(sContext);
        LogUtil.init();
    }

}

