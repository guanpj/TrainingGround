package com.me.guanpj.trainingground;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

public class MyView extends View {
    private String mText;
    private int mTextSize;

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
        Log.e("gpj", mText);
        mTextSize = ta.getDimensionPixelSize(R.styleable.MyView_textSize,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics()));
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = getPaddingLeft() + mText.length() * mTextSize + getPaddingRight();
        int measuredHeight = getPaddingTop() + mTextSize + getPaddingBottom();

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
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(mTextSize);

        Rect textBound = new Rect();
        paint.getTextBounds(mText,0, mText.length(), textBound);

        canvas.drawText(mText, getMeasuredWidth()/2 - (textBound.right - textBound.left)/2, getMeasuredHeight()/2 + (textBound.bottom - textBound.top)/2, paint);
    }
}
