package com.example.retrofit.data;

import com.example.retrofit.pojo.ModelPosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Call<List<ModelPosts>> getPosts();
}
