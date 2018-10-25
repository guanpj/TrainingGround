package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);

        int barWidth = 85;
        int barInterval = 25;
        int totalHeight = 600;

        int startX = 100;
        int startY = 620;

        Path path = new Path();
        path.moveTo(100, 20);
        path.rLineTo(0, totalHeight);
        path.rLineTo(900, 0);

        canvas.drawPath(path, paint);

        paint.setTextSize(30f);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Froyo", startX + barInterval, startY + 30, paint);

        Paint rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectPaint.setStyle(Paint.Style.FILL);
        rectPaint.setColor(Color.GREEN);
        canvas.drawRect(new RectF(startX + barInterval, startY - (totalHeight * 5/1000),
                startX + barWidth + barInterval, startY), rectPaint);

        canvas.drawText("GB", startX + barWidth + barInterval * 2 + 15, startY + 30, paint);
        canvas.drawRect(new RectF(startX + barInterval * 2 + barWidth, startY - (totalHeight * 60/1000),
                startX + barWidth * 2 + barInterval * 2, startY), rectPaint);

        canvas.drawText("ICS", startX + barWidth * 2 + barInterval * 3 + 20, startY + 30, paint);
        canvas.drawRect(new RectF(startX + barInterval * 3 + barWidth * 2, startY - (totalHeight * 60/1000),
                startX + barWidth * 3 + barInterval * 3, startY), rectPaint);

        canvas.drawText("JB", startX + barWidth * 3 + barInterval * 4 + 20, startY + 30, paint);
        canvas.drawRect(new RectF(startX + barInterval * 4 + barWidth * 3, startY - (totalHeight * 250/1000),
                startX + barWidth * 4 + barInterval * 4, startY), rectPaint);

        //canvas.drawLine(100, 50, 100, 600, paint);
    }
}
