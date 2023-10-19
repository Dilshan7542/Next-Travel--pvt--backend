package lk.travel.userserivce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userID;
    @Pattern(regexp = "^([A-Z]){1,1}[a-z|\\\\s]{1,}$")
    String name;
    @Email
    String email;
    String pwd;
    @Enumerated(EnumType.STRING)
    Role role;

}
