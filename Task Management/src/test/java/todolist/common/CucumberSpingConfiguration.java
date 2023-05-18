package todolist.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import todolist.TaskManagementApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { TaskManagementApplication.class })
public class CucumberSpingConfiguration {}
