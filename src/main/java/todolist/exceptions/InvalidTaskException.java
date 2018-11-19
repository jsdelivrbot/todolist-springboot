package todolist.exceptions;

public class InvalidTaskException  extends RuntimeException {
    public InvalidTaskException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidTaskException(String message) {
        super(message);
    }
}

