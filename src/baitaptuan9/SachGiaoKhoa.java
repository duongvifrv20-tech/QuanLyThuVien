package baitaptuan9;
import java.util.Scanner;

public class SachGiaoKhoa extends Sach {
    public String tinhTrang;   
    public SachGiaoKhoa() {
        super();
    }

    public SachGiaoKhoa(String maSach, int ngay, int thang, int nam, double donGia,
                        int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngay, thang, nam, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public void NhapThongTinSach(Scanner sc) {
        super.NhapThongTinSach(sc);
        System.out.print("Tình trạng (Moi/Cu): ");
        tinhTrang = sc.next();
    }

    @Override
    public double Thanhtien() {
        if (tinhTrang.equalsIgnoreCase("Moi"))
            return soLuong * donGia;
        else
            return soLuong * donGia * 0.5;
    }

    @Override
    public void InThongTinSach() {
        System.out.println("[Sách giáo khoa]");
        super.InThongTinSach();
        System.out.println("Tình trạng: " + tinhTrang);
        System.out.println("Thành tiền : " + Thanhtien());
        System.out.println("---------------------------------");
    }
}