package com.example.buku_catatan_wildanarrafi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.buku_catatan_wildanarrafi.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.Collection;

public class RecyclerViewActivity extends AppCompatActivity {

    private ActivityRecyclerViewBinding binding;
    private ArrayList<DataModel> dataModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvList.setHasFixedSize(true);
        dataModels.addAll(getListData());
        showRecyclerView();
    }

    private void showRecyclerView() {
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(dataModels);
        binding.rvList.setAdapter(adapter);
    }

    private ArrayList<DataModel> getListData() {
        String[] namaList = {"Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan",
                "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan"};
        String[] deskripsiList = {"Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan",
                "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan", "Wildan"};

        ArrayList<DataModel> dataModel = new ArrayList<>();
        for (int i = 0; i < namaList.length; i++) {
            DataModel data = new DataModel();
            data.setNama(namaList[i]);
            data.setDeskripsi(deskripsiList[i]);
            dataModel.add(data);
        }

        return dataModel;
    }
}