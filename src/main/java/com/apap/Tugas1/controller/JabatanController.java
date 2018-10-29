package com.apap.Tugas1.controller;

import com.apap.Tugas1.model.JabatanModel;
import com.apap.Tugas1.service.JabatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JabatanController {
    @Autowired
    private JabatanService jabatanService;

    @RequestMapping(value = "/jabatan/tambah", method = RequestMethod.GET)
    public String addJabatanForm(Model model){

        model.addAttribute("jabatan", new JabatanModel());
        return "tambah-jabatan";
    }

    @RequestMapping(value="/jabatan/tambah", method = RequestMethod.POST)
    public String addJabatanSubmit(@ModelAttribute JabatanModel jabatanModel, Model model){
        jabatanService.addJabatan(jabatanModel);
        model.addAttribute("jabatan", jabatanModel);
        return "tambah-jabatan-success";
    }

    @RequestMapping(value="/jabatan/view", method = RequestMethod.GET)
    public String viewJabatan(@RequestParam("idJabatan") long id, Model model){
        JabatanModel jabatan = jabatanService.getJabatanById(id);

        model.addAttribute("jabatan", jabatan);
        return "view-jabatan";
    }

    @RequestMapping(value="/jabatan/ubah", method = RequestMethod.POST)
    public String update(@ModelAttribute JabatanModel jabatanModel, Model model){
        jabatanService.addJabatan(jabatanModel);
        model.addAttribute("jabatan", jabatanModel);
        return "ubah-jabatan-success";
    }

    @RequestMapping(value = "/jabatan/ubah", method = RequestMethod.GET)
    private String updateJabatan(@RequestParam("idJabatan") long id, Model model) {
        JabatanModel jab = jabatanService.getJabatanById(id);
        model.addAttribute("jabatan", jab);
        return "update-jabatan";
    }

    @RequestMapping(value = "/jabatan/hapus", method = RequestMethod.POST)
    public String deleteJabatan(@RequestParam("idJabatan") long id, Model model){
        JabatanModel jab = jabatanService.getJabatanById(id);
        jabatanService.deleteJabatan(jab);
        return "delete";
    }


}
