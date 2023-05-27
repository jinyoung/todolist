package todolist;

import org.requirementsascode.moonwlker.MoonwlkerModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.module.SimpleModule;

import todolist.config.kafka.KafkaProcessor;

@SpringBootApplication
@EnableBinding(KafkaProcessor.class)
@EnableFeignClients
public class TaskManagementApplication {

    public static ApplicationContext applicationContext;


    public static ObjectMapper createTypedJsonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig()
        //         .getDefaultVisibilityChecker()
        //         .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
        //         .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
        //         .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
        //         .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));

        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // ignore null
        // objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT); // ignore zero and false when it is int or boolean
        // objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

       // objectMapper.enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE, "_type");
        return objectMapper;

    }

    public static void main(String[] args) throws Exception {

        // polymorphism 이 필요한 (특정할 수 없는 type 의 경우만 _type 이 필요하고 그냥 serialize 될 객체의 type information 으로 자동으로 매핑됨 (배열 포함)))
        String json = "{\"value\": {\"_type\": \"todolist.Person\", \"name\": \"person name\", \"age\": 30, \"addresses\": [{\"_type\": \"todolist.Address\", \"city\":\"seoul\"},{\"_type\": \"todolist.GlobalAddress\", \"country\":\"Korea\", \"city\": \"yongin\"}]}}";
        String json2 = "{\"value\": {\"name\": \"person name\", \"age\": 30, \"addresses\": [{\"city\":\"seoul\"},{\"_type\": \"todolist.GlobalAddress\", \"country\":\"Korea\", \"city\": \"yongin\"}]}}";

        

        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        TypeResolverBuilder<?> typeResolver = new CustomTypeResolverBuilder();
        typeResolver.init(JsonTypeInfo.Id.CLASS, null);
        typeResolver.typeIdVisibility(false);
        typeResolver.inclusion(JsonTypeInfo.As.PROPERTY);
        typeResolver.typeProperty("_type");
        
        mapper.setDefaultTyping(typeResolver);

//        SimpleModule module = new SimpleModule();
        //module.addDeserializer(Address.class, new CustomDeserializer());
        

        // MoonwlkerModule module =
        // MoonwlkerModule.builder()
        //   .fromProperty("_type").toSubclassesOf(Object.class)
        //   .build();

       // mapper.registerModule(module);

        Root root = mapper.readValue(json2, Root.class);

        Person person = (Person)root.getValue();
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        System.out.println("Address1: " + person.getAddresses()[0].getClass());
        System.out.println("Address2: " + person.getAddresses()[1].getClass());

        // applicationContext =
        //     SpringApplication.run(TaskManagementApplication.class, args);


        
    }
}
