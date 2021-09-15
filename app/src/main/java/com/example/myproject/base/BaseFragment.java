package com.example.myproject.base;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * baseFragment
 */
@SuppressLint("NewApi")
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    protected T miBasePresenter;
    public AppCompatActivity mcompatActivity;
    protected String TAG = "";
    protected View view;
    protected boolean isInitData = false;
    private StatusView mStatusView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mcompatActivity = (AppCompatActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(initLayoutId(), container, false);
        initStatuView(view);
        initVariable();
        //初始化视图
        initView();
        return mStatusView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        miBasePresenter = initPresenter();
        //初始化点击事件
        initListener();
        if (getUserVisibleHint() && !isInitData) {
            initData();
            isInitData = true;
        }
    }

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public abstract int initLayoutId();

    //初始化变量
    public abstract void initVariable();

    public abstract T initPresenter();

    private StatusView initStatuView(View view) {
        mStatusView = new StatusView.Builder(getActivity())
                .contentView(view)
                .emptyId(R.layout.layout_empity2)
                .erroryId(R.layout.layout_error)
                .loadingId(R.layout.layout_loading)
                .build();
        return mStatusView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (view != null) {
                if (!isInitData) {
                    //加载数据
                    initData();
                    isInitData = true;
                } else {
                    //调用显示方法
                    onVisiable();
                }
            }
        }
    }

    protected void onVisiable() {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mcompatActivity != null) {
            mcompatActivity = null;
        }
    }

    //加载空布局    方便统一处理
    public void showEmptyLayout() {
        mStatusView.showEmpty();
    }

    //加载错误的布局
    public void showErrorLayout() {
        mStatusView.showError();
    }

    //显示正在加载布局
    public void showLoadingLayout() {
        mStatusView.showLoading();
    }

    //显示内容
    public void showContent() {
        mStatusView.showContent();
    }
}
