package com.karthik.insta.inbox.service;

import com.karthik.insta.datamodel.follow.repository.FollowGraphRepository;
import com.karthik.insta.datamodel.inbox.model.InboxItem;
import com.karthik.insta.datamodel.inbox.repository.InboxRepository;
import com.karthik.insta.datamodel.profile.model.Profile;
import com.karthik.insta.datamodel.story.model.StoryMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InboxService {

    @Autowired
    public InboxRepository inboxRepository;

    @Autowired
    public FollowGraphRepository followGraphRepository;

    @Transactional
    public void addStoryToFollowersInbox(StoryMetadata storyMetadata) {
        List<Profile> followersOfProfile = followGraphRepository
                .findFollowersOfProfile(storyMetadata.getProfile());
        List<InboxItem> inboxItems = new ArrayList<>();
        for (Profile profile : followersOfProfile) {
            InboxItem inboxItem = new InboxItem();
            inboxItem.setStory(storyMetadata);
            inboxItem.setProfile(profile);
            inboxItems.add(inboxItem);
        }
        inboxRepository.saveAll(inboxItems);
    }
}
