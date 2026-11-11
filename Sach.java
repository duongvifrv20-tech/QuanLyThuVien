/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baithuchanhtuan7;
import java.time.Year;
public class Sach {
    // Yêu cầu 1: tất cả thuộc tính khai báo private
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
 
    // Constructor không tham số
    public Sach() {
    }
 
    // Yêu cầu 4: constructor đầy đủ tham số (dùng setter để kiểm tra dữ liệu)
    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        setNamXuatBan(namXuatBan);
        setSoLuong(soLuong);
    }
 
    // Yêu cầu 2: getters
    public String getMaSach() {
        return maSach;
    }
 
    public String getTieuDe() {
        return tieuDe;
    }
 
    public String getTacGia() {
        return tacGia;
    }
 
    public int getNamXuatBan() {
        return namXuatBan;
    }
 
    public int getSoLuong() {
        return soLuong;
    }
 
    // Yêu cầu 2: setters
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
 
    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
 
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
 
    // Yêu cầu 3: năm xuất bản phải > 0 và không lớn hơn năm hiện tại
    public void setNamXuatBan(int namXuatBan) {
        int namHienTai = Year.now().getValue();
        if (namXuatBan > 0 && namXuatBan <= namHienTai) {
            this.namXuatBan = namXuatBan;
        } else {
            System.out.println("Năm xuất bản không hợp lệ (phải từ 1 đến " + namHienTai + ")!");
        }
    }
 
    // Yêu cầu 3: số lượng không âm
    public void setSoLuong(int soLuong) {
        if (soLuong >= 0) {
            this.soLuong = soLuong;
        } else {
            System.out.println("Số lượng không hợp lệ (không được âm)!");
        }
    }
 
    public void hienThiThongTin() {
        System.out.println("Mã sách : " + maSach);
        System.out.println("Tiêu đề : " + tieuDe);
        System.out.println("Tác giả : " + tacGia);
        System.out.println("Năm xuất bản: " + namXuatBan);
        System.out.println("Số lượng : " + soLuong);
        System.out.println("---------------------------------");
    }
}