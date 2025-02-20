package com.karthik.insta.datamodel.model;

import com.karthik.insta.datamodel.model.identifier.InboxItemId;
import jakarta.persistence.*;

@Entity
@Table(name = "inbox")
@IdClass(InboxItemId.class)
public class InboxItem {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Profile profile;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private StoryMetadata story;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public StoryMetadata getStory() {
        return story;
    }

    public void setStory(StoryMetadata story) {
        this.story = story;
    }
}
