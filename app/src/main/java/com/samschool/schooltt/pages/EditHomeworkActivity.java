package com.samschool.schooltt.pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.samschool.schooltt.pages.R;

public class EditHomeworkActivity extends Activity {

    TimeTable mainTT;
    int dayPosition;
    int lessonPosition;
    TTLesson lesson;

    TextView tvHomework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_homework);

        tvHomework = (TextView) findViewById(R.id.homeWork);

        mainTT = (TimeTable)getIntent().getExtras().getSerializable("TimeTable");
        dayPosition = getIntent().getExtras().getInt("dayPosition", 0);
        lessonPosition = getIntent().getExtras().getInt("lessonPosition", 0);

        lesson = mainTT.days.get(dayPosition).lessons.get(lessonPosition);

        tvHomework.setText(lesson._homework);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                CreateHomework();
                break;
//            case R.id.btnCancel:
////                readFile();
//                break;
        }

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("dayPosition", dayPosition);

        startActivity(intent);
    }

    // Запомнить задание
    public void CreateHomework()
    {
        mainTT.CreateHomework(this, lesson, tvHomework.getText().toString());
    }
}
