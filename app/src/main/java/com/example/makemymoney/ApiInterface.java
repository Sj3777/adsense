package com.example.makemymoney;
import com.example.makemymoney.models.ApiResponse;
import com.example.makemymoney.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("/v1/users/register")
    Call<User> registerUser(@Body User user);

    @POST("/v1/users/login")
    Call<ApiResponse> loginUser(@Body User user);
}
