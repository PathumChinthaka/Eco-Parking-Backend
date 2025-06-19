package com.eco_parking.user_service.service;

import com.eco_parking.user_service.dto.UserDTO;
import com.eco_parking.user_service.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void create(UserDTO userDTO);
    UserDTO getByName(String userName);
    Optional<UserDTO> getById(Long id);
    List<User> getAll();
    void update(Long userId, UserDTO userDTO);
    void delete(Long userId);
    boolean verifyPassword(String password, String hashedPassword);
}
