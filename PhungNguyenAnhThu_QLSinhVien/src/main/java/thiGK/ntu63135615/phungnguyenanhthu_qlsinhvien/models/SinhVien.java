package thiGK.ntu63135615.phungnguyenanhthu_qlsinhvien.models;

public class SinhVien {
    String maSV, name;
    int diemTichLuy;

    public SinhVien(String maSV, String name, int diemTichLuy) {
        this.maSV = maSV;
        this.name = name;
        this.diemTichLuy = diemTichLuy;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiemTichLuy() {
        return diemTichLuy;
    }

    public void setDiemTichLuy(int diemTichLuy) {
        this.diemTichLuy = diemTichLuy;
    }
}
