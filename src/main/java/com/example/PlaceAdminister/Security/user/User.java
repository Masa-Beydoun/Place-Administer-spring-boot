package com.example.PlaceAdminister.Security.user;

import com.example.PlaceAdminister.Security.token.Token;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

  @Id
  @GeneratedValue
  private Integer id;
  private String userName;
  private String password;
  @Enumerated(EnumType.STRING)
  private Role role;
  private Token token;


//  public Collection<? extends GrantedAuthority> getAuthorities() {
//    return role.getAuthorities();
//  }

  public String getPassword() {
    return password;
  }
  public boolean isAccountNonExpired() {
    return true;
  }


  public boolean isAccountNonLocked() {
    return true;
  }


  public boolean isCredentialsNonExpired() {
    return true;
  }


  public boolean isEnabled() {
    return true;
  }
}
