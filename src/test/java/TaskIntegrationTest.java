
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import todolist.Application;
import todolist.entities.Task;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TaskIntegrationTest {

    private static final String API_ROOT = "http://localhost:8080/api/task";

    @Test
    public void createValidTask() {
        final Task task = createTask();

        final Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(task)
                .put(API_ROOT + "/new");
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void failToCreateInvalidTask() {
        final Task task = createTask();
        task.setName(null);

        final Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(task)
                .put(API_ROOT + "/new");
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    private Task createTask() {
        final Task task = new Task();
        task.setName("test-name");
        return task;
    }
}