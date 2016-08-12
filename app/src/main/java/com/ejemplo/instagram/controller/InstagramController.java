package com.ejemplo.instagram.controller;

import android.content.Context;

import com.ejemplo.instagram.dao.InstagramDAO;
import com.ejemplo.instagram.model.Post;

import java.util.List;

import util.ResultListener;

/**
 * Created by digitalhouse on 6/06/16.
 */
public class InstagramController {

    private String userName;

    public InstagramController(String userName) {
        this.userName = userName;
    }

    //El controller se encarga de pedirle la lista al DAO y luego le avisa al listener de la vista que ya esta disponible para que la use.
    public void getPostList(final ResultListener<List<Post>> listener){
        InstagramDAO instagramDAO = new InstagramDAO(userName);

        instagramDAO.getAllPost(new ResultListener<List<Post>>() {
            @Override
            public void finish(List<Post> resultado) {
                listener.finish(resultado);
            }
        });
    }
}
