package todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todolist.entities.Task;
import todolist.repos.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id) {

        System.out.println("fetching task with id: " + id);

        Task task = taskRepository.findById(id);

        if (task == null) {
            // TODO
        }

        return task;
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        //taskRepository.getAll();

        System.out.println("returning all tasks...");

        return taskRepository.findAll();
    }

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Task newTask(@RequestBody Task task) {

        /*
         * This method expects application/json HTTP format.
         */

        System.out.println("Payload: " + task);

        return taskRepository.save(task);
    }

    @PostMapping("/update")
    public Task updateTask(@RequestBody Task task) {

        System.out.println("update task: " + task);

        /*
         * This method expects application/json HTTP format.
         */


        if (!taskRepository.existsById(task.getId())) {
            // TODO
        }

        // TODO - validate name/etc in all scenarios

        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTask(@PathVariable long id) {
        System.out.println("deleting task: " + id);

        Task task = taskRepository.findById(id);

        if (task == null) {
            // TODO
        }

        taskRepository.delete(task);
    }
}