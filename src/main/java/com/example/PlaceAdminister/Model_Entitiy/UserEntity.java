package com.example.PlaceAdminister.Model_Entitiy;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class UserEntity {

    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phoneNumber")
    private int phoneNumber;
    @JsonProperty("password")
    private String password;

    public UserEntity(String name, int phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password=password;
    }
}
