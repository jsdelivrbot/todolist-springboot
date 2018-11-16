package todolist.repos;

import org.springframework.data.repository.CrudRepository;
import todolist.entities.Task;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task create(String taskName);
    Task update(String newTaskName, String taskId);
    void delete(String taskId);
    Task getById(String taskId);
    List<Task> getAll();
}