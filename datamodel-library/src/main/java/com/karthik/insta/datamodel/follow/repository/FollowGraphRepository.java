package com.karthik.insta.datamodel.follow.repository;

import com.karthik.insta.datamodel.follow.model.FollowGraph;
import com.karthik.insta.datamodel.follow.identifier.FollowGraphId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowGraphRepository extends JpaRepository<FollowGraph, FollowGraphId> {
}
