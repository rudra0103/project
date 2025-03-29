package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.BookingModel;
import com.example.myapplication.util.ConstantData;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {
    private Context context;
    private List<BookingModel> bookingList;

    public BookingAdapter(Context context, List<BookingModel> bookingList) {
        this.context = context;
        this.bookingList = bookingList;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_booking, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        BookingModel booking = bookingList.get(position);
        holder.name.setText(booking.getName());
        holder.price.setText(String.valueOf(booking.getAmount())); // Assuming 'amount' is the price

        Glide.with(context).load(ConstantData.SERVER_ADDRESS_IMG+booking.getPic1()).into(holder.pic);

        // You can add click listeners for any actions, like deleting an item
        holder.delete.setOnClickListener(v -> {
            // Handle delete action
            bookingList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, bookingList.size());
        });
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public static class BookingViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageView pic, delete;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.TxtRename);
            price = itemView.findViewById(R.id.TxtPrice);
            pic = itemView.findViewById(R.id.Oimg);
            delete = itemView.findViewById(R.id.imgdel);
        }
    }
}
