package com.example.myapplication.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.activity.ServiceDetailActivity;
import com.example.myapplication.model.ServiceModel;
import com.example.myapplication.util.ConstantData;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    ArrayList<ServiceModel> service;

    public ServiceAdapter(ArrayList<ServiceModel> service) {
        this.service = service;
    }
    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_service, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        holder.txtprice.setText(service.get(position).getPrice());
        holder.txtName.setText(service.get(position).getTitle());
        holder.txtdes.setText(service.get(position).getDuration());

        Glide.with(holder.img.getContext()).load(ConstantData.SERVER_ADDRESS_IMG+ service
                .get(position).getSer_pic1()).into(holder.img);
        Glide.with(holder.img.getContext()).load(ConstantData.SERVER_ADDRESS_IMG+ service
                .get(position).getSer_pic2()).into(holder.img);
        Glide.with(holder.img.getContext()).load(ConstantData.SERVER_ADDRESS_IMG+ service
                .get(position).getSer_pic3()).into(holder.img);


        holder.img.setOnClickListener(v -> {
            Intent intent=new Intent(holder.img.getContext(), ServiceDetailActivity.class);
            intent.putExtra("model",service.get(position));
            holder.img.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return service.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        TextView txtName, txtprice, txtdes;

        public ServiceViewHolder(View itemView) {
            super(itemView);

            // Initialize views in the ViewHolder
            img=itemView.findViewById(R.id.img);
            txtName=itemView.findViewById(R.id.txtName);
            txtprice=itemView.findViewById(R.id.txtprice);
            txtdes=itemView.findViewById(R.id.txtdes);
            img=itemView.findViewById(R.id.img);
        }
    }
}
