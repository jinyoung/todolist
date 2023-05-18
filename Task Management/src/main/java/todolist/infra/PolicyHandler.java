package todolist.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import todolist.config.kafka.KafkaProcessor;
import todolist.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ToDoListRepository toDoListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TaskAdded'"
    )
    public void wheneverTaskAdded_SendReminder(@Payload TaskAdded taskAdded) {
        TaskAdded event = taskAdded;
        System.out.println(
            "\n\n##### listener SendReminder : " + taskAdded + "\n\n"
        );

        // Sample Logic //
        ToDoList.sendReminder(event);
    }
}
