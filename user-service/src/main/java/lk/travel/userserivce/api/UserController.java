package lk.travel.userserivce.api;

import lk.travel.userserivce.dto.UserDTO;
import lk.travel.userserivce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        userDTO.setPwd(passwordEncoder.encode(userDTO.getPwd()));
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @GetMapping(path = "search/email", params = "email")
    public ResponseEntity<UserDTO> searchByEmailUser(@RequestParam String email) {
        return ResponseEntity.ok(userService.searchByEmailUser(email));
    }

    @GetMapping("search")
    public ResponseEntity<UserDTO> searchByIDUser(@RequestParam int userID) {
        return ResponseEntity.ok(userService.searchUser(userID));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

}
