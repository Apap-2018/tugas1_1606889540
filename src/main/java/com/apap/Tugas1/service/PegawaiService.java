package com.apap.Tugas1.service;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.PegawaiModel;

import java.util.List;

public interface PegawaiService {
    PegawaiModel getPegawaiByNip(String nip);
    void addPegawai(PegawaiModel pegawai);
    void deletePegawai(PegawaiModel pegawai);
    List<PegawaiModel> findByInstansi(InstansiModel instansi);
    List<PegawaiModel> findAll();
    List<PegawaiModel> findByInstansiOrderByDateAsc(InstansiModel instansi);
}
