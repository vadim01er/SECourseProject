package com.ershov.vd.SECourseProject.Service1;

import org.junit.Test;

import java.util.ArrayList;

public class GenerateSchedule {
    @Test
    public void testGenerated() {
        ArrayList<Schedule> list = new ArrayList<>();
        Schedule schedule;
        for (int i = 0; i < 100; i++) {
            schedule = new Schedule();
            schedule.autoGenerate();
            list.add(schedule);
        }
        list.forEach(schedule1 -> System.out.println(schedule1.toString()));
    }
}
