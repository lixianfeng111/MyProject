package com.example.myproject.intent;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myproject.R;
import com.example.myproject.base.BaseActivity;
import com.example.myproject.base.BasePresenter;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class AFActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_atof;
    private AFragment aFragment;
    //    private AFragment testFragment;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void initView() {

//        aFragment = new AFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("sendMessage","来自Activity首次创建Fragment传来的数据");
//        aFragment.setArguments(bundle);

//        FragmentManager fm = getSupportFragmentManager();
//        testFragment =(AFragment) fm.findFragmentById(R.id.fragment2);
        btn_atof = findViewById(R.id.btn_atof);
        btn_atof.setOnClickListener(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayoutId() {
        return R.layout.activity_af;
    }

    @Override
    public void initVariable() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_atof:
                    toFragmentListener.onTypeClick("来自Activity的实时数据");
                break;
        }
    }

    private ToFragmentListener toFragmentListener;

    public AFActivity(ToFragmentListener toFragmentListener) {
        this.toFragmentListener = toFragmentListener;
    }

    public interface ToFragmentListener {
        void onTypeClick(String message);
    }
}
