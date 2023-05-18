package todolist.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import todolist.UserManagementApplication;

@Entity
@Table(name = "User_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String email;

    private String password;

    @PrePersist
    public void onPrePersist() {}

    public static UserRepository repository() {
        UserRepository userRepository = UserManagementApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }
}
