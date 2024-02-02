package com.example.PlaceAdminister.Repository;

import com.example.PlaceAdminister.DTO.RoomDTO;
import com.example.PlaceAdminister.DTO.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    public List<UserDTO> readFromJsonFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<UserDTO> models = objectMapper.readValue(new File(filePath), new TypeReference<>() {});
            return models;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    public UserDTO writeToJsonFile(UserDTO models, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<UserDTO> user= readFromJsonFile(filePath);
            Long id= Long.valueOf(1);
            if(!(user.size()==0)) id=(Long)user.get(user.size()-1).getId()+1;
            models.setId(id);
            user.add(models);

            objectMapper.writeValue(new File(filePath), user);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in a production environment
        }
        return models;
    }
    public UserDTO searchDataById(Long id , String filePath) {
        List<UserDTO> dataList = readFromJsonFile(filePath);
        return dataList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public UserDTO UpdateById(Long id , UserDTO userDTO , String filePath) {
        try {
            // Step 1: Read the JSON file and parse it
            File jsonFile = new File(filePath);
            FileInputStream fis = new FileInputStream(jsonFile);
            JSONTokener tokener = new JSONTokener(fis);
            JSONArray jsonArray = new JSONArray(tokener);

            // Step 2 and 3: Identify and update the specific element
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject element = jsonArray.getJSONObject(i);
                if (element.getLong("id") == (id)) { // Assuming "id" is the identifier for the element
                    element.put("id", id);
                    userDTO.setId(id);
                    element.put("name", userDTO.getName());
                    element.put("phoneNumber", userDTO.getPhoneNumber());
                }
            }

            // Step 4: Write the updated data back to the JSON file
            FileWriter fileWriter = new FileWriter(jsonFile);
            jsonArray.write(fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return userDTO;

    }

}
