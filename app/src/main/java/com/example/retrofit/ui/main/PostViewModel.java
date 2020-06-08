package com.example.retrofit.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.data.PostClient;
import com.example.retrofit.pojo.ModelPosts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<ModelPosts>>mutableLiveData=new MutableLiveData<>();
    public void getPosts(){
        PostClient.getINSTANCE().getPosts().enqueue(new Callback<List<ModelPosts>>() {
            @Override
            public void onResponse(Call<List<ModelPosts>> call, Response<List<ModelPosts>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ModelPosts>> call, Throwable t) {

            }
        });
    }
}
