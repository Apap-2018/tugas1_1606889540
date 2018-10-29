package com.apap.Tugas1.service;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.ProvinsiModel;

import java.util.List;


public interface InstansiService {
    List<InstansiModel> findByProvinsi(ProvinsiModel provinsiModel);
    InstansiModel findById(long id);
    List<InstansiModel> getAllInstansi();
}
