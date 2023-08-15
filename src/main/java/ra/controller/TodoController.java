package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Todo;
import ra.model.service.TodoService;

import java.util.List;

@Controller
@RequestMapping("/TodoController")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public String list(Model model) {
        // lấy dữ liệu
        List<Todo> todoList = todoService.findAll();
        model.addAttribute("list", todoList);
        return "todo/list";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Todo todoList = todoService.findById(id);
        model.addAttribute("todo", todoList);
        return "todo/edit";
    }

    @PostMapping("edit")
    public String update(@ModelAttribute("todo") Todo todo) {
        todoService.save(todo);
        return "redirect:/TodoController";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        todoService.delete(id);
        return "redirect:/TodoController";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("newTodo", new Todo());
        return "todo/add";
    }

    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("newTodo") Todo newTodo) {
        todoService.save(newTodo);
        return "redirect:/TodoController";
    }
}