package com.samschool.schooltt.pages;

import java.sql.Time;

// Школьнй урок
public class TTLesson {
    // Время начала урока
    String _startTime;
    // Время конца урока
    String _stopTime;

    // Предмет
    String _subject;

    // Домашнее задание
    String _homework;

    public TTLesson(String startTime, String stopTime, String subject, String homework)
    {
        _startTime = startTime;
        _stopTime = stopTime;
        _subject = subject;
        _homework = homework;
    }
}
