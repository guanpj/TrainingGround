package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice11CameraRotateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice11CameraRotateView(Context context) {
        super(context);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11CameraRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Matrix matrix = new Matrix();

        float left = point1.x;
        float top = point1.y;
        float right = left + bitmap.getWidth();
        float bottom = top + bitmap.getHeight();

        float[] pointsSrc = {left, top, right, top, left, bottom, right, bottom};
        float[] pointsDst = {left - 10, top - 50,
                right + 20, top - 50,
                left + 90, bottom + 200,
                right + 200, bottom + 200};

        canvas.save();
        matrix.setPolyToPoly(pointsSrc, 0, pointsDst, 0, 4);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        float left1 = point2.x;
        float top1 = point2.y;
        float right1 = left + bitmap.getWidth();
        float bottom1 = top + bitmap.getHeight();

        float[] pointsSrc1 = {left1, top1, right1, top1, left1, bottom1, right1, bottom1};
        float[] pointsDst1 = {left1 - 100, top1,
                right1 -100, top1 - 20,
                left1 - 100, bottom1 + 20,
                right1 - 100, bottom1};

        canvas.save();
        matrix.reset();
        matrix.setPolyToPoly(pointsSrc1, 0, pointsDst1, 0, 4);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
