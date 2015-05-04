package com.samschool.schooltt.pages;

import android.content.Context;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

// Рассписание на неделю
public class TimeTable implements Serializable {
    // Список дней
    LinkedList<TTDay> days = new LinkedList<TTDay>();

    // Добавить день
    public int AddDay(Context context, TTDay day)
    {
        days.add(day);

        SaveTT2File(context);

        return days.size() - 1;
    }

    // Добавить урок
    public void AddLesson(Context context, int dayPosition, TTLesson lesson)
    {
        TTDay day = days.get(dayPosition);
        day.lessons.add(lesson);

        Collections.sort(day.lessons, new Comparator<TTLesson>() {
            @Override
            public int compare(TTLesson o1, TTLesson o2) {
                return Collator.getInstance().compare(o1._startTime, o2._startTime);
            }
        });

        SaveTT2File(context);
    }

    // Сохранение расписания в файл xml
    public void SaveTT2File(Context context)
    {
        //Объект-сериализатор
        XStream xs = new XStream();

        try
        {
            FileOutputStream fs = context.openFileOutput("tt.xml", Context.MODE_PRIVATE);
            xs.toXML(this, fs);
            fs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Восстанавливает объект из файла
    public static TimeTable RestoreTTFromFile(Context context)
    {
        XStream xs = new XStream(new DomDriver());
        TimeTable timeTable = new TimeTable();

        try {
            FileInputStream fis = context.openFileInput("tt.xml");
            xs.fromXML(fis, timeTable);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return timeTable;
    }
}
