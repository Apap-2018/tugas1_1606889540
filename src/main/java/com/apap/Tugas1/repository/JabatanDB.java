package com.apap.Tugas1.repository;

import com.apap.Tugas1.model.JabatanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JabatanDB extends JpaRepository<JabatanModel, Long> {
        JabatanModel findById(long id_jabatan);
}


