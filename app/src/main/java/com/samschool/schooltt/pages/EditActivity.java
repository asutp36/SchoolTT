package com.samschool.schooltt.pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class EditActivity extends Activity {

    TimeTable mainTT;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_edit);

        tv = (TextView) findViewById(R.id.dayName);

        mainTT = (TimeTable)getIntent().getExtras().getSerializable("TimeTable");
    }

    public void onClick(View v) {
        int dayPosition = -1;
        switch (v.getId()) {
            case R.id.btnCreate:
                dayPosition = CreateDay();
                break;
//            case R.id.btnCancel:
////                readFile();
//                break;
        }

        Intent intent = new Intent(this, MainActivity.class);

        if(dayPosition > -1)
            intent.putExtra("dayPosition", dayPosition);

        startActivity(intent);
    }

    // Добавить день
    public int CreateDay()
    {
        TTDay day = new TTDay(tv.getText().toString());
        return mainTT.AddDay(this, day);
    }
}


