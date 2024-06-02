package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.GioHangItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public interface ShoppingCartService {
    void add(GioHangItem item);
    void remove(int id);
    GioHangItem update(int sanPhamId, int soLuong);
    void clear();
    Collection<GioHangItem> getAllItems();
    int getCount();
    BigDecimal getAmount();
}
