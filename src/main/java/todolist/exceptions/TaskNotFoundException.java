package todolist.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public TaskNotFoundException(String message) {
        super(message);
    }
}
