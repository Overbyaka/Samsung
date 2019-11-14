package com.example.homework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import ru.samsung.itschool.book.equation243.R;

public class CellsActivity extends Activity implements View.OnClickListener, View.OnLongClickListener {
    private int WIDTH = 6;
    private int HEIGHT = 4;

    private Button[][] cells;

    @Override
    protected void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate();
    }

    void generate(){
        //добавить код генерации клеточочного поля
        makeCells();
        int num = 1;
        for(int i = 0; i < HEIGHT;i++){
            for(int j = 0; j < WIDTH;j++){
                cells[i][j].setText(num + "");
                num++;
                if(Math.random()>=0.5){
                    cells[i][j].setBackgroundColor(Color.YELLOW);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        //add

        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        //ADD CODE
        for(int x = 0; x < WIDTH;x++){
            cells[tappedY][x].setBackgroundColor(Color.RED);
        }
        for(int y = 0; y < HEIGHT;y++){
            cells[y][tappedX].setBackgroundColor(Color.RED);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        //add

        return false;
    }

    int getX(View v){
        return  Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }
    int getY(View v){
        return  Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells(){
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(HEIGHT);
        for(int i = 0; i < HEIGHT;i++){
            for( int j = 0; j <WIDTH;j++){
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell,cellsLayout,false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
        }
    }
}
