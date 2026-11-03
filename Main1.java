
import java.util.Scanner;
public class Main1 {
    static Scanner sc = new Scanner(System.in);
 
    // Dữ liệu sách (tối đa 100 cuốn)
    static String[] maSach = new String[100];
    static String[] tenSach = new String[100];
    static String[] tacGia = new String[100];
    static int[] namXB = new int[100];
    static double[] donGia = new double[100];
    static int[] soLuong = new int[100];
    static int n = 0; // số sách hiện có
 
    public static void main(String[] args) {
        int chon;
        // Bài 3: menu lặp đến khi chọn Thoát
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhap n sach");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tong so luong va tong gia tri");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            chon = Integer.parseInt(sc.nextLine());
 
            switch (chon) {
                case 1: nhapSach(); break;
                case 2: hienThi(); break;
                case 3: tinhTong(); break;
                case 4: timTheoMa(); break;
                case 0: System.out.println("Tạm biệt!"); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
 
    // Bài 1: nhập n sách bằng vòng lặp
    static void nhapSach() {
        System.out.print("Nhap so luong sach n: ");
        int soCuon = Integer.parseInt(sc.nextLine());
        n = 0;
        for (int i = 0; i < soCuon; i++) {
            System.out.println("--- Sach thu " + (i + 1) + " ---");
            System.out.print("Ma sach: ");
            maSach[i] = sc.nextLine();
            System.out.print("Ten sach: ");
            tenSach[i] = sc.nextLine();
            System.out.print("Tac gia: ");
            tacGia[i] = sc.nextLine();
            System.out.print("Nam xuat ban: ");
            namXB[i] = Integer.parseInt(sc.nextLine());
            System.out.print("Don gia: ");
            donGia[i] = Double.parseDouble(sc.nextLine());
            System.out.print("So luong: ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
            n++;
        }
    }
 
    static void hienThi() {
        if (n == 0) {
            System.out.println("Chua co sach nao!");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + maSach[i] + " | " + tenSach[i] + " | "
                    + tacGia[i] + " | " + namXB[i] + " | " + donGia[i] + " | " + soLuong[i]);
        }
    }
 
    // Bài 2: tổng số lượng và tổng giá trị
    static void tinhTong() {
        int tongSL = 0;
        double tongTien = 0;
        int i = 0;
        while (i < n) {
            tongSL += soLuong[i];
            tongTien += donGia[i] * soLuong[i];
            i++;
        }
        System.out.println("Tong so luong: " + tongSL);
        System.out.println("Tong gia tri: " + tongTien);
    }
 
    // Bài 4: tìm sách theo mã
    static void timTheoMa() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();
        boolean timThay = false;
        for (int i = 0; i < n; i++) {
            if (maSach[i].equalsIgnoreCase(ma)) {
                System.out.println("Tim thay: " + tenSach[i] + " | " + tacGia[i] + " | "
                        + namXB[i] + " | " + donGia[i] + " | " + soLuong[i]);
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach co ma " + ma);
        }
    }
}