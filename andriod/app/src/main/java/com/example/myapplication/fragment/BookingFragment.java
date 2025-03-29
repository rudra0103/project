package com.example.myapplication.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.activity.BookingActivity;
import com.example.myapplication.activity.LoginActivity;
import com.example.myapplication.adapter.BookingAdapter;
import com.example.myapplication.api.BookingApi;
import com.example.myapplication.model.BookingOutputModel;
import com.example.myapplication.util.ConstantData;

public class BookingFragment extends Fragment {

    View view;
    RecyclerView rcyl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_cart, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcyl=view.findViewById(R.id.rcyl);
        rcyl.setLayoutManager(new LinearLayoutManager(getContext()));
        SharedPreferences sp = getActivity().getSharedPreferences(ConstantData.SP_NAME, MODE_PRIVATE);

        String uid = sp.getString(ConstantData.KEY_USER_ID, "0");
        if (uid.equals("0")) {
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        } else {
        }


        new BookingApi().get(this,uid);


    }
    public  void setbook(BookingOutputModel bookingOutputModel){
        BookingAdapter adapter=new BookingAdapter(getContext(),bookingOutputModel.getBooking());
        rcyl.setAdapter(adapter);
        rcyl.setHasFixedSize(true);
    }
}