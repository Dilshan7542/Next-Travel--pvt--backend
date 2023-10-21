package lk.travel.authservice.entity;

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
    private int userID;
    @Pattern(regexp = "^([A-Z]){1,1}[a-z|\\\\s]{1,}$")
    private String name;
    @Email
    private String email;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private Role role;

}
