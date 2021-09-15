package com.example.myproject.progressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;

import com.example.myproject.R;

public class MyProgressBar extends ProgressBar {

    private static final int  DEFAULT_TEXT_SIZE=10;//sp
    private static final int  DEFAULT_TEXT_COLOR=0xFFFC00D1;
    private static final int  DEFAULT_COLOR_UNREACH=0XFFD3D6DA;
    private static final int  DEFAULT_COLOR_REACH=DEFAULT_TEXT_COLOR;
    private static final int  DEFAULT_HEIGHT_REACH=2;//dp
    private static final int  DEFAULT_HEIGHT_UNREACH=2;//dp
    private static final int  DEFAULT_TEXT_OFFSET=10;//dp


    protected int mTextColor=DEFAULT_TEXT_COLOR;
    protected int mTextSize=Sptopx(DEFAULT_TEXT_SIZE);
    protected int mTextOffset=Dptopx(DEFAULT_TEXT_OFFSET);

    protected int mReachColor=DEFAULT_COLOR_REACH;
    protected int mUnReachColor=DEFAULT_COLOR_UNREACH;
    protected int mReachHeight=Dptopx(DEFAULT_HEIGHT_REACH);
    protected int mUnReachHeight=Dptopx(DEFAULT_HEIGHT_UNREACH);

    protected Paint paint = new Paint();
    protected int mRealWidth;

    public MyProgressBar(Context context) {
        this(context,null);
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ObtainStyleAttrs(attrs);
    }

    private void ObtainStyleAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.MyProgressBar);
        mTextSize=(int) typedArray.getDimension(R.styleable.MyProgressBar_progress_text_size, mTextSize);
        mReachColor=typedArray.getColor(R.styleable.MyProgressBar_progress_reach, mReachColor);
        mUnReachColor=typedArray.getColor(R.styleable.MyProgressBar_progress_unreach,mUnReachColor);
        mTextColor=typedArray.getColor(R.styleable.MyProgressBar_progress_text_color,mTextColor );
        mTextOffset= (int) typedArray.getDimension(R.styleable.MyProgressBar_progress_text_offset,mTextOffset);
        mUnReachHeight= (int) typedArray.getDimension(R.styleable.MyProgressBar_progress_unreach_height,mUnReachHeight);
        mReachHeight= (int) typedArray.getDimension(R.styleable.MyProgressBar_progress_reach_height,mReachHeight);
        typedArray.recycle();
        paint.setTextSize(mTextSize);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthVal=MeasureSpec.getSize(widthMeasureSpec);
        int height=MeasureHeight(heightMeasureSpec);
        setMeasuredDimension(widthVal, height);
        mRealWidth=getMeasuredWidth()-getPaddingLeft()-getPaddingRight();
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getHeight()/2);
        boolean NOneedUnreach=false;
        float radio=getProgress()*1.0f/getMax();
        String text=getProgress()+"%";
        float textWidth=paint.measureText(text);
        float ProgressX=radio*mRealWidth;
        if(ProgressX+textWidth>mRealWidth){
            ProgressX=mRealWidth-textWidth;
            NOneedUnreach=true;

        }
        float EndX=ProgressX-mTextOffset/2;
        //绘制reach
        if(EndX>0){
            paint.setColor(mReachColor);
            paint.setStrokeWidth(mReachHeight);
            canvas.drawLine(0, 0, EndX, 0, paint);
        }
        //绘制text
        paint.setColor(mTextColor);
        int y= (int) (-(paint.ascent()+paint.descent())/2);
        canvas.drawText(text, ProgressX, y,paint);
        //绘制Unreach
        if(!NOneedUnreach){
            paint.setColor(mUnReachColor);
            float start=ProgressX+mTextOffset/2+textWidth;
            paint.setStrokeWidth(mUnReachHeight);
            canvas.drawLine(start, 0,mRealWidth, 0, paint);
        }
        canvas.restore();

    }

    private int MeasureHeight(int heightMeasureSpec) {
        int result=0;
        int Mode=MeasureSpec.getMode(heightMeasureSpec);
        int Size=MeasureSpec.getSize(heightMeasureSpec);
        if(Mode==MeasureSpec.EXACTLY){
            result=Size;
        }else{
            int TextSize= (int) (paint.descent()-paint.ascent());
            result=getPaddingTop()+getPaddingBottom()+Math.max(Math.max(mReachHeight, mUnReachHeight)
                    , Math.abs(TextSize));
            if(Mode==MeasureSpec.AT_MOST){
                result=Math.min(result, Size);
            }
        }
        return result;
    }

    public  int Dptopx(int dpval){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpval, getResources().getDisplayMetrics());
    }
    public int Sptopx(int spval){
        return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spval,
                getResources().getDisplayMetrics());
    }

}
