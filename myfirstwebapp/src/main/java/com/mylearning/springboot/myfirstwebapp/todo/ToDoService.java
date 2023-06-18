package com.mylearning.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {

    private static List<ToDo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new ToDo(++todosCount, "gauri", "Learn AWS", LocalDate.now(), false));
        todos.add(new ToDo(++todosCount, "gauri", "Learn SpringBoot", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(++todosCount, "gauri", "Learn React", LocalDate.now().plusMonths(2), false));
        todos.add(new ToDo(++todosCount, "gauri", "Learn Couchbase", LocalDate.now().plusWeeks(3), false));
        todos.add(new ToDo(++todosCount, "gauri", "Learn System Design", LocalDate.now().plusMonths(5), false));
    }

    public List<ToDo> getAllTodos(String username) {
        return todos;
    }

    public void addTodo(String username, String description) {
        todos.add(new ToDo(++todosCount, username, description, LocalDate.now(), false));
    }

    public void deleteById(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id ;
        todos.removeIf(predicate);
    }
}
