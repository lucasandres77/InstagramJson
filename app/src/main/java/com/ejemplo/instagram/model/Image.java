package com.ejemplo.instagram.model;

import com.google.gson.annotations.SerializedName;

import java.security.PrivateKey;

/**
 * Created by Lucas on 7/6/16.
 */
public class Image {
    @SerializedName("standard_resolution")
    private Standard standard;

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }
}
