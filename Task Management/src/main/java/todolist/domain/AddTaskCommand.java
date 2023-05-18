package todolist.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class AddTaskCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String title;

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Date deadline;

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String priority;
}
