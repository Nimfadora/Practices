package com.epam.vasylieva.practice3.part2;


public interface Iterator {
    // перемещает внутренний указатель итератора на начало массива
    void moveToStart();
    // перемещает внутренний указатель итератора на конец массива
    void moveToEnd();
    // проверяет, есть ли следующий элемент для выборки
    boolean hasNext();
    // проверяет, есть ли предыдущий элемент для выборки
    boolean hasPrevious();
    // возвращает следующий элемент
    Object next();
    // возвращает предыдущий элемент
    Object previous();
}
