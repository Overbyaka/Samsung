package com.example.homework;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import ru.samsung.itschool.book.equation243.R;

public class Sapper extends Activity implements View.OnClickListener, View.OnLongClickListener {
    private int WIDTH = 11;
    private int HEIGHT = 17;

    private int bombs = 20;
    private int score = 0;
    private int[][] map = new int[HEIGHT][WIDTH];
    private Button[][] cells;

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate();
    }

    void generate() {
        makeCells();
        int x;
        int y;
        score = 0;
        int tempCount = 0;
        for (int i = 0; i < HEIGHT; i++) { //Обнуляем массив
            for (int j = 0; j < WIDTH; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < bombs; i++) { //Генерируем бомбы
            y = (int) (Math.random() * HEIGHT);
            x = (int) (Math.random() * WIDTH);
            if (map[y][x] == -1) {
                i--;
                continue;
            }
            map[y][x] = -1;
        }
        for (int i = 0; i < HEIGHT; i++) { //Проверяем каждую клетку, окружает ли ее бомба
            for (int j = 0; j < WIDTH; j++) {
                if (map[i][j] == -1)
                    continue;
                tempCount = 0;
                for (int k = i - 1; k <= i + 1; k++) { //Проверка вокруг данной клетки
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k == -1 || l == -1 || k == HEIGHT || l == WIDTH)
                            continue;
                        if (map[k][l] == -1)
                            tempCount++;
                    }
                }
                map[i][j] = tempCount;
            }
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setBackgroundColor(Color.GRAY);
            }
        }
    }

    @Override
    public void onClick(View v) {

        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        if (((ColorDrawable) cells[tappedY][tappedX].getBackground()).getColor() == Color.GRAY) {
            if (map[tappedY][tappedX] == -1) {
                cells[tappedY][tappedX].setBackgroundColor(Color.RED);
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setMessage("К сожалению, вы проиграли. Ваш счет: " + score + "Начать заново?");
                dlgAlert.setTitle("Вы проиграли!");
                dlgAlert.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        generate();
                    }
                });
                dlgAlert.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dlgAlert.setCancelable(true);

                dlgAlert.create().show();
            } else {
                score++;
                cells[tappedY][tappedX].setBackgroundColor(Color.WHITE);
                if (map[tappedY][tappedX] == 0) {
                    openMap(tappedY - 1, tappedX);
                    openMap(tappedY + 1, tappedX);
                    openMap(tappedY, tappedX - 1);
                    openMap(tappedY, tappedX + 1);
                    openMap(tappedY+1,tappedX+1);
                    openMap(tappedY+1,tappedX-1);
                    openMap(tappedY-1,tappedX+1);
                    openMap(tappedY-1,tappedX-1);
                } else
                    cells[tappedY][tappedX].setText(map[tappedY][tappedX] + "");
                if(score==WIDTH*HEIGHT-bombs){
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                    dlgAlert.setMessage("Поздравляю Вас с победой! Хотите снова сыграть?");
                    dlgAlert.setTitle("Вы выиграли!");
                    dlgAlert.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            generate();
                        }
                    });
                    dlgAlert.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    dlgAlert.setCancelable(true);

                    dlgAlert.create().show();
                }
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {

        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        if (((ColorDrawable) cells[tappedY][tappedX].getBackground()).getColor() == Color.GRAY) {
            cells[tappedY][tappedX].setBackgroundColor(Color.YELLOW);
        } else if (((ColorDrawable) cells[tappedY][tappedX].getBackground()).getColor() == Color.YELLOW) {
            cells[tappedY][tappedX].setBackgroundColor(Color.GRAY);
        }
        return false;
    }

    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
        }
    }

    void openMap(int y, int x) {
        if (!(y < 0 || x < 0 || x == WIDTH || y == HEIGHT)&&((ColorDrawable) cells[y][x].getBackground()).getColor() == Color.GRAY) {
            score++;
            if (map[y][x] > 0) {
                cells[y][x].setText(map[y][x] + "");
                cells[y][x].setBackgroundColor(Color.WHITE);
            }
            if (map[y][x] == 0) {
                cells[y][x].setBackgroundColor(Color.WHITE);
                openMap(y - 1, x);
                openMap(y + 1, x);
                openMap(y, x - 1);
                openMap(y, x + 1);
                openMap(y+1,x+1);
                openMap(y+1,x-1);
                openMap(y-1,x+1);
                openMap(y-1,x-1);
            }
        }
    }
}
