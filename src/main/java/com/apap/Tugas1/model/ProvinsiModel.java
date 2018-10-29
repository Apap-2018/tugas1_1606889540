package com.apap.Tugas1.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="provinsi")
public class ProvinsiModel implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max=255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Column(name = "presentase_tunjangan")
    private double presentaseTunjangan;

    @OneToMany(mappedBy = "provinsi", fetch = FetchType.LAZY)
    private List<InstansiModel> instansi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getPresentaseTunjangan() {
        return presentaseTunjangan;
    }

    public void setPersentase_tunjangan(double presentase_tunjangan) {
        this.presentaseTunjangan = presentase_tunjangan;
    }

    public List<InstansiModel> getInstansi() {
        return instansi;
    }

    public void setInstansi(List<InstansiModel> instansi) {
        this.instansi = instansi;
    }
}
