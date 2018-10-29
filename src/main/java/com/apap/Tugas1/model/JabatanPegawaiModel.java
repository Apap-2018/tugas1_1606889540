package com.apap.Tugas1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="jabatan_pegawai")
public class JabatanPegawaiModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_pegawai")
    @JsonIgnore
    private PegawaiModel pegawai;

    @ManyToOne
    @JoinColumn(name = "id_jabatan")
    @JsonIgnore
    private JabatanModel jabatan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PegawaiModel getPegawai() {
        return pegawai;
    }

    public void setPegawai(PegawaiModel pegawai) {
        this.pegawai = pegawai;
    }

    public JabatanModel getJabatan() {
        return jabatan;
    }

    public void setJabatan(JabatanModel jabatan) {
        this.jabatan = jabatan;
    }
}
