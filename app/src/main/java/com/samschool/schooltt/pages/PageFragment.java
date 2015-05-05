package com.samschool.schooltt.pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PageFragment extends ListFragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    TimeTable mainTT = null;
    // Отображаемый день
    TTDay _currentDay;

    public static PageFragment newInstance(int page, TimeTable timeTable, TTDay day) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);

        pageFragment.SetDay(timeTable, day);

        return pageFragment;
    }

    public void SetDay(TimeTable timeTable, TTDay day) {
        mainTT = timeTable;
        _currentDay = day;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        // Помечает фрагмент как неудаляемый
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.day_layout, null);

        // Заполнить строки уроков на день
        if(_currentDay != null) {
            String lessons[] = new String[_currentDay.lessons.size()];
            String time[] = new String[_currentDay.lessons.size()];

            for (int i = 0; i < _currentDay.lessons.size(); i++) {
                lessons[i] = _currentDay.lessons.get(i)._subject;
                time[i] = _currentDay.lessons.get(i)._startTime + "-" + _currentDay.lessons.get(i)._stopTime;
            }

            // Показать расписание на день
            DayTTAdapter adapter = new DayTTAdapter(container.getContext(), _currentDay.lessons);

            setListAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this.getActivity(), EditHomeworkActivity.class);
        intent.putExtra("TimeTable", mainTT);

        int dayPosition = 0;
        for(int i = 0; i < mainTT.days.size(); i++)
        {
            if(mainTT.days.get(i) == _currentDay)
            {
                dayPosition = i;
                break;
            }
        }

        intent.putExtra("dayPosition", dayPosition);
        intent.putExtra("lessonPosition", position);
        startActivity(intent);

    }
}