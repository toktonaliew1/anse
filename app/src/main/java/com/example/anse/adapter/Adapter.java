package com.example.anse.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anse.databinding.ListBinding;
import com.example.anse.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<MainModel> list = new ArrayList<>();

    public void setData(List<MainModel> mainModels) {
        list = mainModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                ListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      private ListBinding binding;

        public ViewHolder(@NonNull ListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(MainModel mainModel) {
            binding.name.setText(mainModel.getName());
            binding.description.setText(mainModel.getDescription());
        }
    }
}
