package com.example.PlaceAdminister.Security.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository {

  Optional<User> findByEmail(String email);

}
