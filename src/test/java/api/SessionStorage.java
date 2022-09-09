package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class SessionStorage {

    private Map sessionStorage;

    public Map getSessionStorage() {
        return sessionStorage;
    }

    public void createSessionStorage(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            sessionStorage = objectMapper.readValue(jsonString, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
