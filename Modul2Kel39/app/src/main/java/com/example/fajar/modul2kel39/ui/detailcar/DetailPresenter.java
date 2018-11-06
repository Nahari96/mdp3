package com.example.fajar.modul2kel39.ui.detailcar;

import android.util.Log;

import com.example.fajar.modul2kel39.data.model.DataCar;
import com.example.fajar.modul2kel39.data.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {

    private final DetailView View;

    public DetailPresenter(DetailView detailView) {
        View = detailView;
    }

    public void getCarById(DataCar car) {
        RetrofitClient.getInstance()
                .getApi()
                .GetCarById(car.getId())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject body = response.body();
                            JsonArray array = body.get("Hasil").getAsJsonArray();
                            Type type =new TypeToken<List<DataCar>>(){}.getType();
                            List<DataCar> dataCar = new Gson().fromJson(array, type);
                            View.showSuccessCarById(dataCar);

                        } else {
                            // TODO: 11/18/17
                            View.showErrorCarById("ERROR");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("DATA", t.getMessage());
                        View.showErrorCarById(t.getMessage());
                    }
                });
    }
}
