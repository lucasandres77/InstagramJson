package com.ejemplo.instagram.model;

import java.util.List;

/**
 * Created by andres on 06/07/16.
 */
public class PostContainer {

    private List<Post> items;

    public void setPosts(List<Post> items) {
        this.items = items;
    }

    public List<Post> getPosts() {
        return items;
    }
}
