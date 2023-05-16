package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Todos;
import ru.netology.task.Epic;
import ru.netology.task.Meeting;
import ru.netology.task.SimpleTask;
import ru.netology.task.Task;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeTask() {
        SimpleTask task = new SimpleTask(6, "Записаться к врачу");
        Epic epic = new Epic(14, new String[]{"сдать анализы", "сделать УЗИ", "записаться к врачу"});
        Meeting meeting = new Meeting(3, "Внести правки", "Курсовая работа", "До обеда");

        Todos todos = new Todos();
        todos.add(task);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {task, epic};
        Task[] actual = todos.search("врач");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTask() {
        SimpleTask task = new SimpleTask(6, "Записаться к врачу");
        Epic epic = new Epic(14, new String[]{"сдать анализы", "сделать УЗИ", "записаться к врачу"});
        Meeting meeting = new Meeting(3, "Внести правки", "Курсовая работа", "До обеда");

        Todos todos = new Todos();
        todos.add(task);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("правки");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoTask() {
        SimpleTask task = new SimpleTask(6, "Записаться к врачу");
        Epic epic = new Epic(14, new String[]{"сдать анализы", "сделать УЗИ", "записаться к врачу"});
        Meeting meeting = new Meeting(3, "Внести правки", "Курсовая работа", "До обеда");

        Todos todos = new Todos();
        todos.add(task);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("отправить");

        Assertions.assertArrayEquals(expected, actual);
    }
}
