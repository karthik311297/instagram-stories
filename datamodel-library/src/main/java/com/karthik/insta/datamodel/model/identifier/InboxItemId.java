package com.karthik.insta.datamodel.model.identifier;

import java.io.Serializable;

public class InboxItemId implements Serializable {

    private Long profile;
    private Long story;

    public InboxItemId() {
    }

    public InboxItemId(Long profile, Long story) {
        this.profile = profile;
        this.story = story;
    }

    public Long getProfile() {
        return profile;
    }

    public void setProfile(Long profile) {
        this.profile = profile;
    }

    public Long getStory() {
        return story;
    }

    public void setStory(Long story) {
        this.story = story;
    }
}
