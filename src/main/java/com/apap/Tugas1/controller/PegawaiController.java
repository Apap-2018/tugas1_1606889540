package com.apap.Tugas1.controller;

import com.apap.Tugas1.model.InstansiModel;
import com.apap.Tugas1.model.JabatanPegawaiModel;
import com.apap.Tugas1.model.PegawaiModel;
import com.apap.Tugas1.service.InstansiService;
import com.apap.Tugas1.service.JabatanService;
import com.apap.Tugas1.service.PegawaiService;
import com.apap.Tugas1.service.ProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
public class PegawaiController {
    @Autowired
    private PegawaiService pegawaiService;
    @Autowired
    private ProvinsiService provinsiService;
    @Autowired
    private JabatanService jabatanService;
    @Autowired
    private InstansiService instansiService;

    @RequestMapping("/")
    private String home(Model model){
        model.addAttribute("jabatanList", jabatanService.getAllJabatan());
        model.addAttribute("instansiList", instansiService.getAllInstansi());
        return "home";
    }

    @RequestMapping(value="/pegawai", method = RequestMethod.GET)
    public String viewPegawai(@RequestParam(value="nip") String nip, Model model){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNip(nip);

        double maxGajiPokok = pegawai.getJabatanPegawai().get(0).getJabatan().getGajiPokok();
        for(JabatanPegawaiModel jbtn : pegawai.getJabatanPegawai()){
            double curr = jbtn.getJabatan().getGajiPokok();
            if(curr>maxGajiPokok){
                maxGajiPokok = curr;
            }
        }

        double gajiPokok = maxGajiPokok + ((pegawai.getInstansi().getProvinsi().getPresentaseTunjangan()/100)*maxGajiPokok);

        model.addAttribute("gaji", gajiPokok);
        model.addAttribute("pegawai", pegawai);
        return "view-pegawai";
    }

    @RequestMapping(value = "/pegawai/tambah", method = RequestMethod.GET)
    public String addPegawaiForm(Model model){
        model.addAttribute("pegawai", new PegawaiModel());
        model.addAttribute("provinsiList", provinsiService.findAll());
        model.addAttribute("instansiList", instansiService.getAllInstansi());
        model.addAttribute("jabatan", jabatanService.getAllJabatan());
        return "tambah-pegawai";
    }

    @RequestMapping(value = "/pegawai/tambah", method = RequestMethod.POST)
    private String addPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model) {
        System.out.println(pegawai.getInstansi().getId());
        String kodeInstansi = Long.toString(pegawai.getInstansi().getId());
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yy");
        String kodeLahir = dateFormat.format(pegawai.getTanggalLahir());

        int sama = 0;
        for (PegawaiModel pgw : pegawaiService.findAll()){
            if (pgw.getNip().substring(0, 13).equalsIgnoreCase(kodeInstansi+kodeLahir+pegawai.getTahunMasuk())){
                sama++;
            }
        }

        String lastId = "";
        if ((sama+1)<10){lastId="0"+(sama+1);}
        else {lastId=Integer.toString(sama+1);}

        pegawai.setNip(kodeInstansi+kodeLahir+pegawai.getTahunMasuk()+lastId);
        pegawaiService.addPegawai(pegawai);

        model.addAttribute("pegawai", pegawai);
        return "tambah-pegawai-success";
    }

    @RequestMapping(value="/pegawai/ubah", method = RequestMethod.GET)
    public String updatePegawai(@RequestParam(value="nip") String nip, Model model){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNip(nip);
        model.addAttribute("provinsiList", provinsiService.findAll());
        model.addAttribute("jabatan", jabatanService.getAllJabatan());
        model.addAttribute("pegawai", pegawai);
        return "update-pegawai";
    }

    @RequestMapping(value="/pegawai/cari", method = RequestMethod.GET)
    public String cariPegawai(@RequestParam(value="idProvinsi", defaultValue = "0") String idProvinsi,
                              @RequestParam(value="idInstansi", defaultValue = "0") String idInstansi,
                              @RequestParam(value="idJabatan", defaultValue = "0") String idJabatan,
                              Model model){


        model.addAttribute("provinsiList", provinsiService.findAll());
        model.addAttribute("instansiList", instansiService.getAllInstansi());
        model.addAttribute("jabatan", jabatanService.getAllJabatan());

        return "cari-pegawai";
    }

    @RequestMapping(path="/jabatan/viewall")
    public String viewAllJabatan(){
        return "viewall-jabatan";
    }

    @RequestMapping(path = "/pegawai/termuda-tertua/", method = RequestMethod.GET)
    public String termudaTertua(@RequestParam(value="idInstansi") String idInstansi, Model model){
        InstansiModel instansi = instansiService.findById(Long.parseLong(idInstansi));
        List<PegawaiModel> listPegawai = pegawaiService.findByInstansiOrderByDateAsc(instansi);

        PegawaiModel pgwMuda = listPegawai.get(listPegawai.size()-1);
        PegawaiModel pgwTua = listPegawai.get(0);

        model.addAttribute("instansi", instansi);
        model.addAttribute("pegawaiMuda", pgwMuda);
        System.out.println(pgwMuda.getNama());
        model.addAttribute("pegawaiTua", pgwTua);

        return "termuda-tertua";
    }


    /**@RequestMapping(value = "/instansi-list", method = RequestMethod.GET)
    public @ResponseBody
    List<InstansiModel> findAllInstansi(@RequestParam(value = "provinsiId", required = true) int provinsiId, Model model) {
        ProvinsiModel provinsi = provinsiService.findById(provinsiId);
        return instansiService.findByProvinsi(provinsi);
    } **/
}
