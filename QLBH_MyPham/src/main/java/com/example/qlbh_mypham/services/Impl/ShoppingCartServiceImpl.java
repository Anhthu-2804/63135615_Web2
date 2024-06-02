package com.example.qlbh_mypham.services.Impl;

import com.example.qlbh_mypham.models.GioHangItem;
import com.example.qlbh_mypham.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, GioHangItem> maps = new HashMap<>(); // gio hang
    @Override
    public void add(GioHangItem item) {
        GioHangItem gioHangItem = maps.get(item.getSanPham().getId());
        if (gioHangItem == null){
            maps.put(item.getSanPham().getId(), item);
        }
        else {
            gioHangItem.setSoLuong(gioHangItem.getSoLuong() + 1);
        }
    }

    @Override
    public void remove(int id) {
        maps.remove(id);
    }

    @Override
    public GioHangItem update(int sanPhamId, int soLuong) {
        GioHangItem gioHangItem = maps.get(sanPhamId);
        gioHangItem.setSoLuong(soLuong);
        return gioHangItem;
    }

    @Override
    public void clear() {
        maps.clear();
    }

    @Override
    public Collection<GioHangItem> getAllItems() {
        return maps.values();
    }

    @Override
    public int getCount() {
        return maps.values().size();
    }

    // Phương thức getAmount để tính tổng số tiền
    @Override
    public BigDecimal getAmount() {
        return maps.values().stream()
                .map(item -> item.getTongGia().multiply(BigDecimal.valueOf(item.getSoLuong())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
