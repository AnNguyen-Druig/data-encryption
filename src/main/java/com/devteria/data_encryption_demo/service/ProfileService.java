package com.devteria.data_encryption_demo.service;

import com.devteria.data_encryption_demo.dto.LoginParam;
import com.devteria.data_encryption_demo.dto.ProfileDto;
import com.devteria.data_encryption_demo.dto.ProfileParam;
import com.devteria.data_encryption_demo.entity.Profile;
import com.devteria.data_encryption_demo.repository.ProfileRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileDto create(ProfileParam param) {
        var profile = new Profile();
        profile.setUsername(param.username());
        profile.setFullName(param.fullName());
        profile.setEmail(param.email());
        profile.setPassword(param.password());

        profile = profileRepository.save(profile);

        return new ProfileDto(profile.getId(),
                profile.getUsername(), profile.getFullName(),
                profile.getEmail());
    }

    public ProfileDto get(String id) {
        var profile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        return new ProfileDto(
                profile.getId(),
                profile.getUsername(),
                profile.getFullName(),
                profile.getEmail()
        );
    }

    public boolean login(LoginParam param) {
        var profile = profileRepository.findByUsername(param.username()).orElseThrow(() -> new RuntimeException("Profile not found"));

        return bCryptPasswordEncoder.matches(param.password(), profile.getPassword());
    }
}
