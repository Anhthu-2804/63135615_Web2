package thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.models.SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SinhVienServiceImpl {
    static List<SinhVien> dsSinhVien=  new ArrayList<SinhVien>();
    static {
        dsSinhVien.add(new SinhVien("1","a",1));
        dsSinhVien.add(new SinhVien("2","b",2));
        dsSinhVien.add(new SinhVien("3","c",3));
        dsSinhVien.add(new SinhVien("4","d",4));

    }
    public String timKiem(String ms){
        for (SinhVien e: dsSinhVien){
            if (e.getMaSV().equals(ms));
                return e.toString();
        }
        return "khong tim thay";
    }

    // Service tìm kiếm thông tin qua mã
    public SinhVien timKiemTheoMa(String ma) {
        return dsSinhVien.stream()
                .filter(sinhVien -> sinhVien.getMaSV().equals(ma))
                .findFirst()
                .orElse(null);
    }

    // Service trả về toàn bộ danh sách sinh viên
    public List<SinhVien> layToanBoSinhVien() {
        return dsSinhVien;
    }

    // Service thêm mới một phần tử vào danh sách
    public void themSinhVien(SinhVien sinhVienMoi) {
        dsSinhVien.add(sinhVienMoi);
    }

}
