package com.dlu.task.mgmt.usermgmtservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserMgmtRestController {

    private UserRepository userRepository;

    public UserMgmtRestController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping(value = "/user/{email}/email", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("email") String email) {

        return userRepository.findUserByEmailAddress(email);

    }

    @GetMapping(value = "/user/{role}/role")
    public List<User> getUserByRole(@PathVariable("role") String role) {
        return userRepository.findUsersByRole(role);
    }


}
