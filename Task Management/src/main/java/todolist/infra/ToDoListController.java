package todolist.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todolist.domain.*;

@RestController
// @RequestMapping(value="/toDoLists")
@Transactional
public class ToDoListController {

    @Autowired
    ToDoListRepository toDoListRepository;

    @RequestMapping(
        value = "toDoLists/{id}/complete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ToDoList completeTask(
        @PathVariable(value = "id") String id,
        @RequestBody CompleteTaskCommand completeTaskCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /toDoList/completeTask  called #####");
        Optional<ToDoList> optionalToDoList = toDoListRepository.findById(id);

        optionalToDoList.orElseThrow(() -> new Exception("No Entity Found"));
        ToDoList toDoList = optionalToDoList.get();
        toDoList.completeTask(completeTaskCommand);

        toDoListRepository.save(toDoList);
        return toDoList;
    }
}
