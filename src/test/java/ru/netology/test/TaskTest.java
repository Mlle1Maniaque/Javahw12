package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.task.Epic;
import ru.netology.task.Meeting;
import ru.netology.task.SimpleTask;

public class TaskTest {
    @Test
    public void matchesForSimpleTaskTrue() {
        SimpleTask task = new SimpleTask(12, "Забрать посылку");

        boolean expected = true;
        boolean actual = task.matches("посылку");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForSimpleTaskFalse() {
        SimpleTask task = new SimpleTask(12, "Забрать посылку");

        boolean expected = false;
        boolean actual = task.matches("заказ");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForEpicTrue() {
        Epic epic = new Epic(23, new String[]{"Оплатить счета", "забрать заказ", "купить батарейки"});

        boolean expected = true;
        boolean actual = epic.matches("батарейки");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForEpicFalse() {
        Epic epic = new Epic(23, new String[]{"Оплатить счета", "забрать заказ", "купить батарейки"});

        boolean expected = false;
        boolean actual = epic.matches("отнести");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingTopicTrue() {
        Meeting meeting = new Meeting(35, "отправить резюме", "устройство на работу", "28.02.2023 12:00");

        boolean expected = true;
        boolean actual = meeting.matches("резюме");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingTopicFalse() {
        Meeting meeting = new Meeting(35, "отправить резюме", "устройство на работу", "28.02.2023 12:00");

        boolean expected = false;
        boolean actual = meeting.matches("посылку");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingProjectTrue() {
        Meeting meeting = new Meeting(35, "отправить резюме", "устройство на работу", "28.02.2023 12:00");

        boolean expected = true;
        boolean actual = meeting.matches("работу");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesForMeetingProjectFalse() {
        Meeting meeting = new Meeting(35, "отправить резюме", "устройство на работу", "28.02.2023 12:00");

        boolean expected = false;
        boolean actual = meeting.matches("устроиться");

        Assertions.assertEquals(expected, actual);
    }
}




