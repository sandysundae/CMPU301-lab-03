package com.example.listycitylab3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.Serializable;

public class EditCityFragment extends DialogFragment {
    City city;
    int position;
    interface EditCityDialogListener {
        void editCity(City city, int position);
    }
    void saveCity(City newCity, int position){
        this.city = newCity;
        this.position = position;
    }
    private EditCityDialogListener listener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof EditCityDialogListener) {
            listener = (EditCityDialogListener) context;
        } else {
            throw new RuntimeException(context + " must implement AddCityDialogListener");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_add_city, null);
        EditText editCityName = view.findViewById(R.id.edit_text_city_text);
        EditText editProvinceName = view.findViewById(R.id.edit_text_province_text);
        System.out.println(city);
        if (city != null){
            editCityName.setText(city.getName());
            editProvinceName.setText(city.getProvince());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Edit a city")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Edit", (dialog, which) -> {
                    String cityName = editCityName.getText().toString();
                    String provinceName = editProvinceName.getText().toString();
                    listener.editCity(new City(cityName, provinceName),position );
                })
                .create();
    }
}
