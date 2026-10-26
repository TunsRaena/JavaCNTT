
public class Diem2D {
    protected double x;
    protected double y;
    public Diem2D() {
        this.x = 0;
        this.y = 0;
    }
    public Diem2D(double x, double y) {
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
    public double khoangCach(Diem2D p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;

        return Math.sqrt(dx * dx + dy * dy);
    }
    public Diem2D doiXung() {
        return new Diem2D(-x, -y);
    }
    public void tinhTien(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
    @Override
    public String toString() {
        return String.format("Diem 2D(%.2f, %.2f)", x, y);
    }
}
