package todolist.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

//@Entity
@Data
public class Task {

  //  @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)

    public Task() {
            // for deserialization
    }

    public Task(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    @Getter
    private String id;

 //   @Column(nullable = false, unique = false)

    @Getter
    @Setter
    private String name;
}