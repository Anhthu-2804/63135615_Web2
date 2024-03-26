package thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.models.SinhVien;
import thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.service.SinhVienServiceImpl;

@Controller
public class SinhVienController {

    @Autowired
    private SinhVienServiceImpl sinhVienService;

    @GetMapping("/danhsachSV")
    public String listStudent(ModelMap md) {
        md.addAttribute("dsSV", sinhVienService.layToanBoSinhVien());
        return "sinhVienList";
    }
    @GetMapping("/themMoiSV")
    public String showForm(Model md) {
        SinhVien sv = new SinhVien();
        md.addAttribute("sv",sv);
        return "themSinhVienForm";
    }

    @PostMapping("/themMoiSV")
    public String themSinhVien(@ModelAttribute("sv") SinhVien sv, Model model) {
        sinhVienService.themSinhVien(sv);
        return "themSinhVien_TB";
    }

    @GetMapping("/timkiemsv")
    public String timKiemSinhVienTheoMa(@RequestParam("maSinhVien") String maSinhVien, Model model) {
        SinhVien sinhVien = sinhVienService.timKiem(maSinhVien);
        model.addAttribute("ketQuaTimKiem", sinhVien);
        return "timKiemOK";
    }
}
