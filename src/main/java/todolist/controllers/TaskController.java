package todolist.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todolist.entities.Task;
import todolist.repos.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id) {

        logger.info("Fetching task with id {}", id);
        Task task = taskRepository.findById(id);

        if (task == null) {
            logger.info("Task with id {} not found", id);
            // TODO
        }

        return task;
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        logger.info("Returning all tasks.");
        return taskRepository.findAll();
    }

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Task newTask(@RequestBody Task task) {

        /*
         * This method expects application/json HTTP format.
         */

        logger.info("Creating new task with name {}" + task.getName());
        return taskRepository.save(task);
    }

    @PostMapping("/update")
    public Task updateTask(@RequestBody Task task) {

        /*
         * This method expects application/json HTTP format.
         */

        logger.info("Attempting to update task with id {}", task.getId());

        if (!taskRepository.existsById(task.getId())) {
            logger.info("Task with id {} does not exist and cannot be updated", task.getId());
            // TODO
        }

        // TODO - validate name/etc in all scenarios

        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTask(@PathVariable long id) {

        logger.info("Attempting to delete task with id {}", id);
        Task task = taskRepository.findById(id);

        if (task == null) {
            logger.info("Task with id {} does not exist and cannot be delete", id);
            // TODO
        }

        taskRepository.delete(task);
    }
}