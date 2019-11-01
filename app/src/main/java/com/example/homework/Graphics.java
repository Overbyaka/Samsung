package com.example.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Graphics extends View {

    double xe, ye, w;
    double x, y, h = 0.1;
    int k = 100;
    //double xmin = -2 * Math.PI, xmax = 2 * Math.PI;
    double xmin = -4, xmax = 4;
    public Graphics(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){

        int x0 = this.getWidth()/2;
        int y0 = this.getHeight()/2;

        Paint paint =new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(30.0f);

        canvas.drawLine(x0,0,x0,this.getHeight(),paint); //Рисует ось OX
        canvas.drawText("Y",x0+10,35,paint);
        canvas.drawLine(0,y0,this.getWidth(),y0,paint); //Рисует ось OY
        canvas.drawText("X",this.getWidth() - 50,y0+50,paint);


    }
}
