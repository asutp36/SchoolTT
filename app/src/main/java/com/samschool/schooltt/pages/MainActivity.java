package com.samschool.schooltt.pages;

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
import android.widget.ListView;

import com.samschool.schooltt.pages.R;

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
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
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

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            TTDay day = null;
            if(position < mainTT.days.size())
                day = mainTT.days.get(position);
            
//            PageFragment view = (PageFragment)pager.getChildAt(position);
//            if( == null)
//                pager.se

            return PageFragment.newInstance(position, day);
        }

        @Override
        public int getCount(){
            return mainTT.days.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position < mainTT.days.size())
                return mainTT.days.get(position)._name;
            else
                return "Не найден день с позицией " + position;
//            switch (position) {
//                case 0:
//                    return mainTT.days.get(position);
//                case 1:
//                    return "Вторник";
//                case 2:
//                    return "Среда";
//                case 3:
//                    return "Четверг";
//               case 4:
//                    return "Пятница";
//                case 5:
//                    return "Суббота";
//            }
//            return "Title " + position;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Заполнение ранее сохранённого расписания
    private void InitTimeTable()
    {
        mainTT = new TimeTable();

        TTDay mnd = new TTDay("Понедельник");
        mnd.lessons.add(new TTLesson("10:00", "11:00", "Математика",""));
        mnd.lessons.add(new TTLesson("11:00", "12:00", "Физика",""));
        mnd.lessons.add(new TTLesson("12:00", "13:00", "Русский",""));

        TTDay tue = new TTDay("Втор-ник");
        tue.lessons.add(new TTLesson("15:00", "16:00", "Литература2","Учить стих"));
        tue.lessons.add(new TTLesson("16:00", "17:00", "Биология","стр. 53 - 55"));
        tue.lessons.add(new TTLesson("17:00", "18:00", "История","Была контрольная"));

        TTDay wed = new TTDay("Середа");
        wed.lessons.add(new TTLesson("11:00", "12:00", "Английский",""));
        wed.lessons.add(new TTLesson("12:00", "13:00", "Математика",""));
        wed.lessons.add(new TTLesson("13:00", "14:00", "Физкультура",""));

        mainTT.days.add(mnd);
        mainTT.days.add(tue);
        mainTT.days.add(wed);

        // сериализовать расписание
        SaveTT2File(mainTT);
    }

    // Сохранение расписания в файл xml
    private void SaveTT2File(TimeTable timeTable)
    {
        
    }
}