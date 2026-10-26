
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Diem2D> ds = new ArrayList<>();
        ds.add(new Diem2D(1, 2));
        ds.add(new Diem2D(4, 6));
        ds.add(new Diem2D(2, 3));

        ds.add(new Diem3D(1, 2, 3));
        ds.add(new Diem3D(4, 6, 3));
        ds.add(new Diem3D(2, 3, 5));

        System.out.println("=== DANH SACH DIEM BAN DAU ===");
        for (Diem2D p : ds) {
            System.out.println(p);
        }
        ArrayList<Diem2D> ds2D = new ArrayList<>();
        ArrayList<Diem3D> ds3D = new ArrayList<>();
        for (Diem2D p : ds) {
            if (p instanceof Diem3D) {
                ds3D.add((Diem3D) p);
            } else {
                ds2D.add(p);
            }
        }
        double tong2D = 0;
        for (int i = 0; i < ds2D.size() - 1; i++) {
            tong2D += ds2D.get(i).khoangCach(ds2D.get(i + 1));
        }
        System.out.printf(
            "%nTong khoang cach cac diem 2D: %.2f%n", tong2D
        );
        double tong3D = 0;
        for (int i = 0; i < ds3D.size() - 1; i++) {
            tong3D += ds3D.get(i).khoangCach(ds3D.get(i + 1));
        }
        System.out.printf(
            "Tong khoang cach cac diem 3D: %.2f%n", tong3D
        );
        int soLuongBanDau = ds.size();
        for (int i = 0; i < soLuongBanDau; i++) {
            Diem2D p = ds.get(i);
            ds.add(p.doiXung());
        }
        System.out.println("\n=== DANH SACH SAU KHI THEM DIEM DOI XUNG ===");

        for (Diem2D p : ds) {
            System.out.println(p);
        }
    }
}
