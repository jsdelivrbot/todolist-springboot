package todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todolist.entities.Task;
import todolist.entities.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/id/{taskId}")
    public Task getTask(@PathVariable String taskId) {
        return taskRepository.getById(taskId);
    }

    @GetMapping("/all")
    public void getAllTasks() {
        taskRepository.getAll();
    }

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void newTask(@RequestBody String name) {
        taskRepository.create(name);
    }

    @PostMapping("/update/{taskId}")
    public void updateTask(@RequestBody String name, @PathVariable String taskId) {
        taskRepository.update(name, taskId);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        taskRepository.delete(taskId);
    }

}