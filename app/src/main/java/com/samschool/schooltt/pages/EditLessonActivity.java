package com.samschool.schooltt.pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.samschool.schooltt.pages.R;

public class EditLessonActivity extends Activity {

    TimeTable mainTT;
    int dayPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_lesson);

        mainTT = (TimeTable)getIntent().getExtras().getSerializable("TimeTable");
        dayPosition = getIntent().getExtras().getInt("dayPosition", 0);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                CreateLesson();
                break;
//            case R.id.btnCancel:
////                readFile();
//                break;
        }

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("dayPosition", dayPosition);

        startActivity(intent);
    }

    // Добавить день
    public void CreateLesson()
    {
        TextView startTime = (TextView) findViewById(R.id.startTime);
        TextView stopTime = (TextView) findViewById(R.id.stopTime);
        TextView lessonName = (TextView) findViewById(R.id.lessonName);

        TTLesson lesson = new TTLesson(startTime.getText().toString(), stopTime.getText().toString(), lessonName.getText().toString());
        mainTT.AddLesson(this, dayPosition, lesson);
    }
}
