package thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.models.SinhVien;
import thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.service.SinhVienServiceImpl;

@Controller
public class SinhVienController {

    private SinhVienServiceImpl sinhVienService;

//    @GetMapping("/themMoiSV")
//    public String showForm(Model md) {
//        SinhVien sv = new SinhVien();
//        md.addAttribute("sv",sv);
//        return "themSinhVienForm";
//    }
//    @PostMapping("")
//    public String submitForm(@ModelAttribute("sv") SinhVien sv) {
//        return "themSinhVien_TB";
//    }

    @PostMapping("/themMoiSV")
    public void themSinhVien(@RequestBody SinhVien sv) {
        sinhVienService.themSinhVien(sv);
    }
}
