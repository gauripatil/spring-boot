package com.mylearning.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        return "todo";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String addToDo( @RequestParam String description, ModelMap modelMap) {
        this.toDoService.addTodo((String) modelMap.get("username"), description);
        return "redirect:list-todos";
    }
}
