package com.apap.Tugas1.service;

import com.apap.Tugas1.model.ProvinsiModel;

import java.util.List;


public interface ProvinsiService {
    List<ProvinsiModel> findAll();

    ProvinsiModel findById(int id);
}
