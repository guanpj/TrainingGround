package com.me.guanpj.trainingground;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class MyView extends View {
    private String mText;
    private int mTextSize;
    private int mBgColor;
    private Paint mPaint;
    private Rect mTextBound;
    private int mTextWidth;
    private int mTextHeight;

    {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        mTextBound = new Rect();
    }

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.MyView, defStyleAttr, 0);
        mText = ta.getString(R.styleable.MyView_text);
        mTextSize = ta.getDimensionPixelSize(R.styleable.MyView_textSize,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics()));
        mBgColor = ta.getColor(R.styleable.MyView_bgColor, Color.WHITE);
        ta.recycle();
        ObjectAnimator aa = ObjectAnimator.ofInt(this, "translateX", 300, 100);
        aa.start();
        ObjectAnimator animator = ObjectAnimator.ofArgb(this, "color", 0xffff0000, 0xff00ff00);

        mPaint.setTextSize(mTextSize);
        mPaint.getTextBounds(mText,0, mText.length(), mTextBound);
        mTextWidth = (int) mPaint.measureText(mText);
        mTextHeight = mTextBound.height();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = getPaddingLeft() + mTextWidth + getPaddingRight();
        int measuredHeight = getPaddingTop() + mTextHeight + getPaddingBottom();

        measuredWidth = calculateSize(measuredWidth, widthMeasureSpec);
        measuredHeight = calculateSize(measuredHeight, heightMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    private int calculateSize(int size, int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                return size;
            case MeasureSpec.AT_MOST:
                return Math.min(size, specSize);
            case MeasureSpec.EXACTLY:
                return specSize;
            default:
                return size;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(mBgColor);
        canvas.drawText(mText, getMeasuredWidth()/2 - mTextWidth/2,
                getMeasuredHeight()/2 + mTextHeight/2, mPaint);
    }
}
