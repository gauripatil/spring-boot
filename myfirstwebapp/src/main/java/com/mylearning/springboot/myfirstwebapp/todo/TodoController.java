package com.mylearning.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("yourName")
public class TodoController {

    private ToDoService toDoService;

    public TodoController(ToDoService toDoService) {
        super();
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String getAllTodo(ModelMap modelMap) {
        List<ToDo> allTodos = this.toDoService.getAllTodos("gauri");
        modelMap.put("todos", allTodos);
        return "listTodos";
    }
}
