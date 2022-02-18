package com.example.makemymoney;
import static android.content.ContentValues.TAG;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.makemymoney.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    EditText email, password;
    Button loginbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        loginbtn = findViewById(R.id.login);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User loginUser = new User(email.getText().toString(), password.getText().toString());
                Call<User> userPost = apiInterface.registerUser(loginUser);
                userPost.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                        Log.e(TAG, "onResponse"+response.body());
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e(TAG, "onFailure"+t.getLocalizedMessage());
                    }
                });
            }
        });
    }


}
