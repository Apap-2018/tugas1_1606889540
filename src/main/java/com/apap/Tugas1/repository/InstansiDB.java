package com.apap.Tugas1.repository;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.ProvinsiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstansiDB extends JpaRepository<InstansiModel, Long> {

    List<InstansiModel> findByProvinsi(ProvinsiModel provinsiModel);
    InstansiModel getInstansiModelById(long id);

}
