package com.example.retrofit.ui.main;

import android.graphics.ColorSpace;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.pojo.ModelPosts;

public class PostAdapter extends ListAdapter<ModelPosts, PostAdapter.ContactViewHolder> {
    static DiffUtil.ItemCallback<ModelPosts> diffCallback = new DiffUtil.ItemCallback<ModelPosts>() {

        @Override
        public boolean areItemsTheSame(@NonNull ModelPosts oldItem, @NonNull ModelPosts newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ModelPosts oldItem, @NonNull ModelPosts newItem) {
            return oldItem.getBody().equals(newItem.getBody());
        }
    };

    protected PostAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
       holder.onBind(getItem(position));
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView id , title , body;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.userid);
            title=itemView.findViewById(R.id.tittle);
            body=itemView.findViewById(R.id.body);

        }
        void onBind(ModelPosts posts){
            id.setText(String.valueOf(posts.getUserId()));
            title.setText(posts.getTitle());
            body.setText(posts.getBody());
        }

    }
}

