package com.example.PlaceAdminister.Controller;
import com.example.PlaceAdminister.DTO.UserDTO;
import com.example.PlaceAdminister.Request.UserRequest;
import com.example.PlaceAdminister.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("allUsers")
    public List<UserDTO> getAllRoomCategories() {
        return userService.getAllUsers();
    }

    @PostMapping("newUser")
    public UserDTO addRoomCategory(@RequestBody UserRequest userRequest) {
        UserDTO userDTO = new UserDTO(userRequest);
        return userService.store(userDTO);
    }


}
