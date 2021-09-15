package com.example.myproject.base;

import java.util.List;

public interface HttpCallBack<T> {
    void onRequest();
    void onDataSuccess(T data);
    void onFailer(String msg);
    void onDataEmpty();
    void onListSuccess(List<T> list);
}
