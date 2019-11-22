package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.samsung.itschool.book.equation243.R;

public class RegistrationUsers extends Activity {
    EditText login,password;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_users);
        Toast.makeText(this,"create",Toast.LENGTH_SHORT).show();
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        bt = (Button) findViewById(R.id.create);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("login",login.getText().toString());
                i.putExtra("password",password.getText().toString());
                setResult(RESULT_OK,i);
                finish();
            }
        };
        bt.setOnClickListener(listener);
    }

}
