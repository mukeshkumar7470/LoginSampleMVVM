package com.hk.loginsamplemvvm.networking;

import com.hk.loginsamplemvvm.models.LoginModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
   /* @GET("posts")
    Call<List<LoginModel>> getPosts();*/

    @POST("login")
    Call<List<LoginModel>> login();
}