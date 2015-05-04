package com.samschool.schooltt.pages;

import android.content.Context;
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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends FragmentActivity {

    final String FILENAME = "tt1.xml";

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

        pager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
//                pager.getChildAt(position);
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

        mainTT = RestoreTTFromFile(FILENAME);
    }

    // Сохранение расписания в файл xml
    private void SaveTT2File(TimeTable timeTable)
    {
        //Объект-сериализатор
        XStream xs = new XStream();

        try
        {
            FileOutputStream fs = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            xs.toXML(timeTable, fs);
            fs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Восстанавливает объект из файла
    private TimeTable RestoreTTFromFile(String fileName)
    {
        XStream xs = new XStream(new DomDriver());
        TimeTable timeTable = new TimeTable();

        try {
            FileInputStream fis = openFileInput(fileName);
            xs.fromXML(fis, timeTable);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return timeTable;
    }
}