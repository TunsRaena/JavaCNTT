
import java.util.ArrayList;
import java.util.Scanner;

// Lop diem 2D
class Diem2D {
    protected double x, y;
    public Diem2D() {
        x = 0;
        y = 0;
    }
    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void nhap(Scanner sc) {
        System.out.print("Nhap x: ");
        x = sc.nextDouble();

        System.out.print("Nhap y: ");
        y = sc.nextDouble();
    }
    public double khoangCach(Diem2D p) {
        return Math.sqrt(
            Math.pow(x - p.x, 2) +
            Math.pow(y - p.y, 2)
        );
    }
    public Diem2D doiXung() {
        return new Diem2D(-x, -y);
    }
    public void tinhTien(double dx, double dy) {
        x += dx;
        y += dy;
    }
    public void xuat() {
        System.out.printf("(%.2f, %.2f)", x, y);
    }
}

// Lop diem 3D ke thua diem 2D
class Diem3D extends Diem2D {
    private double z;
    public Diem3D() {
        super();
        z = 0;
    }
    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Nhap z: ");
        z = sc.nextDouble();
    }
    public double khoangCach3D(Diem3D p) {
        return Math.sqrt(
            Math.pow(x - p.x, 2) +
            Math.pow(y - p.y, 2) +
            Math.pow(z - p.z, 2)
        );
    }
    @Override
    public Diem3D doiXung() {
        return new Diem3D(-x, -y, -z);
    }
    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy);
        z += dz;
    }
    @Override
    public void xuat() {
        System.out.printf("(%.2f, %.2f, %.2f)", x, y, z);
    }
}
public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Diem2D> ds2D = new ArrayList<>();
        ArrayList<Diem3D> ds3D = new ArrayList<>();
        System.out.print("Nhap so luong diem 2D: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap diem 2D thu " + (i + 1));
            Diem2D p = new Diem2D();
            p.nhap(sc);
            ds2D.add(p);
        }
        System.out.print("\nNhap so luong diem 3D: ");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println("\nNhap diem 3D thu " + (i + 1));
            Diem3D p = new Diem3D();
            p.nhap(sc);
            ds3D.add(p);
        }
        double tong2D = 0;
        for (int i = 0; i < ds2D.size() - 1; i++) {
            tong2D += ds2D.get(i).khoangCach(ds2D.get(i + 1));
        }
        double tong3D = 0;

        for (int i = 0; i < ds3D.size() - 1; i++) {
            tong3D += ds3D.get(i).khoangCach3D(ds3D.get(i + 1));
        }
        System.out.println("\n=== TONG KHOANG CACH ===");
        System.out.println("Tong khoang cach 2D: " + tong2D);
        System.out.println("Tong khoang cach 3D: " + tong3D);
        ArrayList<Diem2D> danhSach = new ArrayList<>();
        danhSach.addAll(ds2D);
        danhSach.addAll(ds3D);
        int soDiemBanDau = danhSach.size();
        for (int i = 0; i < soDiemBanDau; i++) {
            danhSach.add(danhSach.get(i).doiXung());
        }
        System.out.println("\n=== DANH SACH DIEM VA DIEM DOI XUNG ===");
        for (Diem2D p : danhSach) {
            p.xuat();
            System.out.println();
        }
        sc.close();
    }
}
