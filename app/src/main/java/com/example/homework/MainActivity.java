package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

    String LOGIN= "Mur";
    String PASSWORD = "Meow";

    public void entering(View view){
        String login = ((EditText)findViewById(R.id.login)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        TextView result = (TextView) findViewById(R.id.result);
        if(LOGIN.equals(login) && PASSWORD.equals(password)){
            result.setTextColor(Color.GREEN);
            result.setText("Верно");
        }
        else {
            result.setTextColor(Color.RED);
            result.setText("Вы ошиблись в логине или пароле");
            Intent i = new Intent(MainActivity.this,RegistrationUsers.class);
            startActivityForResult(i,0);
        }
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (resultCode){
            case RESULT_OK:
                LOGIN = data.getStringExtra("login");
                PASSWORD = data.getStringExtra("password");
                ((EditText) findViewById(R.id.login)).setText(LOGIN);
                ((EditText) findViewById(R.id.password)).setText(PASSWORD);
        }
    }
}
