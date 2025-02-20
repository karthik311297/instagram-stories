package com.karthik.insta.datamodel.model.identifier;

import java.io.Serializable;

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
}
