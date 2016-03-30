package com.epam.vasylieva.practice3.part3;

public interface Stack {
    // проверяет пустой ли стек
    boolean empty();
    // возвращает последний добавленный элемент
    Object peek();
    // то же что и peek, но элемент удаляет
    Object pop();
    // добавляет элемент в стек
    Object push(Object o);
}
