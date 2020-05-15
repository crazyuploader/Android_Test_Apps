package com.github.crazyuploader.jsonparser;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userID;

    @SerializedName("id")
    private int postID;

    private String title;

    @SerializedName("body")
    private String text;

    public int getUserID() {
        return userID;
    }

    public int getPostID() {
        return postID;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
