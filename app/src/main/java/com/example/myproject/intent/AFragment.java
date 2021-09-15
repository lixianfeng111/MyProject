package com.example.myproject.intent;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.base.App;
import com.example.myproject.base.BaseFragment;
import com.example.myproject.base.BasePresenter;

import androidx.annotation.RequiresApi;

public class AFragment extends BaseFragment implements AFActivity.ToFragmentListener {

    private TextView tv_fragment_msg;
    private Button btn_in_fragment;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void initView() {

        tv_fragment_msg = view.findViewById(R.id.tv_fragment_msg);
        btn_in_fragment = view.findViewById(R.id.btn_in_fragment);
//        Bundle b = getArguments();
//        if(null != b){
//            String message = b.getString("sendMessage");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
//            }
//        }
    }

//    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
//    public static AFragment newInstance(String title){
//        Bundle bundle = new Bundle();
//        bundle.putString("title",title);
//        AFragment aFragment = new AFragment();
//        aFragment.setArguments(bundle);
//
//
//        return aFragment;
//    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayoutId() {
        return R.layout.fragment_af;
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
    public void onTypeClick(String message) {
        Toast.makeText(App.sContext,message,Toast.LENGTH_SHORT).show();
    }

}
