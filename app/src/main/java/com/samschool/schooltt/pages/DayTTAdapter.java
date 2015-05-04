package com.samschool.schooltt.pages;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class DayTTAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater inflater;
    LinkedList<TTLesson> _lessons;


    DayTTAdapter(Context context, LinkedList<TTLesson> lessons) {
        ctx = context;
        _lessons = lessons;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return _lessons.size();
    }

    @Override
    public Object getItem(int position) {
        return _lessons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.lesson, parent, false);
        }

        TTLesson lesson = _lessons.get(position);

        ((TextView) view.findViewById(R.id.lesson)).setText(lesson._subject);
        ((TextView) view.findViewById(R.id.time)).setText(lesson._startTime + "-" + lesson._stopTime);
        ((TextView) view.findViewById(R.id.homework)).setText(lesson._homework);
        return view;
    }
}
