package ra.model.service;

import org.springframework.stereotype.Service;
import ra.model.entity.Todo;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<Todo> todoList;

    public TodoService() {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, "hi hi", false));
        todoList.add(new Todo(2, "hi he", true));
    }

    public List<Todo> findAll() {
        return todoList;
    }

    public void save(Todo todo) {
        if (todo.getId() == 0) {
            //them moi
            todo.setId(getNewId());
            todoList.add(todo);
        } else {
            //update
            todoList.set(todoList.indexOf(findById(todo.getId())), todo);
        }
    }

    public Todo findById(int id) {
        for (Todo t : todoList) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void delete(int id) {
        todoList.remove(findById(id));
    }

    public int getNewId() {
        int idMax = 0;
        for (Todo t : todoList) {
            if (idMax<t.getId()){
                idMax = t.getId();
            }
        }
        return idMax+1;
    }
}