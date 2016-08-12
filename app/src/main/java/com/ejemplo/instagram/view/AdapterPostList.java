package com.ejemplo.instagram.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ejemplo.instagram.R;
import com.ejemplo.instagram.model.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lucas on 7/6/16.
 */
public class AdapterPostList extends RecyclerView.Adapter {

    private List<Post> postList;
    private Context context;

    public AdapterPostList(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_detalle, parent, false);
        PostViewHolder postViewHolder = new PostViewHolder(itemView);
        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Post post = postList.get(position);
        PostViewHolder postViewHolder = (PostViewHolder) holder;
        postViewHolder.bindPost(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewNewsPicture;
        private TextView textViewText;
        private TextView textViewLikes;

        public PostViewHolder(View itemView) {
            super(itemView);

            imageViewNewsPicture = (ImageView) itemView.findViewById(R.id.imageViewThumbnail);
            textViewText = (TextView) itemView.findViewById(R.id.textViewText);
            textViewLikes = (TextView) itemView.findViewById(R.id.textViewLikes);
        }

        public void bindPost(Post post) {

            Picasso.with(context).load(post.getImage().getStandard().getUrl()).into(imageViewNewsPicture);
            textViewText.setText(post.getCaption().getText());
            textViewLikes.setText(post.getLikes().getCount().toString());
        }
    }
}

