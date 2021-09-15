package com.example.myproject.net;
import android.content.Context;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by 枫叶🍁 on 2019/1/21 19:37
 * Email：3507801049@qq.com
 * Role:
 */
public class OkHttpUtil {

    private static OkHttpClient sOkHttpClient;


    public static void init(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(3000, TimeUnit.MILLISECONDS);
        builder.writeTimeout(3000, TimeUnit.MILLISECONDS);
        builder.connectTimeout(3000, TimeUnit.MILLISECONDS);
        builder.addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                if (message != null) {
                    if (message.startsWith("{") || message.startsWith("[")) {
                        LogUtil.json(message);
                    } else {
                        LogUtil.d(message);
                    }
                }
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY));
        builder.addInterceptor(new OkLogIntorceptor());
        builder.addInterceptor(new OkHeaderIntorceptor(context));
        sOkHttpClient = builder.build();
    }
    public static OkHttpClient getInstance()  {
        if (sOkHttpClient == null) {
            new OkHttpUtil();
        }
        return sOkHttpClient;
    }

}
