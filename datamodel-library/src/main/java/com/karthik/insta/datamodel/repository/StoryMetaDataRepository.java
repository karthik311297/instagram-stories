package com.karthik.insta.datamodel.repository;

import com.karthik.insta.datamodel.model.StoryMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryMetaDataRepository extends JpaRepository<StoryMetadata, Long> {
}
