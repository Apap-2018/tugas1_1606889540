package com.apap.Tugas1.service;

import com.apap.Tugas1.model.ProvinsiModel;
import com.apap.Tugas1.repository.ProvinsiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProvinsiServiceImp implements ProvinsiService{
    @Autowired
    private ProvinsiDB provinsiDB;

    @Override
    public List<ProvinsiModel> findAll(){
        return provinsiDB.findAll();
    }

    @Override
    public ProvinsiModel findById(int id){
        return provinsiDB.getProvinsiById(id);
    }



}
