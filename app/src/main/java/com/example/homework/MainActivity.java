package com.example.homework;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import ru.samsung.itschool.book.equation243.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private Button b1,b2;
    private int temp = 0;

    MyAsyncTask myAsyncTask = new MyAsyncTask();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.number);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                break;
            case R.id.button2:
                if(!myAsyncTask.isCancelled())
                    myAsyncTask.cancel(true);
                break;
        }
    }

    class MyAsyncTask extends AsyncTask<Void,Integer,Integer>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }
        @Override
        protected Integer doInBackground(Void... parameter){
            for(int i = 0;i<Integer.MAX_VALUE;i++){
                try {
                    Thread.sleep(1000);
                    temp = i;
                    tv.setText("" + i);
                }
                catch (InterruptedException e){e.printStackTrace();}
            }
            return null;
        }
        @Override
        protected void onPostExecute(Integer b) {
            super.onPostExecute(b);
        }
    }
}


