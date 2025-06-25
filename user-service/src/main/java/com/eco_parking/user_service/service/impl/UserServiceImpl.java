package com.eco_parking.user_service.service.impl;

import com.eco_parking.user_service.dto.UserDTO;
import com.eco_parking.user_service.entity.User;
import com.eco_parking.user_service.repository.UserRepository;
import com.eco_parking.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    //save User details in db
    @Override
    public void create(UserDTO userDTO) {
        if (!userRepository.existsByEmail(userDTO.getEmail())) {
            String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
            userDTO.setPassword(hashedPassword);
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else {
            throw new RuntimeException(userDTO.getEmail() + " User Already Exist");
        }
    }

    //get User details from db
    @Override
    public UserDTO getByName(String userName) {
        User byUserName = userRepository.findByName(userName);
        return modelMapper.map(byUserName, UserDTO.class);
    }

    @Override
    public Optional<UserDTO> getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(user, UserDTO.class));
    }

    //get all User details from db
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    //Update User details in db
    @Override
    public void update(Long userId, UserDTO userDTO) {
        if (userRepository.existsById(userId)) {
            userRepository.save(modelMapper.map(userDTO, User.class));
        } else {
            throw new RuntimeException(userDTO.getEmail() + " User not Found");
        }
    }

    //Delete User details in db
    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    //check user password
    @Override
    public boolean verifyPassword(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }
}
