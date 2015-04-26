package com.samschool.schooltt.pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samschool.schooltt.pages.R;

public class PageFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;

    public static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        switch (pageNumber){
            case 0:
                view = inflater.inflate(R.layout.monday_layout, null);
                break;
            case 1:
                view = inflater.inflate(R.layout.tuesday_layout, null);
                break;
            case 2:
                view = inflater.inflate(R.layout.wednesday_layout, null);
                break;
            case 3:
                view = inflater.inflate(R.layout.thursday_layout, null);
                break;
            case 4:
                view = inflater.inflate(R.layout.friday_layout, null);
                break;
            case 5:
                view = inflater.inflate(R.layout.saturday_layout, null);
                break;

        }

        return view;
    }
}