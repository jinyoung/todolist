package todolist;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDeserializer extends StdDeserializer<Address> {
    ObjectMapper mapper = new ObjectMapper();

    public CustomDeserializer() {
        super(Address.class);
    }


    @Override
    public Address deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);
        JsonNode typeNode = node.get("_type");
        
        if(typeNode!=null){
            String type = typeNode.asText();
            Class cls;
    
           // if(type != null)
            try {
                cls = Class.forName(type);
    
                if (cls != null) {
                    return (Address) codec.treeToValue(node, cls);
                } else {
                    throw new IllegalArgumentException("Unknown type: " + type);
                }
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                return (Address) codec.treeToValue(node, Object.class);
            }
    
        }
        else{
            return (Address) mapper.readValue(node.toString(), Object.class);

        }

    }
}

