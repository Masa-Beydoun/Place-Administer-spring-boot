package com.example.PlaceAdminister.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserRequest {
    private Long id;
    private String name;
    private int phoneNumber;
    private String password;
}
