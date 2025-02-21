package com.karthik.insta.datamodel.story.repository;

import com.karthik.insta.datamodel.story.model.StoryMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryMetaDataRepository extends JpaRepository<StoryMetadata, Long> {
}
