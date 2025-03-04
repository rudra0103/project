package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.CategoryModel;
import com.example.myapplication.util.ConstantData;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CViewHolder> {

    ArrayList<CategoryModel> categoryModels;

    public CategoryAdapter(ArrayList<CategoryModel> categoryModels) {
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public CViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_category, parent, false);
        return new CViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CViewHolder holder, int position) {
        holder.categoryName.setText(categoryModels.get(position).getCat_name());
        Glide.with(holder.categoryImage.getContext()).load(ConstantData.SERVER_ADDRESS_IMG+categoryModels
                .get(position).getCat_pic()).into(holder.categoryImage);
    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class CViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImage;
        TextView categoryName;
        TextView categoryDesc;
        public CViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage=itemView.findViewById(R.id.categoryImage);
            categoryName=itemView.findViewById(R.id.categoryName);

        }
    }
}
