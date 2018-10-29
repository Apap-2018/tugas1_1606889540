package com.apap.Tugas1.controller;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.JabatanModel;
import com.apap.Tugas1.model.ProvinsiModel;
import com.apap.Tugas1.service.InstansiService;
import com.apap.Tugas1.service.JabatanService;
import com.apap.Tugas1.service.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JabatanRestController {
    @Autowired
    private JabatanService jabatanService;
    @Autowired
    private InstansiService instansiService;
    @Autowired
    private ProvinsiService provinsiService;

    @RequestMapping(path="/listjabatan", method = RequestMethod.GET)
    public List<JabatanModel> getJabatanList(){
        return jabatanService.getAllJabatan();
    }

    @RequestMapping(path="/listinstansi", method = RequestMethod.GET)
    public List<InstansiModel> getByProvinsi(@RequestParam(value = "idProvinsi", required = true) int idProvinsi){
        ProvinsiModel provinsiModel = provinsiService.findById(idProvinsi);
        return instansiService.findByProvinsi(provinsiModel);
    }
}
