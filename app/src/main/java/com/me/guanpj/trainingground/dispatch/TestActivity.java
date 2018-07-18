package com.me.guanpj.trainingground.dispatch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.me.guanpj.trainingground.R;

public class TestActivity extends AppCompatActivity {

    protected static final String TAG = "gpj";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button button = findViewById(R.id.btn_test);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "MyButton onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "MyButton onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "MyButton onTouch ACTION_UP");
                        break;
                    default:
                        break;
                }

                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "MyButton onClick");
            }
        });

        LinearLayout layoutTest = findViewById(R.id.ll_test);
        layoutTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "MyLinearLayout onTouch ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "MyLinearLayout onTouch ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "MyLinearLayout onTouch ACTION_UP");
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

        layoutTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "MyLinearLayout onClick");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
