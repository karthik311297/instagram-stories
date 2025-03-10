package com.karthik.insta.datamodel.profile.repository;

import com.karthik.insta.datamodel.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUsername(String username);
    List<Profile> findAllByIdIn(List<Long> profileIds);
}
