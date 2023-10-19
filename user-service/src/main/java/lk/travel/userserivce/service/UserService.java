package lk.travel.userserivce.service;

import lk.travel.userserivce.dto.UserDTO;
import lk.travel.userserivce.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO searchUser(int userID);
    UserDTO searchByEmailUser(String email);
    void deleteUser(int userID);
    List<UserDTO> getAllUser();

}
