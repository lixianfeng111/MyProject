package com.example.myproject.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.R;
import com.example.myproject.receiver.NetReceiver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * baseActivity
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements NetReceiver.NetStatuMonitor {
    protected T miBasePresenter;
    private StatusView statusView;
    private NetReceiver netBroadcastReceiver;
    private boolean netStatus;
    private ErrorView errorView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        errorView = new ErrorView(this);
        ((ViewGroup) getWindow().getDecorView()).addView(errorView);
        if (initLayoutId() != 0) {
            initVariable();
            setContentView(initLayoutId());
            setStatuBarColor(R.color.themcolor);
            miBasePresenter = initPresenter();
            initView();
//            AppManager.getAppManager().addActivity(this);
            initData();
            initListener();
            //注册广播
            if (netBroadcastReceiver == null) {
                netBroadcastReceiver = new NetReceiver();
                IntentFilter filter = new IntentFilter();
                filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
                registerReceiver(netBroadcastReceiver, filter);
                //设置监听
                netBroadcastReceiver.setNetStatuMonitor(this);
            }

        } else {
            finish();
        }
    }

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public abstract int initLayoutId();

    //初始化变量
    public abstract void initVariable();

    public abstract T initPresenter();

    //设置沉浸式状态栏
    public void setStatuBarColor(int color) {
//        UltimateBar.newColorBuilder().statusColor(color);
        UltimateBar.newImmersionBuilder().applyNav(false).build(this).apply();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initStatuView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        View inflate = View.inflate(this, layoutResID, null);
        statusView = initStatuView(inflate);
        super.setContentView(statusView);

    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        statusView = initStatuView(view);
        super.setContentView(view, params);
    }

    private StatusView initStatuView(View content) {
        StatusView.Builder builder = new StatusView.Builder(this);
        statusView = builder.contentView(content)
                .emptyId(R.layout.layout_empity2)
                .erroryId(R.layout.net)
                .loadingId(R.layout.layout_loading)
                .build();
        return statusView;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    //销毁
    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (miBasePresenter != null) {
            miBasePresenter.onDestory();
        }
    }

    /**
     * ondestory中取消注册
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销广播
        if (netBroadcastReceiver!=null){
            unregisterReceiver(netBroadcastReceiver);
        }
    }

    @Override
    public void onNetChange(boolean netStatus) {
        this.netStatus = netStatus;
        isNetConnect();
    }

    /**
     * 监听网络状态做出相应改变
     */
    private void isNetConnect() {
        if (netStatus) {
            errorView.setVisibility(View.GONE);
        } else {
            //无网状态
            errorView.setVisibility(View.VISIBLE);
        }
    }


    //显示空布局
    public void showEmptyLayout() {
        statusView.showEmpty();
    }

    //加载错误的布局
    public void showErrorLayout() {
        statusView.showError();
    }

    //显示正在加载布局
    public void showLoadingLayout() {
        statusView.showLoading();
    }

    //显示内容
    public void showContent() {
        statusView.showContent();
    }
}
