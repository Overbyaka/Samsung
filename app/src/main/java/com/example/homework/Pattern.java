package com.example.homework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Pattern extends View {

    public Pattern(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,this.getWidth(),this.getHeight(),paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(0,0,500,paint);
        canvas.drawCircle(this.getWidth()-1,this.getHeight()-1,500,paint);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(0,0,700,paint);
        canvas.drawCircle(this.getWidth()-1,this.getHeight()-1,700,paint);
        canvas.drawLine(this.getWidth(),0,0,this.getHeight(),paint);
        paint.setColor(Color.BLACK);
        for(int i = 0; i <this.getWidth();i+=50){
            canvas.drawRect(i,i,i+50,i+50,paint);
        }
        for(int i = this.getWidth(),k = 1; i >0;i-=50,k++){
            canvas.drawRect(i-50,this.getHeight()-50*k,i,this.getHeight() - 50*(k-1),paint);
        }
    }
}
