package com.apap.Tugas1.service;

import com.apap.Tugas1.model.JabatanModel;
import com.apap.Tugas1.repository.JabatanDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JabatanServiceImp implements JabatanService{
    @Autowired
    private JabatanDB jabatanDB;

    @Override
    public void addJabatan(JabatanModel jabatan){
        jabatanDB.save(jabatan);
    }

    @Override
    public void deleteJabatan(JabatanModel jabatanModel){
        jabatanDB.delete(jabatanModel);
    }

    @Override
    public List<JabatanModel> getAllJabatan(){
        return jabatanDB.findAll();
    }

    @Override
    public JabatanModel getJabatanById(long id){
        return jabatanDB.findById(id);
    }
}

