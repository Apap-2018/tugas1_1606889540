package com.apap.Tugas1.service;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.ProvinsiModel;
import com.apap.Tugas1.repository.InstansiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InstansiServiceImp implements InstansiService {
    @Autowired
    private InstansiDB instansiDB;

    @Override
    public List<InstansiModel> findByProvinsi(ProvinsiModel provinsiModel){
        return instansiDB.findByProvinsi(provinsiModel);
    }


    @Override
    public InstansiModel findById(long id){
        return instansiDB.getInstansiModelById(id);
    }

    @Override
    public List<InstansiModel> getAllInstansi(){
        return instansiDB.findAll();
    }
}
