package baitaptuan9;
import java.util.ArrayList;
import java.util.Scanner;

public class Sach {
    public String maSach;
    public int ngay;
    public int thang;
    public int nam;
    public double donGia;
    public int soLuong;
    public String nhaXuatBan;

    public Sach() {
    }

    public Sach(String maSach, int ngay, int thang, int nam, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }
    public double getDonGia() {
        return donGia;
    }

    public void NhapThongTinSach(Scanner sc) {
        System.out.print("Mã sách: ");
        maSach = sc.next();
        System.out.print("Ngày nhập: ");
        ngay = sc.nextInt();
        System.out.print("Tháng nhập: ");
        thang = sc.nextInt();
        System.out.print("Năm nhập: ");
        nam = sc.nextInt();
        System.out.print("Đơn giá: ");
        donGia = sc.nextDouble();
        System.out.print("Số lượng: ");
        soLuong = sc.nextInt();
        System.out.print("Nhà xuất bản: ");
        nhaXuatBan = sc.next();
    }

    public double Thanhtien() {
        return soLuong * donGia;
    }

    public void InThongTinSach() {
        System.out.println("Mã sách : " + maSach);
        System.out.println("Ngày nhập : " + ngay + "/" + thang + "/" + nam);
        System.out.println("Đơn giá : " + donGia);
        System.out.println("Số lượng : " + soLuong);
        System.out.println("Nhà xuất bản : " + nhaXuatBan);
    }

    // Yêu cầu 1: nhập danh sách các loại sách
    static void nhapDanhSach(ArrayList<Sach> ds, Scanner sc) {
        System.out.print("Nhập số lượng sách: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("--- Sách thứ " + i + " ---");
            System.out.print("Loại sách (1. Giáo khoa, 2. Tham khảo): ");
            int loai = sc.nextInt();
            Sach s;
            if (loai == 1) {
                s = new SachGiaoKhoa();
            } else if (loai == 2) {
                s = new SachThamKhao();
            } else {
                System.out.println("Loại sách không hợp lệ, nhập lại!");
                i--;
                continue;
            }
            s.NhapThongTinSach(sc);
            ds.add(s);
        }
    }

    // Yêu cầu 2: xuất danh sách các loại sách
    static void xuatDanhSach(ArrayList<Sach> ds) {
        System.out.println("=== Danh sách " + ds.size() + " cuốn sách ===");
        for (Sach s : ds) {
            s.InThongTinSach();
        }
    }

    // Yêu cầu 3: tính tổng thành tiền cho từng loại
    static void tongThanhTien(ArrayList<Sach> ds) {
        double tongGK = 0, tongTK = 0;
        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa) tongGK += s.Thanhtien();
            else if (s instanceof SachThamKhao) tongTK += s.Thanhtien();
        }
        System.out.println("Tổng thành tiền sách giáo khoa : " + tongGK);
        System.out.println("Tổng thành tiền sách tham khảo : " + tongTK);
    }

    // Yêu cầu 4: trung bình cộng đơn giá của các sách tham khảo
    static void trungBinhDonGiaTK(ArrayList<Sach> ds) {
        double tong = 0;
        int dem = 0;
        for (Sach s : ds) {
            if (s instanceof SachThamKhao) {
                tong += s.getDonGia();
                dem++;
            }
        }
        if (dem == 0) System.out.println("Không có sách tham khảo nào.");
        else System.out.println("Trung bình cộng đơn giá sách tham khảo: " + tong / dem);
    }

    // Yêu cầu 5: xuất các sách giáo khoa của nhà xuất bản X
    static void xuatSGKTheoNXB(ArrayList<Sach> ds, String x) {
        System.out.println("=== Sách giáo khoa của nhà xuất bản " + x + " ===");
        int dem = 0;
        for (Sach s : ds) {
            if (s instanceof SachGiaoKhoa && s.getNhaXuatBan().equalsIgnoreCase(x)) {
                s.InThongTinSach();
                dem++;
            }
        }
        if (dem == 0) System.out.println("Không có sách giáo khoa nào của nhà xuất bản này.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Sach> danhSach = new ArrayList<>();

        nhapDanhSach(danhSach, sc);
        xuatDanhSach(danhSach);
        tongThanhTien(danhSach);
        trungBinhDonGiaTK(danhSach);

        System.out.print("Nhập nhà xuất bản X: ");
        xuatSGKTheoNXB(danhSach, sc.next());
    }
}