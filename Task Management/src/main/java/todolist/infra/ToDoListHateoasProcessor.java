package todolist.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import todolist.domain.*;

@Component
public class ToDoListHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ToDoList>> {

    @Override
    public EntityModel<ToDoList> process(EntityModel<ToDoList> model) {
        return model;
    }
}
