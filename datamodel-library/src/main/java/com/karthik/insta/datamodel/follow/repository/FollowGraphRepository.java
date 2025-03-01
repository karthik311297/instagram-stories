package com.karthik.insta.datamodel.follow.repository;

import com.karthik.insta.datamodel.follow.identifier.FollowGraphId;
import com.karthik.insta.datamodel.follow.model.FollowGraph;
import com.karthik.insta.datamodel.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowGraphRepository extends JpaRepository<FollowGraph, FollowGraphId> {

    @Query("select F.follower from FollowGraph F where F.followee = ?1")
    List<Profile> findFollowersOfProfile(Profile profile);
}
