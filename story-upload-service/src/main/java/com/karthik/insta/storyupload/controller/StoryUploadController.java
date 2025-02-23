package com.karthik.insta.storyupload.controller;

import com.karthik.insta.datamodel.profile.model.Profile;
import com.karthik.insta.datamodel.profile.repository.ProfileRepository;
import com.karthik.insta.datamodel.story.model.StoryMetadata;
import com.karthik.insta.datamodel.story.repository.StoryMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/stories")
public class StoryUploadController {

    @Autowired
    public ProfileRepository profileRepository;

    @Autowired
    public StoryMetaDataRepository storyMetaDataRepository;

    // TODO: profile id will come from auth token once security is implemented
    @PostMapping
    public ResponseEntity<StoryMetadata> addStory(@RequestParam("storymedia") MultipartFile storymedia,
                                                  @RequestParam("statustext") String statustext,
                                                  @RequestParam("profileId") Long profileId) {
        if (storymedia.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Profile> profile = profileRepository.findById(profileId);
        if (profile.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        StoryMetadata storyMetadata = new StoryMetadata();
        // TODO : Add code to upload story media to object storage and add the download link as part of metadata
        storyMetadata.setProfile(profile.get());
        storyMetadata.setStatustext(statustext);
        storyMetadata.setExpiry(LocalDateTime.now().plusHours(24));
        storyMetadata = storyMetaDataRepository.save(storyMetadata);
        // TODO : Publish message to notify followers of new story
        return new ResponseEntity<>(storyMetadata, HttpStatus.CREATED);
    }
}
