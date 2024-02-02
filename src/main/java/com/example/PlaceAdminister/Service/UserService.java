package com.example.PlaceAdminister.Service;

import com.example.PlaceAdminister.DTO.RoomDTO;
import com.example.PlaceAdminister.DTO.UserDTO;
import com.example.PlaceAdminister.Model_Entitiy.UserEntity;
import com.example.PlaceAdminister.Repository.RoomRepository;
import com.example.PlaceAdminister.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserEntity user;
    @Autowired
    private UserRepository userRepository;
    private String filepath = "src/main/resources/User.json";


    public List<UserDTO> getAllUsers() {
        return userRepository.readFromJsonFile(filepath);

    }
    public UserDTO store(UserDTO userDTO) {
        return userRepository.writeToJsonFile(userDTO ,this.filepath);
    }

    public UserDTO show(Long id)
    {
        return userRepository.searchDataById(id , this.filepath);
    }


    public UserDTO update(Long id , UserDTO userDTO){
        return userRepository.UpdateById(id ,userDTO,this.filepath);
    }



}
