package com.example.buku_catatan_wildanarrafi.API.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.buku_catatan_wildanarrafi.API.ApiConfig;
import com.example.buku_catatan_wildanarrafi.API.model.login.ResponseLogin;
import com.example.buku_catatan_wildanarrafi.MainActivity;
import com.example.buku_catatan_wildanarrafi.R;
import com.example.buku_catatan_wildanarrafi.databinding.ActivityLogin2Binding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLogin2Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogin2Binding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login2);

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = binding.etEmail.getText().toString().trim();
                String getPassword = binding.etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(getEmail)) {
                    binding.etEmail.setError("Email Tidak Boleh Kosong");
                } else if (TextUtils.isEmpty(getPassword)) {
                    binding.etPassword.setError("Password Tidak Boleh Kosong");
                } else {
                    login(getEmail, getPassword);
                }
            }

            private void login(String getEmail, String getPassword) {
                ApiConfig.service.requestLogin(getEmail, getPassword).enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        if (response.isSuccessful()) {
                            ResponseLogin responseLogin = response.body();
                            boolean status = responseLogin.isError();
                            if (!status){
                                Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                Intent main = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(main);
                                finishAffinity();
                            }else {
                                Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Toast.makeText(LoginActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}