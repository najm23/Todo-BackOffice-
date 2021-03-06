package com.starsapp.rest.webservices.restfullwebservices.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Service
public class TodoHardCodedService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Najm", "Learn To Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "Najm", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "Najm", "Learn Java", new Date(), false));
        todos.add(new Todo(++idCounter, "Najm", "Learn Spring", new Date(), false));
    }

    public static List<Todo> findAll() {
        return todos;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteByID(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteByID(long id) {
        Todo todo = findById(id);
        if (todo == null)
            return null;
        if (todos.remove(todo))
            return todo;
        return todo;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
