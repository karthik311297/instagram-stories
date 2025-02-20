package com.karthik.insta.datamodel.model;

import com.karthik.insta.datamodel.model.identifier.FollowGraphId;
import jakarta.persistence.*;

@Entity
@Table(name = "followgraph")
@IdClass(FollowGraphId.class)
public class FollowGraph {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Profile follower;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Profile followee;

    public Profile getFollower() {
        return follower;
    }

    public void setFollower(Profile follower) {
        this.follower = follower;
    }

    public Profile getFollowee() {
        return followee;
    }

    public void setFollowee(Profile followee) {
        this.followee = followee;
    }
}
