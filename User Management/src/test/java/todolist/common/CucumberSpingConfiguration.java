package todolist.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import todolist.UserManagementApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { UserManagementApplication.class })
public class CucumberSpingConfiguration {}
