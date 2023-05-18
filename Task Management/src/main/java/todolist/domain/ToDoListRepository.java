package todolist.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import todolist.domain.*;

@RepositoryRestResource(collectionResourceRel = "toDoLists", path = "toDoLists")
public interface ToDoListRepository
    extends PagingAndSortingRepository<ToDoList, String> {}
