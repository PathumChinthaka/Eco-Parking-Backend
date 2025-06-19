package com.eco_parking.user_service.controller;

import com.eco_parking.user_service.dto.UserDTO;
import com.eco_parking.user_service.entity.User;
import com.eco_parking.user_service.service.UserService;
import com.eco_parking.user_service.util.ResponseUtility;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = {"*"})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //  handle user Post request
    @PostMapping
    public ResponseUtility saveUser(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return new ResponseUtility(200, "Ok saved", null);
    }

    //handle user get request
    @GetMapping("{userName}")
    public ResponseUtility getUser(@PathVariable String userName) {
        UserDTO user = userService.getByName(userName);
        return new ResponseUtility(200, "User Fetch", user);
    }

    //handle get All users request
    @GetMapping("/getAll")
    public ResponseUtility getAllUsers() {
        List<User> allUsers = userService.getAll();
        return new ResponseUtility(200, "get All users", allUsers);
    }

    @GetMapping("get/{id}")
    public ResponseUtility getUserById(@PathVariable Long id) {
        Optional<UserDTO> user =  userService.getById(id);
        return new ResponseUtility(200, id + " User details fetched", user);
    }

    //handle update user request
    @PutMapping("/update/{id}")
    public ResponseUtility updateUsers(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return new ResponseUtility(200, "Update User", null);
    }

    //handle delete user request
    @DeleteMapping("delete/{id}")
    public ResponseUtility deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseUtility(200, id + " User Deleted", null);
    }
}
