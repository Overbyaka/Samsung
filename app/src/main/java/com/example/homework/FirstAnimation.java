package com.example.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class FirstAnimation extends View {

    int N = 10;
    float[]x = new float[N];
    float[]y = new float[N];
    float[]vx = new float[N];
    float[]vy = new float[N];

    public FirstAnimation(Context context) {
        super(context);
        /*for(int i = 0; i < N;i++){
            x[i] = (float)(Math.random() * 500);
            y[i] = (float)(Math.random() * 500);
            vx[i] = (float)(Math.random() * 6 -3);
            vy[i] = (float)(Math.random() * 6 - 3);
        }*/
    }

    Paint paint = new Paint();

    //float x = 0;
    //long lastTime = System.currentTimeMillis();

    boolean isStart = false;

    @Override
    protected void onDraw(Canvas canvas){
        //canvas.drawCircle(x,300,20,paint);
        //x+=0.5f;
        /*long nowTime = System.currentTimeMillis();
        x += 0.1f * (nowTime-lastTime);
        lastTime = nowTime;
        invalidate();*/

        if(!isStart){
            for(int i = 0; i < N;i++){
                x[i] = (float)(Math.random() * this.getWidth());
                y[i] = (float)(Math.random() * this.getHeight());
                vx[i] = (float)(Math.random() * 6 -3);
                vy[i] = (float)(Math.random() * 6 - 3);
            }
            isStart = true;
        }
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
        for (int i = 0; i < N; i++) {
            x[i] += vx[i];
            y[i] += vy[i];
        }invalidate();

    }
}
