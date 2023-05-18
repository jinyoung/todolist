package todolist.domain;

import java.util.*;
import lombok.*;
import todolist.domain.*;
import todolist.infra.AbstractEvent;

@Data
@ToString
public class TaskCompleted extends AbstractEvent {

    private String title;
    private Date completionTime;

    public TaskCompleted(ToDoList aggregate) {
        super(aggregate);
    }

    public TaskCompleted() {
        super();
    }
}
