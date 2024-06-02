package com.example.qlbh_mypham.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GioHang {
    private List<GioHangItem> itemList = new ArrayList<>();
    private BigDecimal tongTien = BigDecimal.ZERO;

    public void addItem(GioHangItem item) {
        itemList.add(item);
    }

    public void removeItem(GioHangItem item) {
        itemList.remove(item);
    }

    public void updateItem(SanPham sanPham, int soLuong) {
        for (GioHangItem item : itemList) {
            if (Objects.equals(item.getSanPham().getId(), sanPham.getId())) {
                item.setSoLuong(soLuong);
                item.updateTongGia();
                return;
            }
        }
    }

    public void clear() {
        itemList.clear();
        tongTien = BigDecimal.ZERO;
    }

    public BigDecimal calculateTotal() {
        tongTien = BigDecimal.ZERO;
        for (GioHangItem item : itemList) {
            if (item.isSelected()) {
                tongTien = tongTien.add(item.getTongGia());
            }
        }
        return tongTien;
    }

    public List<GioHangItem> getItems() {
        return itemList;
    }

    public BigDecimal getTongTien() {
        return calculateTotal();
    }
}
