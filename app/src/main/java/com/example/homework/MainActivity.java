package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

import ru.samsung.itschool.book.equation243.R;

public class MainActivity extends AppCompatActivity {
    public static Character student;
    public static Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student = new Character("Мурка");
        story = new Story();
        Toast.makeText(this,"create",Toast.LENGTH_SHORT).show();
        updateStatus();
    }

    // метод для перехода на нужную ветку развития
    private void go(int i) {
        story.go(i + 1);
        updateStatus();
        if (story.isEnd())
            Toast.makeText(this, "Игра закончена!", Toast.LENGTH_LONG).show();
    }

    // в этом методе размещаем всю информацию, специфичную для текущей
    // ситуации на форме приложения, а также размещаем кнопки, которые
    // позволят пользователю выбрать дальнейший ход событий
    private void updateStatus() {
        student.difficult += story.current_situation.dDifficult;
        student.knowledge += story.current_situation.dKnowledge;
        student.watching += story.current_situation.dWatching;
        ((TextView) findViewById(R.id.status)).
                setText("Сложность получения удовлетвортельной оценки:" + student.difficult +
                        "\nЗнания:" + student.knowledge + "\nСлежка преподавателей" + student.watching);
        ((TextView) findViewById(R.id.title)).
                setText(story.current_situation.subject);
        ((TextView) findViewById(R.id.desc)).
                setText(story.current_situation.text);
        ((LinearLayout) findViewById(R.id.layout)).removeAllViews();
        for (int i = 0; i < story.current_situation.direction.length; i++) {
            Button b = new Button(this);
            b.setText(Integer.toString(i + 1));
            final int buttonId = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    go(buttonId);
                }
            });
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
        }
    }
}
