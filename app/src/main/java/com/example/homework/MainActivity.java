package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.samsung.itschool.book.equation243.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"create",Toast.LENGTH_SHORT).show();
    }

    public void solveEquation(View view){
        //ax+b=c
        double a = Double.parseDouble(((EditText)findViewById(R.id.coefficient_a)).getText().toString());
        double b = Double.parseDouble(((EditText)findViewById(R.id.coefficient_b)).getText().toString());
        double c = Double.parseDouble(((EditText)findViewById(R.id.coefficient_c)).getText().toString());
        double D = b*b - 4*a*c;
        TextView result = (TextView) findViewById(R.id.result);
        if(a==0&&b==0){
            if(c==0) {
                result.setText("x - любое число");
            }
            else{
                result.setText("x - не существует");
            }
        } else if(a==0){
            result.setText(String.valueOf(-c/b));
        } else if(b==0){
            if(a*c>=0){
                result.setText(String.valueOf(Math.sqrt(-c/a))+ " и " + String.valueOf(-Math.sqrt(-c/a)));
            }
            else{
                result.setText("x - не существует");
            }
        } else if(c==0){
            result.setText("0 и " + String.valueOf(-b/a));
        } else if(D>0){
            result.setText(String.valueOf((-b+Math.sqrt(D))/(2*a)) + " и " + String.valueOf((-b-Math.sqrt(D))/(2*a)));
        } else if(D==0){
            result.setText(String.valueOf((-b)/(2*a)));
        }
        else{
            result.setText("x - не существует");
        }
    }
}
