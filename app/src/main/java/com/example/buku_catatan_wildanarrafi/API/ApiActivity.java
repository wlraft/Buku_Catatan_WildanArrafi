package com.example.buku_catatan_wildanarrafi.API;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.buku_catatan_wildanarrafi.API.model.ResponseCharacter;
import com.example.buku_catatan_wildanarrafi.API.model.ResultsItem;
import com.example.buku_catatan_wildanarrafi.R;
import com.example.buku_catatan_wildanarrafi.databinding.ActivityApiBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {

    private ActivityApiBinding binding;

    private ApiAdapter apiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.RvApi.setHasFixedSize(true);
        binding.RvApi.setLayoutManager(new LinearLayoutManager(this));

        ApiConfig.service.getCharacter().enqueue(new Callback<ResponseCharacter>() {
            @Override
            public void onResponse(Call<ResponseCharacter> call, Response<ResponseCharacter> response) {
                if (response.isSuccessful()) {
                    ResponseCharacter responseCharacter = response.body();
                    List<ResultsItem> result = responseCharacter.getResults();
                    apiAdapter = new ApiAdapter(result);
                    binding.RvApi.setAdapter(apiAdapter);
                }else {
                    Toast.makeText(ApiActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseCharacter> call, Throwable t) {
                Toast.makeText(ApiActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();

            }
        });
    }
}