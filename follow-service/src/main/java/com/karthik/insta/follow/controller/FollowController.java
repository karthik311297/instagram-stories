package com.karthik.insta.follow.controller;

import com.karthik.insta.datamodel.follow.identifier.FollowGraphId;
import com.karthik.insta.datamodel.follow.model.FollowGraph;
import com.karthik.insta.datamodel.follow.repository.FollowGraphRepository;
import com.karthik.insta.datamodel.profile.model.Profile;
import com.karthik.insta.datamodel.profile.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/followgraphs")
public class FollowController {

    @Autowired
    public FollowGraphRepository followGraphRepository;

    @Autowired
    public ProfileRepository profileRepository;

    // TODO: follwer id will come from auth token once security is implemented
    @PostMapping
    public ResponseEntity<FollowGraph> followUserProfile(@RequestBody FollowGraphId followGraphId) {
        Optional<Profile> follower = profileRepository.findById(followGraphId.getFollower());
        Optional<Profile> followee = profileRepository.findById(followGraphId.getFollowee());
        if (follower.isEmpty() || followee.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        FollowGraph followGraph = new FollowGraph();
        followGraph.setFollower(follower.get());
        followGraph.setFollowee(followee.get());
        followGraph = followGraphRepository.save(followGraph);
        return new ResponseEntity<>(followGraph, HttpStatus.CREATED);
    }
}
