package com.example.myproject.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.example.myproject.R;

public class MyRoundProgressBar extends MyProgressBar{

    private int mRadius=Dptopx(30);
    private int mMaxPaintWidth;

    public MyRoundProgressBar(Context context) {
        this(context,null);
    }

    public MyRoundProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRoundProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mReachHeight= (int) (2.5f*mUnReachHeight);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyRoundProgressBar);
        mRadius= (int) typedArray.getDimension(R.styleable.MyRoundProgressBar_progress_radius, mRadius);
        typedArray.recycle();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mMaxPaintWidth=Math.max(mReachHeight, mUnReachHeight);
        int expect=2*mRadius+mMaxPaintWidth+getPaddingLeft()+getPaddingRight();
        int height=resolveSize(expect, heightMeasureSpec);
        int width=resolveSize(expect,widthMeasureSpec);
        int realWidth=Math.min(height, width);
        mRadius=(realWidth-getPaddingRight()-getPaddingLeft()-mMaxPaintWidth)/2;
        setMeasuredDimension(realWidth, realWidth);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        String text=getProgress()+"%";
        int textwidth= (int) paint.measureText(text);
        int textheight=(int)(paint.descent()+paint.ascent())/2;
        canvas.save();
        canvas.translate(getPaddingLeft()+mMaxPaintWidth/2, getPaddingTop()+mMaxPaintWidth/2);
        paint.setStyle(Paint.Style.STROKE);
        //??????unReachbar
        paint.setColor(mUnReachColor);
        paint.setStrokeWidth(mUnReachHeight);
        canvas.drawCircle(mRadius, mRadius,mRadius , paint);
        //??????Reachbar
        paint.setColor(mReachColor);
        // 1.mReachHeight????????????????????????????????????  2.mReachHeight/2?????????
        paint.setStrokeWidth(mReachHeight/2);
        float sweepAngle=getProgress()*1.0f/getMax()*360;
        //startAngle??????????????????????????????????????????????????????0-360???0????????????????????????90?????????????????????
        canvas.drawArc(new RectF(0,0,2*mRadius,2*mRadius)
                , 270, sweepAngle, false,paint );

        //??????Text
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(mTextColor);
        canvas.drawText(text, mRadius-textwidth/2, mRadius-textheight, paint);
        canvas.restore();
    }

}
