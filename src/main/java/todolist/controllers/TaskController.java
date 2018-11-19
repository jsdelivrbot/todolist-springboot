package todolist.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todolist.entities.Task;
import todolist.exceptions.InvalidTaskException;
import todolist.exceptions.TaskNotFoundException;
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
            String errorMessage = String.format("Task with id %d not found", id);
            logger.error(errorMessage);
            throw new TaskNotFoundException(errorMessage);
        }

        return task;
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        logger.info("Returning all of {} tasks.", tasks.size());
        return tasks;
    }

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Task newTask(@RequestBody Task task) {

        /*
         * This method expects application/json HTTP format.
         */

        validateTask(task); // validate before create

        logger.info("Creating new task with name {}", task.getName());
        return taskRepository.save(task);
    }

    @PostMapping("/update")
    public Task updateTask(@RequestBody Task task) {

        /*
         * This method expects application/json HTTP format.
         */

        logger.info("Attempting to update task with id {}", task.getId());

        if (!taskRepository.existsById(task.getId())) {
            String errorMessage = String.format("Task with id %d does not exist and cannot be updated", task.getId());
            logger.error(errorMessage);
            throw new InvalidTaskException(errorMessage);
        }

        validateTask(task); // validate before update

        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTask(@PathVariable long id) {

        logger.info("Attempting to delete task with id {}", id);
        Task task = taskRepository.findById(id);

        if (task == null) {
            String errorMessage = String.format("Task with id %d does not exist and cannot be delete", id);
            logger.error(errorMessage);
            throw new TaskNotFoundException(errorMessage);
        }

        taskRepository.delete(task);
    }

    private void validateTask(Task task) {
        if (task.getName() == null) {
            throw new InvalidTaskException("Task name cannot be null");
        }
    }
}