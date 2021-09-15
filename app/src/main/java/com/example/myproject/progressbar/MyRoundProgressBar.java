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
        //绘制unReachbar
        paint.setColor(mUnReachColor);
        paint.setStrokeWidth(mUnReachHeight);
        canvas.drawCircle(mRadius, mRadius,mRadius , paint);
        //绘制Reachbar
        paint.setColor(mReachColor);
        // 1.mReachHeight绘制过的比没绘制的宽两倍  2.mReachHeight/2一样宽
        paint.setStrokeWidth(mReachHeight/2);
        float sweepAngle=getProgress()*1.0f/getMax()*360;
        //startAngle表示我们画弧度开始的角度，这里的值为0-360，0表示三点钟方向，90表示六点钟方向
        canvas.drawArc(new RectF(0,0,2*mRadius,2*mRadius)
                , 270, sweepAngle, false,paint );

        //绘制Text
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(mTextColor);
        canvas.drawText(text, mRadius-textwidth/2, mRadius-textheight, paint);
        canvas.restore();
    }

}
