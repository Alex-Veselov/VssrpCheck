package com.service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Models.User;
import com.service.Repositories.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User, Long> {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
}