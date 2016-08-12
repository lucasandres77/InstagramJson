package com.ejemplo.instagram.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andres on 06/07/16.
 */
public class Post {

    private String link;
    @SerializedName("images")
    private Image image;
    private Caption caption;
    private Likes likes;

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }
    //URL PARA OBTENER IMAGEN
    // api.instagram.com/p/CODIGODEIMAGEN/media/?size=t


    public void setLink(String link) {
        this.link = link;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public String getLink() {
        return link;
    }
}
