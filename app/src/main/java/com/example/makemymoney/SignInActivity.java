package com.example.makemymoney;
import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.makemymoney.models.ApiResponse;
import com.example.makemymoney.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    EditText email, password;
    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        loginbtn = findViewById(R.id.login);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User loginUser = new User(email.getText().toString(), password.getText().toString());
                Call<ApiResponse> apiResponseCall = apiInterface.loginUser(loginUser);
                apiResponseCall.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        if (response.isSuccessful()) {
                            ApiResponse apiResponse = response.body();
                            apiResponse.setData(response.body().getData());
                            Intent intent = new Intent(SignInActivity.this, DashboardActivity.class);
                            startActivity(intent);
                            Toast.makeText(SignInActivity.this, "onResponse: " + apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "onResponse: Success  " + response);
                            Log.e(TAG, "onResponse: Success-2 " + apiResponse.getData().getName()+" "+apiResponse.getData().getEmail());
                        } else {
                            Toast.makeText(SignInActivity.this, "onResponse: Fail" + response.errorBody(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Log.e(TAG, "onFailure: "+t.getLocalizedMessage());
                    }
                });
            }
        });
    }
}