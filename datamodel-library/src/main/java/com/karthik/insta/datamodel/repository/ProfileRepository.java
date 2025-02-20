package com.karthik.insta.datamodel.repository;

import com.karthik.insta.datamodel.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
