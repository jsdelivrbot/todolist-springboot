package todolist.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Task {

    public Task() { } // for deserialization

    public Task(long id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @Column(nullable = false, unique = false)
    private String name;

    @Getter
    @Setter
    @Column
    private boolean completed = false; // all new tasks are incomplete

    @Override
    public String toString() {
        return "Name: " + this.name + ", id: " + this.id + ", isComplete: " + this.completed;
    }
}