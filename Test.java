/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baithuchanhtuan7;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        Sach s1 = new Sach("S01", "Toán học", "Nguyễn Văn An", 2020, 10);
        Sach s2 = new Sach("S02", "Vật lý", "Trần Thị Huệ", 2019, 5);
        Sach s3 = new Sach("S03", "Hóa học", "Lê Văn Cường", 2022, 8);
 
        ArrayList<Sach> danhSach = new ArrayList<>(Arrays.asList(s1, s2, s3));
 
        int chon;
        do {
            System.out.println("\n===== QUẢN LÝ SÁCH =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("4. Xóa sách theo mã");
            System.out.println("5. Tính tổng số lượng");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = Integer.parseInt(sc.nextLine().trim());
 
            switch (chon) {
                case 1:
                    Sach s = new Sach();
                    System.out.print("Mã sách: ");
                    s.maSach = sc.nextLine().trim();
                    System.out.print("Tiêu đề: ");
                    s.tieuDe = sc.nextLine();
                    System.out.print("Tác giả: ");
                    s.tacGia = sc.nextLine();
                    System.out.print("Năm xuất bản: ");
                    s.namXuatBan = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Số lượng: ");
                    s.soLuong = Integer.parseInt(sc.nextLine().trim());
                    danhSach.add(s);
                    System.out.println("Đã thêm sách.");
                    break;
 
                case 2:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách trống.");
                    }
                    for (Sach x : danhSach) {
                        x.hienThiThongTin();
                    }
                    break;
 
                case 3:
                    System.out.print("Nhập mã cần tìm: ");
                    String maTim = sc.nextLine().trim();
                    boolean thay = false;
                    for (Sach x : danhSach) {
                        if (x.maSach.equalsIgnoreCase(maTim)) {
                            x.hienThiThongTin();
                            thay = true;
                        }
                    }
                    if (!thay) {
                        System.out.println("Không tìm thấy sách.");
                    }
                    break;
 
                case 4:
                    System.out.print("Nhập mã cần xóa: ");
                    String maXoa = sc.nextLine().trim();
                    boolean daXoa = false;
                    for (int i = 0; i < danhSach.size(); i++) {
                        if (danhSach.get(i).maSach.equalsIgnoreCase(maXoa)) {
                            danhSach.remove(i);
                            daXoa = true;
                            break;
                        }
                    }
                    System.out.println(daXoa ? "Đã xóa." : "Không tìm thấy sách.");
                    break;
 
                case 5:
                    int tong = 0;
                    for (Sach x : danhSach) {
                        tong += x.soLuong;
                    }
                    System.out.println("Số đầu sách: " + danhSach.size());
                    System.out.println("Tổng số lượng: " + tong);
                    break;
 
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
 
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
 
        sc.close();
    }
}