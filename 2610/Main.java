
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<PhanSo> ds = new ArrayList<>();
        System.out.print("Nhap so luong phan so: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Phan so thu " + (i + 1) + ":");
            System.out.print("Nhap tu so: ");
            int tu = sc.nextInt();
            int mau;
            do {
                System.out.print("Nhap mau so (khac 0): ");
                mau = sc.nextInt();

                if (mau == 0) {
                    System.out.println("Mau so phai khac 0!");
                }
            } while (mau == 0);
            ds.add(new PhanSo(tu, mau));
        }
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong!");
            sc.close();
            return;
        }
        System.out.println("\nDanh sach phan so:");
        for (PhanSo p : ds) {
            System.out.print(p + " ");
        }
        System.out.println();
        PhanSo max = ds.get(0);

        for (int i = 1; i < ds.size(); i++) {
            if (ds.get(i).soSanh(max) > 0) {
                max = ds.get(i);
            }
        }

        System.out.println("Phan so lon nhat: " + max);
        PhanSo tong = new PhanSo(0, 1);

        for (PhanSo p : ds) {
            tong = tong.cong(p);
        }

        System.out.println("Tong cac phan so: " + tong);
        int dem = 0;

        for (PhanSo p : ds) {
            if (!p.laSoNguyen()) {
                dem++;
            }
        }
        System.out.println(
            "So phan so khong phai so nguyen: " + dem
        );
        sc.close();
    }
}
