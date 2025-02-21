package com.karthik.insta.datamodel.inbox.identifier;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InboxItemId that = (InboxItemId) o;
        return Objects.equals(profile, that.profile) && Objects.equals(story, that.story);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profile, story);
    }
}
