package com.devteria.data_encryption_demo.controller;

import com.devteria.data_encryption_demo.dto.LoginParam;
import com.devteria.data_encryption_demo.dto.ProfileDto;
import com.devteria.data_encryption_demo.dto.ProfileParam;
import com.devteria.data_encryption_demo.service.ProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/users")
    public ProfileDto create(@RequestBody ProfileParam param) {
        return profileService.create(param);
    }

    @GetMapping("/users/{id}")
    public ProfileDto get(@PathVariable String id) {
        return profileService.get(id);
    }

    @PostMapping("/users/login")
    public boolean login(@RequestBody LoginParam param) {
        return profileService.login(param);
    }
}
