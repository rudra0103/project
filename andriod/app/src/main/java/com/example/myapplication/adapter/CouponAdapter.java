package com.example.myapplication.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.CouponModel;
import com.example.myapplication.util.ConstantData;

import java.util.ArrayList;
import java.util.List;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.CouponViewHolder> {
    ArrayList<CouponModel> couponList;

    public CouponAdapter(ArrayList<CouponModel> couponList) {
        this.couponList = couponList;
    }

    @NonNull
    @Override
    public CouponViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_coupon, parent, false);
        return new CouponViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouponViewHolder holder, int position) {
        CouponModel coupon = couponList.get(position);

        holder.cou_code.setText(coupon.getCou_code());
        holder.cou_discount.setText(coupon.getCou_discount());
        holder.cou_maxamt.setText(coupon.getCou_maxamt());
        holder.apply_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);

                ClipData clip = ClipData.newPlainText("Coupon Code", coupon.getCou_code());

                clipboard.setPrimaryClip(clip);

                Toast.makeText(v.getContext(), "Coupon copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        // Assuming you have a method to load image from URL or resource
        // loadImage(holder.couponImage, coupon.g
        Glide.with(holder.cou_pic.getContext()).load(ConstantData.SERVER_ADDRESS_IMG+couponList
                .get(position).getCou_pic()).into(holder.cou_pic);
    }

    @Override
    public int getItemCount() {
        return couponList.size();
    }

    public static class CouponViewHolder extends RecyclerView.ViewHolder {
        ImageView cou_pic;
        Button apply_button;
        TextView  cou_code, cou_discount, cou_maxamt;

        public CouponViewHolder(@NonNull View itemView) {
            super(itemView);
            cou_pic = itemView.findViewById(R.id.cou_pic);
            cou_code = itemView.findViewById(R.id.cou_code);
            cou_discount = itemView.findViewById(R.id.cou_discount);
            cou_maxamt = itemView.findViewById(R.id.cou_maxamt);
            apply_button = itemView.findViewById(R.id.apply_button);
        }
    }
}