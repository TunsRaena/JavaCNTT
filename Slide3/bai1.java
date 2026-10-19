public class bai1 {
    public static void main(String[] args) {
        Diem diem1 = new Diem(1, 2);
        Diem diem2 = new Diem(4, 6);
        DuongThang duongThang = new DuongThang(diem1, diem2);

        System.out.println("Do dai duong thang: " + duongThang.tinhDoDai());
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class DuongThang {
    private Diem diem1;
    private Diem diem2;

    public DuongThang(Diem diem1, Diem diem2) {
        this.diem1 = diem1;
        this.diem2 = diem2;
    }

    public Diem getDiem1() {
        return diem1;
    }

    public Diem getDiem2() {
        return diem2;
    }

    public double tinhDoDai() {
        double dx = diem2.getX() - diem1.getX();
        double dy = diem2.getY() - diem1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

