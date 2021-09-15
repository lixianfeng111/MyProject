package com.example.myproject.intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.base.BaseActivity;
import com.example.myproject.base.BasePresenter;
import com.example.myproject.util.IntentUtil;

public class IntentActivity extends BaseActivity {

    private Button btn;
    private TextView textView;
    private Button back;

    @Override
    public void initView() {
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);
        back = findViewById(R.id.back);
    }

    @Override
    public void initListener() {

        //跳转
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("feng","李献峰");
                bundle.putString("fengye","枫叶");
                bundle.putString("shangao","山高我为峰");
                IntentUtil.getInstance().intent(IntentActivity.this,IntentActivity2.class,bundle);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_intent;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
