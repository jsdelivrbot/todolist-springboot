package todolist.repos;

import org.springframework.data.repository.CrudRepository;
import todolist.entities.Task;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findById(long id);
    Task save(Task task);
    void delete(Task task);
    boolean existsById(long id);
    List<Task> findAll();
}