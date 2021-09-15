package com.example.myproject.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.base.BaseFragment;
import com.example.myproject.base.BasePresenter;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class HomeFragment extends BaseFragment {
    @Override
    public void initView() {
        TextView textView = view.findViewById(R.id.textView);
        new QBadgeView(getContext()).bindTarget(textView).setBadgeNumber(12).setBadgeGravity(Gravity.END | Gravity.TOP);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
