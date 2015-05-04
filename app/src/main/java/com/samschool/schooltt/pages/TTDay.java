package com.samschool.schooltt.pages;

import java.io.Serializable;
import java.util.LinkedList;

// День
public class TTDay  implements Serializable {
    // Название дня
    String _name;
    // Список уроков в дне
    LinkedList<TTLesson> lessons = new LinkedList<TTLesson>();

    public TTDay(String name)
    {
        _name = name;
    }
}
