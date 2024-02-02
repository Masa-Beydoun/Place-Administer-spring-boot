package com.example.PlaceAdminister.DTO;

import com.example.PlaceAdminister.Request.UserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private int phoneNumber;
    private String password;

    public UserDTO(UserRequest request){
        this.phoneNumber=request.getPhoneNumber();
        this.name= request.getName();
        this.password=request.getPassword();
    }

}
