package com.example.myproject.fragment;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.base.BaseFragment;
import com.example.myproject.base.BasePresenter;
import com.example.myproject.intent.AFActivity;
import com.example.myproject.intent.IntentActivity;

public class Fragment2 extends BaseFragment {

    private TextView textView2;
    private TextView af;

    @Override
    public void initView() {

        textView2 = view.findViewById(R.id.textView2);
        af = view.findViewById(R.id.af);
    }

    @Override
    public void initListener() {

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    startActivity(new Intent(getContext(), IntentActivity.class));
                }
            }
        });
        af.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    startActivity(new Intent(getContext(), AFActivity.class));
                }
            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fragment_2;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
