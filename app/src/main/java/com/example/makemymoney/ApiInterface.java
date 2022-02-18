package com.example.makemymoney;
import com.example.makemymoney.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/register")
    Call<User> registerUser(@Body User user);

    @POST("/login")
    Call<User> loginUser(@Body User user);
}
