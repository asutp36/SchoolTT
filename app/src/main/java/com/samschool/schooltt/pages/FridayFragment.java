package com.samschool.schooltt.pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samschool.schooltt.pages.R;

public class FridayFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "Friday";

    int pageNumber;
    int backColor;

    static FridayFragment newInstance(int page) {
        FridayFragment fridayFragment;
        fridayFragment = new FridayFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        fridayFragment.setArguments(arguments);
        return fridayFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friday_layout, null);

        return view;
    }
}
