package com.example.fajar.modul2kel39.ui.detailcar;

import com.example.fajar.modul2kel39.data.model.DataCar;

import java.util.List;

public interface DetailView {

    void showErrorCarById(String message);

    void showSuccessCarById(List<DataCar> car);
}
