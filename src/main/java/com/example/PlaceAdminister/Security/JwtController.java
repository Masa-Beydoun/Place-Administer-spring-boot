package com.example.PlaceAdminister.Security;
package org.closure;

import com.example.PlaceAdminister.DTO.UserDTO;
import com.example.PlaceAdminister.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JwtController {
    @Autowired
    JwtService jwtService;
    @Autowired
    UserRepository repository;

    @PostMapping("/login")
    public String auth(@RequestBody UserDTO user) {
        repository.save(user);
        return jwtService.generateToken(user);
    }

    @GetMapping("/hello")
    public String message(UsernamePasswordAuthenticationToken auth) {
        UserModel user = repository.findByUsername(auth.getName()).get();
        return "Hello " + user.username + "\n" + "Your message is:\n" + user.message;
    }
}

