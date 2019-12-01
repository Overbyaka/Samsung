package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Calendar;

import ru.samsung.itschool.book.equation243.R;

public class MainActivity2 extends Activity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanseState){
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_main2);

        final CalendarView calendarView = (CalendarView) findViewById(R.id.calendar);
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                int mYear = year;
                int mMonth = month;
                int mDay = dayOfMonth;
                Intent i = new Intent(MainActivity2.this,OpenDay.class);
                i.putExtra("day","" + mDay);
                i.putExtra("month","" + mMonth);
                i.putExtra("year","" + mYear);
                startActivity(i);
            }
        });
    }
}
