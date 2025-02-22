package com.karthik.insta.profile.controller;

import com.karthik.insta.datamodel.profile.model.Profile;
import com.karthik.insta.datamodel.profile.repository.ProfileRepository;
import com.karthik.insta.profile.request.ProfileCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    public ProfileRepository profileRepository;

    @PostMapping
    public ResponseEntity<Profile> registerProfile(@RequestBody ProfileCreateRequest profileCreateRequest) {
        Profile profile = new Profile();
        profile.setUsername(profileCreateRequest.getUsername());
        profile.setSummary(profileCreateRequest.getSummary());
        profile = profileRepository.save(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Optional<Profile> profile = profileRepository.findById(id);
        return profile.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Profile> getProfileByUsername(@RequestParam("username") String username) {
        Optional<Profile> profile = profileRepository.findByUsername(username);
        return profile.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
