package com.example.fajar.modul2kel39.ui.home;

import com.example.fajar.modul2kel39.data.model.DataCar;

import java.util.List;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);

}
