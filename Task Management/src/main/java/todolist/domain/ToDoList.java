package todolist.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import todolist.TaskManagementApplication;
import todolist.domain.TaskAdded;
import todolist.domain.TaskCompleted;

@Entity
@Table(name = "ToDoList_table")
@Data
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String title;

    private Date deadline;

    private String priority;

    @PostPersist
    public void onPostPersist() {
        TaskAdded taskAdded = new TaskAdded(this);
        taskAdded.publishAfterCommit();

        TaskCompleted taskCompleted = new TaskCompleted(this);
        taskCompleted.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ToDoListRepository repository() {
        ToDoListRepository toDoListRepository = TaskManagementApplication.applicationContext.getBean(
            ToDoListRepository.class
        );
        return toDoListRepository;
    }

    public static void sendReminder(TaskAdded taskAdded) {
        /** Example 1:  new item 
        ToDoList toDoList = new ToDoList();
        repository().save(toDoList);

        */

        /** Example 2:  finding and process
        
        repository().findById(taskAdded.get???()).ifPresent(toDoList->{
            
            toDoList // do something
            repository().save(toDoList);


         });
        */

    }
}
