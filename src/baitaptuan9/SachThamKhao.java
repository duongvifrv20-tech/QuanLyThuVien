package baitaptuan9;
import java.util.Scanner;

public class SachThamKhao extends Sach {
    public double thue;
    public SachThamKhao() {
        super();
    }
    public SachThamKhao(String maSach, int ngay, int thang, int nam, double donGia,
                        int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngay, thang, nam, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }
    
    @Override
    public void NhapThongTinSach(Scanner sc) {
        super.NhapThongTinSach(sc);
        System.out.print("Thuế : ");
        thue = sc.nextDouble();
    }

    @Override
    public double Thanhtien() {
        return soLuong * donGia + thue;
    }

    @Override
    public void InThongTinSach() {
        System.out.println("[Sách tham khảo]");
        super.InThongTinSach();
        System.out.println("Thuế : " + thue);
        System.out.println("Thành tiền : " + Thanhtien());
        System.out.println("---------------------------------");
    }
}