package com.apap.Tugas1.repository;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PegawaiDB extends JpaRepository<PegawaiModel, Long> {
        PegawaiModel findPegawaiByNip(String nip);
        List<PegawaiModel> findByInstansi(InstansiModel instansiModel);
        List<PegawaiModel> findByInstansiOrderByTanggalLahirAsc(InstansiModel instansiModel);
}
