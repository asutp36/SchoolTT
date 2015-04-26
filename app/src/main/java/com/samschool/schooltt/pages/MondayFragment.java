package com.samschool.schooltt.pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samschool.schooltt.pages.R;


public class MondayFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "Monday";

    int pageNumber;
    int backColor;

    static MondayFragment newInstance(int page) {
        MondayFragment mondayFragment;
        mondayFragment = new MondayFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        mondayFragment.setArguments(arguments);
        return mondayFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monday_layout, null);

        return view;
    }
}