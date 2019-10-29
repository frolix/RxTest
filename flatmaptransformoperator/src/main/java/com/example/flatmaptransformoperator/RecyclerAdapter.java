package com.example.flatmaptransformoperator;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.flatmaptransformoperator.models.Post;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {

    private static final String TAG = "MainActivity";

    private List<Post> posts = new ArrayList<>();

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, null, false);
        return new myViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    public void updatePost(Post post){
        posts.set(posts.indexOf(post), post);
        notifyItemChanged(posts.indexOf(post));
    }

    public List<Post> getPosts(){
        return posts;
    }


    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView title,numComents;
        ProgressBar progressBar;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            numComents = itemView.findViewById(R.id.num_comments);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }

        public void bind(Post post){
            title.setText(post.getTitle());

            if (post.getComments()==null){
                showProgressBar(true);
                numComents.setText("");
                Log.d(TAG, "       get comments equal null ");
            }
            else {
                showProgressBar(false);
                Log.d(TAG, "      get comments not equal null      ");
                numComents.setText(String.valueOf(post.getComments().size()));
            }

        }

        private void showProgressBar(boolean showProgressBar){
            if (showProgressBar){
                progressBar.setVisibility(View.VISIBLE);
            }
            else {
                progressBar.setVisibility(View.GONE);
            }
        }

    }

}
