package com.karthik.insta.datamodel.repository;

import com.karthik.insta.datamodel.model.FollowGraph;
import com.karthik.insta.datamodel.model.identifier.FollowGraphId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowGraphRepository extends JpaRepository<FollowGraph, FollowGraphId> {
}
