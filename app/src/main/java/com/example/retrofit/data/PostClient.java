package com.example.retrofit.data;

import com.example.retrofit.pojo.ModelPosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String Base_Url="https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface =retrofit.create(PostInterface.class);
    }

    public static PostClient getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE=new PostClient();
        }
        return INSTANCE;
    }
    public Call<List<ModelPosts>>getPosts(){
        return postInterface.getPosts();
    }
}
