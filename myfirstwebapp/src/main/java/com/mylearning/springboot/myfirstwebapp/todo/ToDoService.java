package com.mylearning.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class ToDoService {

    private static List<ToDo> todos = new ArrayList<>();
    static {
        todos.add(new ToDo(1, "gauri", "Learn AWS", LocalDate.now(), false));
        todos.add(new ToDo(2, "gauri", "Learn SpringBoot", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(3, "gauri", "Learn React", LocalDate.now().plusMonths(2), false));
        todos.add(new ToDo(4, "gauri", "Learn Couchbase", LocalDate.now().plusWeeks(3), false));
        todos.add(new ToDo(5, "gauri", "Learn System Design", LocalDate.now().plusMonths(5), false));
    }

    public List<ToDo> getAllTodos(String username) {
        return todos;
    }
}
