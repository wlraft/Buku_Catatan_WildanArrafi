package com.example.buku_catatan_wildanarrafi.API;

import com.example.buku_catatan_wildanarrafi.API.model.ResponseCharacter;
import com.example.buku_catatan_wildanarrafi.API.model.login.ResponseLogin;
import com.example.buku_catatan_wildanarrafi.API.model.register.ResponseRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("character")
    Call<ResponseCharacter> getCharacter();

    @FormUrlEncoded
    @POST("register")
    Call<ResponseRegister> requestRegister(@Field("name") String name,
                                           @Field("email") String email,
                                           @Field("password") String password);
    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin> requestLogin(@Field("email") String email,
                                     @Field("password") String password);
}
