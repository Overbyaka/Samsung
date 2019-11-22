package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.samsung.itschool.book.equation243.R;

public class ComeBackActivity extends Activity {
    EditText et;
    Button bt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comebackactivity);
        et= (EditText) findViewById(R.id.et);
        bt= (Button) findViewById(R.id.bt);
        View.OnClickListener listener=new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("et", et.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        };
        bt.setOnClickListener(listener);
    }
}
