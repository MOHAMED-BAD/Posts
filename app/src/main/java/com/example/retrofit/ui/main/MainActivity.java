package com.example.retrofit.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofit.R;
import com.example.retrofit.pojo.ModelPosts;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModel postViewModel;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel= ViewModelProviders.of(MainActivity.this).get(PostViewModel.class);
        postViewModel.getPosts();
        recyclerView=findViewById(R.id.rv);
        final PostAdapter adapter=new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);


        postViewModel.mutableLiveData.observe(MainActivity.this, new Observer<List<ModelPosts>>() {
            @Override
            public void onChanged(List<ModelPosts> modelPosts) {
               adapter.submitList(modelPosts);
            }
        });
    }
}
