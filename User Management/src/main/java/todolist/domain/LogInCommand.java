package todolist.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class LogInCommand {

    private String email;
    private String password;
}
