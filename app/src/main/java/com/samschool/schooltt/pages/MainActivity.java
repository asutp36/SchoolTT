package com.samschool.schooltt.pages;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends FragmentActivity {

    // Само расписание
    TimeTable mainTT = null;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitTimeTable();

        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new DayPagerAdapter(getSupportFragmentManager(), mainTT);
        pager.setAdapter(pagerAdapter);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int dayPosition = 0;
        if(bundle != null)
            dayPosition = bundle.getInt("dayPosition", 0);

        pager.setCurrentItem(dayPosition);

        pager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.edit_day:
                // открыть activity редактирования дня
                Intent intent = new Intent(this, EditActivity.class);
                intent.putExtra("TimeTable", mainTT);
                startActivity(intent);

                return true;
            case R.id.edit_lesson:
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Заполнение ранее сохранённого расписания
    private void InitTimeTable()
    {
//        mainTT = new TimeTable();
//
//        TTDay mnd = new TTDay("Понедельник");
//        mnd.lessons.add(new TTLesson("10:00", "11:00", "Математика","1"));
//        mnd.lessons.add(new TTLesson("11:00", "12:00", "Физика","2"));
//        mnd.lessons.add(new TTLesson("12:00", "13:00", "Русский","3"));
//
//        TTDay tue = new TTDay("Вторник");
//        tue.lessons.add(new TTLesson("15:00", "16:00", "Литература","Учить стих"));
//        tue.lessons.add(new TTLesson("16:00", "17:00", "Биология","стр. 53 - 55"));
//        tue.lessons.add(new TTLesson("17:00", "18:00", "История","Была контрольная"));
//
//        TTDay wed = new TTDay("Среда");
//        wed.lessons.add(new TTLesson("11:00", "12:00", "Английский","7"));
//        wed.lessons.add(new TTLesson("12:00", "13:00", "Математика","8"));
//        wed.lessons.add(new TTLesson("13:00", "14:00", "Физкультура","9"));
//
//        mainTT.days.add(mnd);
//        mainTT.days.add(tue);
//        mainTT.days.add(wed);
//
//        // сериализовать расписание
//        SaveTT2File(mainTT);

        mainTT = TimeTable.RestoreTTFromFile(this);
    }
}