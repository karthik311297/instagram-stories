package com.karthik.insta.datamodel.follow.identifier;

import java.io.Serializable;
import java.util.Objects;

public class FollowGraphId implements Serializable {

    private Long follower;
    private Long followee;

    public FollowGraphId() {
    }

    public FollowGraphId(Long follower, Long followee) {
        this.follower = follower;
        this.followee = followee;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }

    public Long getFollowee() {
        return followee;
    }

    public void setFollowee(Long followee) {
        this.followee = followee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FollowGraphId that = (FollowGraphId) o;
        return Objects.equals(follower, that.follower) && Objects.equals(followee, that.followee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(follower, followee);
    }
}
