package com.karthik.insta.datamodel.inbox.repository;

import com.karthik.insta.datamodel.inbox.identifier.InboxItemId;
import com.karthik.insta.datamodel.inbox.model.InboxItem;
import com.karthik.insta.datamodel.story.model.StoryMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InboxRepository extends JpaRepository<InboxItem, InboxItemId> {

    @Query("select I.story from InboxItem I where I.profile.id = ?1")
    List<StoryMetadata> findInboxStoriesByProfileId(Long profileId);
}
