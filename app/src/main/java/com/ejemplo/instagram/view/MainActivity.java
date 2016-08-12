package com.ejemplo.instagram.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.ejemplo.instagram.R;
import com.ejemplo.instagram.controller.InstagramController;
import com.ejemplo.instagram.model.Post;

import java.util.List;

import util.ResultListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void getUsernameImages(View view){

        EditText editText = (EditText)findViewById(R.id.inputUserName);

        String userName = editText.getText().toString();

        Intent intent = new Intent(this, PostList.class);

        Bundle bundle = new Bundle();

        bundle.putString(PostList.USERNAME, userName);

        intent.putExtras(bundle);

        startActivity(intent);


    }
}
