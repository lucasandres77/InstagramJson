package com.ejemplo.instagram.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ejemplo.instagram.R;
import com.ejemplo.instagram.controller.InstagramController;
import com.ejemplo.instagram.model.Post;

import java.util.List;

import util.ResultListener;

public class PostList extends AppCompatActivity {
    public static final String USERNAME = "userName";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String userName = bundle.getString(USERNAME);



        InstagramController instagramController = new InstagramController(userName);
        instagramController.getPostList(new ResultListener<List<Post>>() {
            @Override
            public void finish(List<Post> resultado) {

                recyclerView = (RecyclerView) findViewById(R.id.postListRecyclerView);

                recyclerView.setHasFixedSize(true);

                AdapterPostList adapter = new AdapterPostList(resultado,getBaseContext());

                recyclerView.setAdapter(adapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));

               /* Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Compartir en Instagram");
                share.putExtra(Intent.EXTRA_TEXT, "Hola como estan");
                startActivity(Intent.createChooser(share, "Share link!"));*/
            }
        });


    }
}
