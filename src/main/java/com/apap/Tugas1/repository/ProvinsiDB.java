package com.apap.Tugas1.repository;

import com.apap.Tugas1.model.ProvinsiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProvinsiDB extends JpaRepository<ProvinsiModel, Integer> {
    ProvinsiModel getProvinsiById(int id);
}
