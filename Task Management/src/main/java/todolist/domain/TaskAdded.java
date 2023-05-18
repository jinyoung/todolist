package todolist.domain;

import java.util.*;
import lombok.*;
import todolist.domain.*;
import todolist.infra.AbstractEvent;

@Data
@ToString
public class TaskAdded extends AbstractEvent {

    private String title;
    private Date deadline;
    private String priority;

    public TaskAdded(ToDoList aggregate) {
        super(aggregate);
    }

    public TaskAdded() {
        super();
    }
}
