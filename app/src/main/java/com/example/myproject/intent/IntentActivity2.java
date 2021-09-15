package com.example.myproject.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myproject.R;
import com.example.myproject.base.BaseActivity;
import com.example.myproject.base.BasePresenter;
import com.example.myproject.util.IntentUtil;

public class IntentActivity2 extends BaseActivity {

    private Button btn;
    private TextView textView;
    private TextView textView2;
    private Button back;

    @Override
    public void initView() {
        textView = findViewById(R.id.textView_intent2);
        textView2 = findViewById(R.id.textView_intent2_2);
        btn = findViewById(R.id.btn);
        back = findViewById(R.id.back);
    }

    @Override
    public void initListener() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.getInstance().intent(IntentActivity2.this,DataFragment.class,null);
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
        //两种方法都可以获取
        initIntent();
        initIntent2();
    }

    private void initIntent2() {
        Intent intent = getIntent();
        String feng = intent.getStringExtra("feng");
        String fengye = intent.getStringExtra("fengye");
        String shangao = intent.getStringExtra("shangao");
        textView2.setText(feng+" - "+fengye+" - "+shangao);
    }

    private void initIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            String feng = (String) bundle.getString("feng");
            String fengye = (String) bundle.getString("fengye");
            String shangao = (String) bundle.getString("shangao");
            textView.setText(feng+" - "+fengye+" - "+shangao);
        }
    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_intent2;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
