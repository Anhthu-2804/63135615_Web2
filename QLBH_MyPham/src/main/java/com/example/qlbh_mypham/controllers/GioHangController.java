package com.example.qlbh_mypham.controllers;

import com.example.qlbh_mypham.models.SanPham;
import com.example.qlbh_mypham.repositories.SanPhamRepository;
import com.example.qlbh_mypham.services.GioHangService;
import com.example.qlbh_mypham.services.SanPhamService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/giohang")
public class GioHangController {
    @Autowired
    GioHangService gioHangService;
    SanPhamService sanPhamService;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @PostMapping("/add")
    public String addToCart(@RequestParam("id") int productId, @RequestParam("soLuong") int quantity, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        SanPham sanPham = sanPhamRepository.findById(productId).orElse(null);
        if (sanPham != null) {
            gioHangService.addSanPham(sanPham, quantity);
        }
        return "redirect:/giohang/view";
    }

//    @PostMapping("/add")
//    public String addItem(@RequestParam("id") int id, @RequestParam("soLuong") int soLuong ,Model model){
//        SanPham sanPham = sanPhamService.getSanPhamById(id);
//        if (sanPham != null){
//            gioHangService.addSanPham(sanPham,soLuong);
//        }
//        model.addAttribute("gioHang", gioHangService.getGioHang());
//        return "redirect:/giohang/view";
//    }

    @GetMapping("/view")
    public String viewCart(Model model) {
        model.addAttribute("gioHang", gioHangService.getGioHang());
        return "Cart/view";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam("id") int productId) {
        gioHangService.removeSanPham(productId);
        return "redirect:/giohang/view";
    }

    @PostMapping("/update")
    public String updateCart(@RequestParam("productIds") List<Integer> productIds, @RequestParam("soLuong") List<Integer> soLuong, @RequestParam("dsSelectedItems") List<Integer> dsSelectedItems) {
        gioHangService.updateSanPham(productIds, soLuong, dsSelectedItems);
        return "redirect:/giohang/view";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam("paymentMethod") String paymentMethod, Model model) {
        // Xử lý logic thanh toán tại đây (ví dụ: VNPay hoặc thanh toán tại nhà)
        gioHangService.clearGioHang();
        return "redirect:/order-confirmation"; // Chuyển đến trang xác nhận đơn hàng
    }


}
