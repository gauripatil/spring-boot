package com.mylearning.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showToDo(ModelMap modelMap) {
        String username = (String) modelMap.get("username");
        ToDo todo = new ToDo(0, username, "Default Description", LocalDate.now().plusMonths(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String addToDo(ModelMap modelMap, ToDo todo) {
        this.toDoService.addTodo((String) modelMap.get("username"), todo.getDescription());
        return "redirect:list-todos";
    }
}
