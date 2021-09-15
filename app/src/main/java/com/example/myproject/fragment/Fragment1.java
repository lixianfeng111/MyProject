package com.example.myproject.fragment;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.base.BaseFragment;
import com.example.myproject.base.BasePresenter;
import com.example.myproject.sqlite.SQLiteActivity;

import androidx.annotation.RequiresApi;

public class Fragment1 extends BaseFragment {

    private TextView sqlite;

    @Override
    public void initView() {
        sqlite = view.findViewById(R.id.sqlite);
    }

    @Override
    public void initListener() {

        sqlite.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SQLiteActivity.class));
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fragment_1;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

}
