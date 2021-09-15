package com.example.myproject.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import com.example.myproject.MainActivity;
import com.example.myproject.R;

public class ProgressActivity extends AppCompatActivity {
    private MyProgressBar myprogress_one;
    private MyProgressBar myprogress_two;
    private MyRoundProgressBar myprogress_three;
    private MyRoundProgressBar myprogress_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        myprogress_one = findViewById(R.id.myprogress_one);
        myprogress_two = findViewById(R.id.myprogress_two);
        myprogress_three = findViewById(R.id.myprogress_three);
        myprogress_four = findViewById(R.id.myprogress_four);
        handler.sendEmptyMessage(1);
        initListener();
    }

    private void initListener() {
        myprogress_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeMessages(1);
                initIntent();
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int ProgressX=myprogress_one.getProgress();
            int ProgressY=myprogress_two.getProgress();

            //横向0-100
            myprogress_one.setProgress(++ProgressX);
            //横向100-0
            myprogress_two.setProgress(--ProgressY);
            //圆形0-100
            myprogress_three.setProgress(++ProgressX);
            //圆形100-0
            myprogress_four.setProgress(--ProgressY);
            //到100停止
            while(myprogress_one.getProgress()>100){
                removeCallbacksAndMessages(null);
            }
            //到0停止
            while (myprogress_two.getProgress()<0){
                removeCallbacksAndMessages(null);
            }
            if (ProgressY==0){
                initIntent();
                removeCallbacksAndMessages(null);
            }

            handler.sendEmptyMessageDelayed(1, 50);
        }
    };

    private void initIntent() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}