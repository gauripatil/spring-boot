package com.mylearning.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private ToDoRepository toDoRepository;

    public TodoControllerJpa(ToDoRepository toDoRepository) {
        super();
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String username = getLoggedinUsername();
        toDoRepository.findByUsername(username);
//        List<ToDo> allTodos = this.toDoService.getAllTodos(username);
        List<ToDo> allTodos = toDoRepository.findByUsername(username);
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
        todo.setUsername(username);
        // JPA method to save - add todo
        toDoRepository.save(todo);
//        this.toDoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
//        this.toDoService.deleteById(id);
        toDoRepository.deleteById(id);
        return "redirect:list-todos";
    }


    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap) {
//        ToDo todo = (ToDo) this.toDoService.findById(id);
        ToDo todo = this.toDoRepository.findById(id).get();
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
//        this.toDoService.updateToDo(todo);
        this.toDoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedinUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
