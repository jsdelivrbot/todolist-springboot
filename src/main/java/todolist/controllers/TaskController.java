package todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import todolist.entities.Task;
//import todolist.repos.TaskRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    List<Task> allTasks = new ArrayList<>();

   // @Autowired
   // private TaskRepository taskRepository;

    @GetMapping("/id/{taskId}")
    public Task getTask(@PathVariable String taskId) {
       // return taskRepository.getById(taskId);

        System.out.println("fetching task with id: " + taskId);

        Optional<Task> task = fetchTask(taskId);

        System.out.println("found: " + task);

        // if (task.isEmpty()) {
        // TODO
        // }

        return task.get();
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        //taskRepository.getAll();

        System.out.println("returning all tasks...");

        return allTasks;
    }

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Task newTask(@RequestBody Task task) {

        // NOTE: This works; just submit all bodies as "application/json" format

        System.out.println("Payload: " + task);

      //  System.out.print("new task with name: " + payload.get("name"));
       // Task task = new Task("test");//payload.get("name"));
        allTasks.add(task);

        return task;
       // taskRepository.create(name);
    }

    @PostMapping("/update/{taskId}")
    public void updateTask(@RequestBody String name, @PathVariable String taskId) {

        System.out.println("update task " + taskId + " with name " + name);


        Optional<Task> task = fetchTask(taskId);

       // if (task.isEmpty()) {
            // TODO
        //}

        task.get().setName(name);

        //taskRepository.update(name, taskId);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
      //  taskRepository.delete(taskId);

        System.out.println("deleting task: " + taskId);

        Optional<Task> task = fetchTask(taskId);

     //   if (task.isEmpty()) {
            /// TODO
      //  }

        allTasks.remove(task.get());
    }

    private Optional<Task> fetchTask(String taskId) {
        Optional<Task> t = Optional.empty();

        for (Task task : allTasks) {
            if (task.getId().equals(taskId)) {
                t = Optional.of(task);
            }
        }

        return t;
    }

}