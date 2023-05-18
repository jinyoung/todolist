package todolist.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
public class SignUpCommand {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String email;

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String password;
}
