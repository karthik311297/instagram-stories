package com.karthik.insta.profile.request;

public class ProfileCreateRequest {

    private String username;
    private String summary;

    public ProfileCreateRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
