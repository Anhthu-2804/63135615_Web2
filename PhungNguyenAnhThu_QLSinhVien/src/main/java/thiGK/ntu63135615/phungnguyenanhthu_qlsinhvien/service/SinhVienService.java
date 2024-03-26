package thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.models.SinhVien;

@Service
public interface SinhVienService {
    public Page<SinhVien> findPaginated(Pageable pageable);

}
