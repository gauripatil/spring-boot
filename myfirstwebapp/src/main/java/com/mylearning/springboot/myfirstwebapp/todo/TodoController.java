package com.mylearning.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {

    private ToDoService toDoService;

    public TodoController(ToDoService toDoService) {
        super();
        this.toDoService = toDoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String username = getLoggedinUsername();
        List<ToDo> allTodos = this.toDoService.getAllTodos(username);
        modelMap.put("todos", allTodos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap,  @Valid ToDo todo, BindingResult result) {

        String username = getLoggedinUsername();
        ToDo newTodo = new ToDo(0, username, todo.getDescription(),
                todo.getTargetDate(), false);
        modelMap.put("todo", newTodo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method= RequestMethod.POST)
    public String addNewTodo(ModelMap modelMap,  @Valid ToDo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedinUsername();
        this.toDoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        this.toDoService.deleteById(id);
        return "redirect:list-todos";
    }


    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap) {
        ToDo todo = (ToDo) this.toDoService.findById(id);
        modelMap.put("todo", todo);
        return "todo";
    }


    @RequestMapping(value="update-todo", method= RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid ToDo todo, BindingResult result) {


        if(result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedinUsername();
        todo.setUsername(username);
        this.toDoService.updateToDo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
