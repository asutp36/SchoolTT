package com.samschool.schooltt.pages;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samschool.schooltt.pages.R;

public class SaturdayFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "Saturday";

    int pageNumber;
    int backColor;

    static SaturdayFragment newInstance(int page) {
        SaturdayFragment saturdayFragment;
        saturdayFragment = new SaturdayFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        saturdayFragment.setArguments(arguments);
        return saturdayFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.saturday_layout, null);

        return view;
    }
}