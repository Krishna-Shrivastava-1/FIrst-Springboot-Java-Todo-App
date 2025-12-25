package com.firstcrudspring.firstCrudStoreSpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstcrudspring.firstCrudStoreSpring.models.Todo;
import com.firstcrudspring.firstCrudStoreSpring.repositories.TodoRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/","https://springboottodo.vercel.app/"})
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @PostMapping("/api/create")
    public Todo create(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping("/api/getalltodo")
    public List<Todo> getall() {
        return todoRepository.findAll();
    }

    @GetMapping("/api/gettodobyid/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return todoRepository.findById(id).orElse(null);
    }

    @PatchMapping("/api/update/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo todo) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        if (existingTodo != null) {
            existingTodo.setStatus(todo.getStatus());
        }
        return todoRepository.save(existingTodo);
    }

    @GetMapping("/api/getstatus/{status}")
    public List<Todo> getbystatus(@PathVariable Boolean status) {
        return todoRepository.findByStatus(status);
    }

    @DeleteMapping("/api/delete/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoRepository.deleteById(id);
    }

}
