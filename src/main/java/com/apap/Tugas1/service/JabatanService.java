package com.apap.Tugas1.service;

import com.apap.Tugas1.model.JabatanModel;

import java.util.List;


public interface JabatanService {
    List<JabatanModel> getAllJabatan();
    void addJabatan(JabatanModel jabatan);
    void deleteJabatan(JabatanModel jabatanModel);
    JabatanModel getJabatanById(long id);

}
