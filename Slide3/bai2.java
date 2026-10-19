public class bai2 {
    public static void main(String[] args) {
        TamGiac tamGiac1 = new TamGiac(
            new Diem(0, 0), 
            new Diem(3, 0), 
            new Diem(0, 4)
        );
        TamGiac tamGiac2 = new TamGiac(
            new Diem(1, 1), 
            new Diem(4, 1), 
            new Diem(1, 5)
        );
        ChuNhat chuNhat1 = new ChuNhat(5, 3);
        ChuNhat chuNhat2 = new ChuNhat(4, 6);
        HinhTron hinhTron1 = new HinhTron(new Diem(0, 0), 3);
        HinhTron hinhTron2 = new HinhTron(new Diem(1, 1), 5);
        System.out.println("==== Tam giac ====");
        System.out.println("Chu vi tam giac 1: " + tamGiac1.tinhChuVi());
        System.out.println("Dien tich tam giac 1: " + tamGiac1.tinhDienTich());
        System.out.println("Chu vi tam giac 2: " + tamGiac2.tinhChuVi());
        System.out.println("Dien tich tam giac 2: " + tamGiac2.tinhDienTich());
        System.out.println("==== Chu nhat ====");
        System.out.println("Chu vi chu nhat 1: " + chuNhat1 .tinhChuVi());
        System.out.println("Dien tich chu nhat 1: " + chuNhat1.tinhDienTich());
        System.out.println("Chu vi chu nhat 2: " + chuNhat2.tinhChuVi());
        System.out.println("Dien tich chu nhat 2: " + chuNhat2.tinhDienTich());
        System.out.println("==== Hinh tron ====");
        System.out.println("Chu vi hinh tron 1: " + hinhTron1.tinhChuVi());
        System.out.println("Dien tich hinh tron 1: " + hinhTron1.tinhDienTich());
        System.out.println("Chu vi hinh tron 2: " + hinhTron2.tinhChuVi());
        System.out.println("Dien tich hinh tron 2: " + hinhTron2.tinhDienTich());

    }
}
class Diem {
    private double x;
    private double y;

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class TamGiac {
    private Diem diem1;
    private Diem diem2;
    private Diem diem3;

    public TamGiac(Diem diem1, Diem diem2, Diem diem3) {
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    private double khoangCach(Diem d1, Diem d2) {
        double dx = d2.getX() - d1.getX();
        double dy = d2.getY() - d1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double tinhChuVi() {
        double a = khoangCach(diem1, diem2);
        double b = khoangCach(diem2, diem3);
        double c = khoangCach(diem3, diem1);
        return a + b + c;
    }

    public double tinhDienTich() {
        double a = khoangCach(diem1, diem2);
        double b = khoangCach(diem2, diem3);
        double c = khoangCach(diem3, diem1);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
class ChuNhat {
    private double dai;
    private double rong;

    public ChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double tinhChuVi() {
        return 2 * (dai + rong);
    }

    public double tinhDienTich() {
        return dai * rong;
    }
}
class HinhTron {
    private Diem O;
    private double r;

    public HinhTron(Diem O, double r) {
        this.O = O;
        this.r = r;
    }

    public double tinhChuVi() {
        return 2 * Math.PI * r;
    }

    public double tinhDienTich() {
        return Math.PI * r * r;
    }

    public Diem getO() {
        return O;
    }
}

