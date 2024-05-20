package com.service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Models.Phone;
import com.service.Repositories.PhoneRepository;

@RestController
@RequestMapping("/api/phone")
public class PhoneController extends BaseController<Phone, Long> {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneController(PhoneRepository userRepository) {
        super(userRepository);
        this.phoneRepository = userRepository;
    }
}