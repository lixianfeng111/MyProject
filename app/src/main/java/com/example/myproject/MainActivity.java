package com.example.myproject;

import android.os.Build;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myproject.base.BaseActivity;
import com.example.myproject.base.BasePresenter;
import com.example.myproject.fragment.Fragment1;
import com.example.myproject.fragment.Fragment2;
import com.example.myproject.fragment.HomeFragment;
import com.example.myproject.fragment.MyFragment;
import com.example.myproject.tabview.TabView;
import com.example.myproject.tabview.TabViewChild;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;

public class MainActivity extends BaseActivity {

    private List<TabViewChild> mTabViewList = new ArrayList<>();
    private TabView mTabView;
    private ImageView imageView;
    @Override
    public void initView() {
        mTabView = findViewById(R.id.tabView);
    }

    @Override
    public void initListener() {

    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void initData() {
        //设置底部导航
        TabViewChild tabViewChild_home = new TabViewChild(R.drawable.information_yes, R.drawable.information_no, "资讯", new HomeFragment());
        TabViewChild tabViewChild_1 = new TabViewChild(R.drawable.community_yes, R.drawable.community_no, "社区", new Fragment1());
        TabViewChild tabViewChild_2 = new TabViewChild(R.drawable.community_yes, R.drawable.community_no, "消息", new Fragment2());
        TabViewChild tabViewChild_my = new TabViewChild(R.drawable.message_yes, R.drawable.message_no, "我的", new MyFragment());

        mTabViewList.add(tabViewChild_home);
        mTabViewList.add(tabViewChild_1);
        mTabViewList.add(tabViewChild_2);
        mTabViewList.add(tabViewChild_my);
        mTabView.setTabViewChild(mTabViewList, getFragmentManager());
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initVariable() {
//        Glide.with(this).load("").into(imageView);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}