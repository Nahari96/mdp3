package com.example.fajar.modul2kel39.ui.detailcar;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fajar.modul2kel39.R;
import com.example.fajar.modul2kel39.data.model.DataCar;
import com.example.fajar.modul2kel39.ui.home.HomeActivity;
import com.example.fajar.modul2kel39.utility.Constant;

import java.util.List;


public class DetailActivity extends AppCompatActivity implements DetailView {

    private DataCar car;
    private DetailPresenter Presenter;
    private TextView tvName;
    private TextView tvMerk;
    private TextView tvModel;
    private TextView tvYear;

    @Override
    public void onBackPressed() {
        back();
    }

    private void back() {
        Intent reg = new Intent(this, HomeActivity.class);
        startActivity(reg);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailcar);
        initView();
        initIntentData();
        initPresenter();
        initData();
    }

    private void initView() {
        tvName = findViewById(R.id.tvName);
        tvMerk = findViewById(R.id.tvMerk);
        tvModel = findViewById(R.id.tvModel);
        tvYear = findViewById(R.id.tvYear);
         }

    private void initData() {
        Presenter.getCarById(car);
    }

    private void initPresenter() {
        Presenter = new DetailPresenter(this);
    }

    private void initIntentData() {
        car = getIntent().getParcelableExtra(Constant.Extra.DATA);
        if (car == null) finish();
    }

    @Override
    public void showErrorCarById(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessCarById(List<DataCar> dataCar) {
        tvName.setText(dataCar.get(0).getName());
        tvMerk.setText(dataCar.get(0).getMerk());
        tvModel.setText(dataCar.get(0).getModel());
        tvYear.setText(dataCar.get(0).getYear());

    }


}
