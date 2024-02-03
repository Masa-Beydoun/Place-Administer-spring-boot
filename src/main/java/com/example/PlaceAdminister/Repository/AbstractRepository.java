package com.example.PlaceAdminister.Repository;

import com.example.PlaceAdminister.DTO.ReservationDTO;
import com.example.PlaceAdminister.DTO.TableDTO;
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
public class AbstractRepository {

    public List<ReservationDTO> readFromJsonReservation(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<ReservationDTO> models = objectMapper.readValue(new File(filePath), new TypeReference<>() {});
            return models;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public ReservationDTO writeToJsonReservation(ReservationDTO models, String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<ReservationDTO> tables= readFromJsonReservation(filePath);
            models.setId((long)tables.size()+1);
            tables.add(models);

            objectMapper.writeValue(new File(filePath), tables);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately in a production environment
        }
        return models;
    }


    public ReservationDTO UpdateById(Long id , ReservationDTO reservationDTO , String filePath){
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
                    System.out.println(element.getInt("id"));
                    element.put("id" , id);
                    element.put("period_of_reservations", reservationDTO.getPeriod_of_reservations());
                    element.put("time", reservationDTO.getTime());
                    element.put("room_id" ,reservationDTO.getRoom_id());
                    element.put("table_id" ,reservationDTO.getTable_id());
                    element.put("num_of_seats" , reservationDTO.getNum_of_seats());
                    // Add more modifications as needed
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

        return reservationDTO;
    }

}
