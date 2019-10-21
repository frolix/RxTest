package com.example.filter.model;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Task> createTasksList() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Take out the trash", true, 3));
        tasks.add(new Task("Walk the dog", false, 2));
        tasks.add(new Task("Walk the dog", false, 2));
        tasks.add(new Task("Make my bad", true, 1));
        tasks.add(new Task("Unload the dishwasher", false, 0));
        tasks.add(new Task("Make diner", true, 5));
        tasks.add(new Task("Make diner", true, 5));
        return tasks;
    }

}
