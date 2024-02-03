package com.example.PlaceAdminister.Service;

import com.example.PlaceAdminister.DTO.PlaceDTO;
import com.example.PlaceAdminister.DTO.RoomCategoryDTO;
import com.example.PlaceAdminister.Model_Entitiy.PlaceEntity;
import com.example.PlaceAdminister.Model_Entitiy.RoomCategoryEntity;
import com.example.PlaceAdminister.Repository.PlaceRepository;
import com.example.PlaceAdminister.Repository.RoomCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaceService {

    @Autowired
    private PlaceEntity placeEntity;
    @Autowired
    private PlaceRepository placeRepository;
    private String filepath = "src/main/resources/RoomCategories.json";


    public List<PlaceDTO> getAllRoomCategories() {
        return placeRepository.readFromJsonFile(filepath);

    }

    public PlaceDTO store(PlaceDTO placeDTO) {
        return placeRepository.writeToJsonFile(placeDTO ,this.filepath);
    }

    public PlaceDTO show(Long id)
    {
        return placeRepository.searchDataById(id , this.filepath);
    }


    public PlaceDTO update(Long id , PlaceDTO placeDTO){
        return placeRepository.UpdateById(id ,placeDTO,this.filepath);
    }
}
