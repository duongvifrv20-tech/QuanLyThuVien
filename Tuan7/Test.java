package btapthuchanhtuan7;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Sach s1 = new Sach("S001", "Toán", "Nguyễn Văn An", 2022, 10);
        Sach s2 = new Sach("S002", "Lý", "Trần Thị Huệ", 2021, 8);
        Sach s3 = new Sach("S003", "Hóa", "Lê Văn Cường", 2020, 5);

        System.out.println("=== Thông tin 3 cuốn sách ===");
        s1.InThongTinSach();
        s2.InThongTinSach();
        s3.InThongTinSach();

        // Yêu cầu 4: tạo và quản lý danh sách bằng ArrayList
        ArrayList<Sach> danhSach = new ArrayList<>();
        danhSach.add(s1);
        danhSach.add(s2);
        danhSach.add(s3);

        System.out.println("=== Danh sách " + danhSach.size() + " cuốn sách ===");
        for (Sach s : danhSach) {
            s.InThongTinSach();
        }

        // Xóa một cuốn sách khỏi danh sách
        danhSach.remove(s3);
        System.out.println("=== Sau khi xóa sách Hóa còn " + danhSach.size() + " cuốn ===");
        for (Sach s : danhSach) {
            s.InThongTinSach();
        }
    }
}