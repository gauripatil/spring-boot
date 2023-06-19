package com.mylearning.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String updateToDo(ModelMap modelMap, @Valid ToDo todo, BindingResult result) {


        if(result.hasErrors()) {
            return "todo";
        }

        String username = (String)modelMap.get("name");
        todo.setUsername(username);
        modelMap.put("todo", todo);
        this.toDoService.updateToDo(todo);
        return "redirect:list-todos";
    }
}
