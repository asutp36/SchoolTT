package com.samschool.schooltt.pages;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.samschool.schooltt.pages.PageFragment;
import com.samschool.schooltt.pages.TTDay;

public class DayPagerAdapter extends FragmentPagerAdapter {

    TimeTable _timeTable = null;

    public DayPagerAdapter(FragmentManager fm, TimeTable timeTable) {
        super(fm);

        _timeTable = timeTable;
    }

    @Override
    public Fragment getItem(int position) {
        // Определить отображаемый день
        TTDay day = null;
        if(position < _timeTable.days.size())
            day = _timeTable.days.get(position);

        return PageFragment.newInstance(position, _timeTable, day);
    }

    @Override
    public int getCount(){

        return _timeTable.days.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position < _timeTable.days.size())
            return _timeTable.days.get(position)._name;
        else
            return "Не найден день с позицией " + position;
    }
}
