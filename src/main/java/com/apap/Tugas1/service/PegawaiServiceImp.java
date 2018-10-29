package com.apap.Tugas1.service;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.PegawaiModel;
import com.apap.Tugas1.repository.PegawaiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PegawaiServiceImp implements PegawaiService{
    @Autowired
    private PegawaiDB pegawaiDB;

    @Override
    public PegawaiModel getPegawaiByNip(String nip){
        return pegawaiDB.findPegawaiByNip(nip);
    }

    @Override
    public void addPegawai(PegawaiModel pegawai){
            pegawaiDB.save(pegawai);
    }

    @Override
    public void deletePegawai(PegawaiModel pegawai){
        pegawaiDB.delete(pegawai);
    }

    @Override
    public List<PegawaiModel> findAll(){
        return pegawaiDB.findAll();
    }

    @Override
    public List<PegawaiModel> findByInstansi(InstansiModel instansi){
        return pegawaiDB.findByInstansi(instansi);
    }

    @Override
    public List<PegawaiModel> findByInstansiOrderByDateAsc(InstansiModel instansi){
        return pegawaiDB.findByInstansiOrderByTanggalLahirAsc(instansi);
    }
}
