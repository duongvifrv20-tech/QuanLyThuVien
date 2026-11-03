import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    static Scanner sc = new Scanner(System.in);

    // Bài 3: mỗi phần tử là 1 chuỗi thông tin sách, các trường ngăn cách bằng "|"
    // Định dạng: maSach|tenSach|tacGia|namXB|donGia|soLuong
    static ArrayList<String> danhSachSach = new ArrayList<>();

    // Bài 2: danh sách mã sách
    static ArrayList<String> dsMaSach = new ArrayList<>();

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.println("9. (Bai 1) Mang soLuong 5 cuon");
            System.out.println("10. (Bai 2) ArrayList ma sach");
            System.out.print("Chon: ");
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1: themSach(); break;
                case 2: hienThiSach(); break;
                case 3: timSach(); break;
                case 4: xoaSach(); break;
                case 5: suaSach(); break;
                case 6: tongSoLuong(); break;
                case 7: tongGiaTri(); break;
                case 8: System.out.println("Tam biet!"); break;
                case 9: bai1(); break;
                case 10: bai2(); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 8);
    }

    // ================= Bài 1: mảng int[] =================
    static void bai1() {
        int[] soLuong = new int[5];
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print("Nhap so luong cuon sach thu " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine().trim());
        }
        System.out.println("So luong cac cuon sach:");
        int tong = 0;
        int max = soLuong[0];
        for (int i = 0; i < soLuong.length; i++) {
            System.out.println("  Cuon " + (i + 1) + ": " + soLuong[i]);
            tong += soLuong[i];
            if (soLuong[i] > max) max = soLuong[i];
        }
        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + max);
    }

    // ================= Bài 2: ArrayList<String> mã sách =================
    static void bai2() {
        int chon;
        do {
            System.out.println("\n--- Quan ly ma sach ---");
            System.out.println("1. Them  2. Hien thi  3. Tim  4. Xoa  0. Quay lai");
            System.out.print("Chon: ");
            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                chon = -1;
            }
            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    dsMaSach.add(sc.nextLine().trim());
                    System.out.println("Da them.");
                    break;
                case 2:
                    if (dsMaSach.isEmpty()) System.out.println("Danh sach rong!");
                    for (int i = 0; i < dsMaSach.size(); i++)
                        System.out.println((i + 1) + ". " + dsMaSach.get(i));
                    break;
                case 3:
                    System.out.print("Nhap ma can tim: ");
                    String ma = sc.nextLine().trim();
                    int vt = -1;
                    for (int i = 0; i < dsMaSach.size(); i++) {
                        if (dsMaSach.get(i).equalsIgnoreCase(ma)) { vt = i; break; }
                    }
                    System.out.println(vt >= 0 ? "Tim thay o vi tri " + (vt + 1)
                                               : "Khong tim thay " + ma);
                    break;
                case 4:
                    System.out.print("Nhap ma can xoa: ");
                    String maXoa = sc.nextLine().trim();
                    int viTri = -1;
                    for (int i = 0; i < dsMaSach.size(); i++) {
                        if (dsMaSach.get(i).equalsIgnoreCase(maXoa)) { viTri = i; break; }
                    }
                    if (viTri >= 0) {
                        dsMaSach.remove(viTri);
                        System.out.println("Da xoa.");
                    } else {
                        System.out.println("Khong tim thay " + maXoa);
                    }
                    break;
                case 0: break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    // ================= Bài 3 + 4: ArrayList<String> danhSachSach =================
    // Tìm vị trí sách theo mã, -1 nếu không có
    static int timViTri(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] f = danhSachSach.get(i).split("\\|");
            if (f[0].equalsIgnoreCase(ma)) return i;
        }
        return -1;
    }

    static String nhapThongTin(String maCoSan) {
        String ma = maCoSan;
        if (ma == null) {
            System.out.print("Ma sach: ");
            ma = sc.nextLine().trim();
        }
        System.out.print("Ten sach: ");
        String ten = sc.nextLine().trim();
        System.out.print("Tac gia: ");
        String tg = sc.nextLine().trim();
        System.out.print("Nam xuat ban: ");
        int nam = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Don gia: ");
        double gia = Double.parseDouble(sc.nextLine().trim());
        System.out.print("So luong: ");
        int sl = Integer.parseInt(sc.nextLine().trim());
        return ma + "|" + ten + "|" + tg + "|" + nam + "|" + gia + "|" + sl;
    }

    static void inSach(int stt, String s) {
        String[] f = s.split("\\|");
        System.out.println(stt + ". " + f[0] + " | " + f[1] + " | " + f[2] + " | "
                + f[3] + " | " + f[4] + " | " + f[5]);
    }

    static void themSach() {
        try {
            System.out.print("Ma sach: ");
            String ma = sc.nextLine().trim();
            if (timViTri(ma) >= 0) {
                System.out.println("Ma sach da ton tai!");
                return;
            }
            danhSachSach.add(nhapThongTin(ma));
            System.out.println("Da them sach.");
        } catch (NumberFormatException e) {
            System.out.println("Du lieu nhap khong hop le, huy them sach!");
        }
    }

    static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Chua co sach nao!");
            return;
        }
        for (int i = 0; i < danhSachSach.size(); i++) inSach(i + 1, danhSachSach.get(i));
    }

    static void timSach() {
        System.out.print("Nhap ma sach can tim: ");
        int vt = timViTri(sc.nextLine().trim());
        if (vt >= 0) inSach(vt + 1, danhSachSach.get(vt));
        else System.out.println("Khong tim thay sach!");
    }

    static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        int vt = timViTri(sc.nextLine().trim());
        if (vt >= 0) {
            danhSachSach.remove(vt);
            System.out.println("Da xoa sach.");
        } else {
            System.out.println("Khong tim thay sach!");
        }
    }

    static void suaSach() {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine().trim();
        int vt = timViTri(ma);
        if (vt < 0) {
            System.out.println("Khong tim thay sach!");
            return;
        }
        try {
            System.out.println("Nhap thong tin moi (giu nguyen ma sach):");
            String ma0 = danhSachSach.get(vt).split("\\|")[0];
            danhSachSach.set(vt, nhapThongTin(ma0));
            System.out.println("Da sua sach.");
        } catch (NumberFormatException e) {
            System.out.println("Du lieu nhap khong hop le, huy sua!");
        }
    }

    static void tongSoLuong() {
        int tong = 0;
        for (String s : danhSachSach) tong += Integer.parseInt(s.split("\\|")[5]);
        System.out.println("Tong so luong: " + tong);
    }

    static void tongGiaTri() {
        double tong = 0;
        for (String s : danhSachSach) {
            String[] f = s.split("\\|");
            tong += Double.parseDouble(f[4]) * Integer.parseInt(f[5]);
        }
        System.out.println("Tong gia tri: " + tong);
    }
}
