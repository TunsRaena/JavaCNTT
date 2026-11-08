
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Nguoi {
    protected String hoTen;
    protected int tuoi;
    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
    }
    public void xuat() {
        System.out.printf("%-20s %-10d", hoTen, tuoi);
    }
}

class NhanVien extends Nguoi {
    private int snct;
    private double hsl;
    static final double LCB = 1500000;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Nhap so nam cong tac: ");
        snct = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap he so luong: ");
        hsl = Double.parseDouble(sc.nextLine());
    }
    public double tinhLuong() {
        double phuCap = 200000 * snct;
        return LCB * hsl + phuCap;
    }
    @Override
    public void xuat() {
        super.xuat();

        System.out.printf(
            "%-15d %-15.2f %,15.0f VND%n",
            snct, hsl, tinhLuong()
        );
    }
    public int getSnct() {
        return snct;
    }
}

public class bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        int n = Integer.parseInt(sc.nextLine());
        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhan vien thu " + (i + 1));

            ds[i] = new NhanVien();
            ds[i].nhap(sc);
        }

        NhanVien max = ds[0];
        for (int i = 1; i < n; i++) {
            if (ds[i].getSnct() > max.getSnct()) {
                max = ds[i];
            }
        }
        System.out.println("\n=== NHAN VIEN CO THAM NIEN CAO NHAT ===");
        System.out.printf(
            "%-20s %-10s %-15s %-15s %s%n",
            "Ho ten", "Tuoi", "Nam cong tac",
            "He so luong", "Luong"
        );
        max.xuat();
        Arrays.sort(ds, Comparator.comparingDouble(
            NhanVien::tinhLuong
        ).reversed());
        System.out.println("\n=== DANH SACH NHAN VIEN THEO LUONG GIAM DAN ===");
        System.out.printf(
            "%-20s %-10s %-15s %-15s %s%n",
            "Ho ten", "Tuoi", "Nam cong tac",
            "He so luong", "Luong"
        );
        for (NhanVien nv : ds) {
            nv.xuat();
        }
        sc.close();
    }
}
