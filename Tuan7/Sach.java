package btapthuchanhtuan7;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class Sach {
    public String maSach;
    public String tieuDe;
    public String tacGia;
    public int namXuatBan;
    public int soLuong;

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
    }

public void InThongTinSach(){
    System.out.println("Mã sách : " + maSach);
    System.out.println("Tiêu đề : " + tieuDe);
    System.out.println("Tác giả  : " + tacGia);
    System.out.println("Năm xuất bản: " + namXuatBan);
    System.out.println("Số lượng    : " + soLuong);
    System.out.println("---------------------------------");
  }
}

