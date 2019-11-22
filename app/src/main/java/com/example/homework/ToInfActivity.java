package com.example.homework;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import ru.samsung.itschool.book.equation243.R;

public class ToInfActivity extends Activity {
    TextView tv;
        @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toinfactivity);
        tv = (TextView) findViewById(R.id.tv);
        String str = getIntent().getStringExtra("et");
        tv.setText(str);
    }

}
