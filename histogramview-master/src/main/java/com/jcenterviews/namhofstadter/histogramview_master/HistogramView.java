package com.jcenterviews.namhofstadter.histogramview_master;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wuyanan on 2017/3/16.
 */

public class HistogramView extends View {
    private float width;
    private float height;
    private float rect_w;
    private int rect_t1, rect_t2, rect_t3, rect_t4, rect_t5;
    private int random;
    private boolean status = true;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0x1233) {
                HistogramView.this.invalidate();
            }
        }

        ;
    };
    private float rect_gap;
    private Timer timer;
    private RectF r1 = new RectF();
    private RectF r2 = new RectF();
    private RectF r3 = new RectF();
    private RectF r4 = new RectF();
    private RectF r5 = new RectF();
    private Paint paint1;
    private int corner = 3;
    private float space = 0.1f;
    private int color = Color.WHITE;

    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.his);
        if (typedArray != null) {
            corner = typedArray.getInt(R.styleable.his_corner, 3);
            space = typedArray.getFloat(R.styleable.his_space, 0.1f);
            color = typedArray.getColor(R.styleable.his_rectColor, Color.WHITE);
        }
        timer = new Timer();
        paint1 = new Paint();
        paint1.setColor(color);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);
    }


    public void change_Status(boolean b) {
        status = b;
        if (status) {
            this.invalidate();
        }
    }


    public boolean get_Status() {
        return status;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        rect_w = (float) (width * (1 - space) / 5);
        rect_gap = (float) (width * space / 4);
        random = (int) (height / 5);
        rect_t1 = random / 5;
        rect_t2 = random / 3;
        rect_t3 = random / 2;
        rect_t4 = random / 4;
        rect_t5 = random / 3;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (status == true) {
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    rect_t1 = new Random().nextInt(random);
                    rect_t2 = new Random().nextInt(random);
                    rect_t3 = new Random().nextInt(random);
                    rect_t4 = new Random().nextInt(random);
                    rect_t5 = new Random().nextInt(random);
                    // TODO Auto-generated method stub
                    handler.sendEmptyMessage(0x1233);
                }
            }, 120);
        } else get_Status();
        super.onDraw(canvas);

        r1.set(0, rect_t1 * 5, rect_w, (float) (height * 0.9));
        r2.set((rect_w + rect_gap), rect_t2 * 5, (rect_gap + rect_w * 2), (float) (height * 0.9));
        r3.set((rect_gap * 2 + rect_w * 2), rect_t3 * 5, (rect_gap * 2 + rect_w * 3), (float) (height * 0.9));
        r4.set((rect_gap * 3 + rect_w * 3), rect_t4 * 5, (rect_gap * 3 + rect_w * 4), (float) (height * 0.9));
        r5.set((rect_gap * 4 + rect_w * 4), rect_t5 * 5, (rect_gap * 4 + rect_w * 5), (float) (height * 0.9));
        canvas.drawRoundRect(r1, corner, corner, paint1);
        canvas.drawRoundRect(r2, corner, corner, paint1);
        canvas.drawRoundRect(r3, corner, corner, paint1);
        canvas.drawRoundRect(r4, corner, corner, paint1);
        canvas.drawRoundRect(r5, corner, corner, paint1);
        /*canvas.drawRect(r1, paint1);
        canvas.drawRect(r2, paint1);
        canvas.drawRect(r3, paint1);
        canvas.drawRect(r4, paint1);
        canvas.drawRect(r5, paint1);*/
    }

}
