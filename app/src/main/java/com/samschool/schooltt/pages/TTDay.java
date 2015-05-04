package com.samschool.schooltt.pages;

import java.util.LinkedList;

// День
public class TTDay {
    // Название дня
    String _name;
    // Список уроков в дне
    LinkedList<TTLesson> lessons = new LinkedList<TTLesson>();

    public TTDay(String name)
    {
        _name = name;
    }
}
