package com.example.buku_catatan_wildanarrafi.API;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.buku_catatan_wildanarrafi.API.model.ResponseCharacter;
import com.example.buku_catatan_wildanarrafi.API.model.ResultsItem;
import com.example.buku_catatan_wildanarrafi.databinding.ItemApiBinding;

import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiViewHolder> {
    List<ResultsItem> resultsItems;

    public ApiAdapter(List<ResultsItem> resultsItems) {
        this.resultsItems = resultsItems;
    }

    @NonNull
    @Override
    public ApiAdapter.ApiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ApiViewHolder(ItemApiBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ApiAdapter.ApiViewHolder holder, int position) {
        ResultsItem data = resultsItems.get(position);
        holder.binding.tvItemName.setText(data.getName());
        holder.binding.tvItemSpecies.setText(data.getSpecies());

        Glide.with(holder.binding.ivPhoto)
                .load(data.getImage())
                .into(holder.binding.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return resultsItems.size();
    }

    public class ApiViewHolder extends RecyclerView.ViewHolder {

        private ItemApiBinding binding;

        public ApiViewHolder(ItemApiBinding itemApiBinding) {
            super(itemApiBinding.getRoot());
            this.binding = itemApiBinding;
        }
    }
}
