
public class Diem3D extends Diem2D {
    private double z;
    public Diem3D() {
        super();
        this.z = 0;
    }
    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    public double khoangCach(Diem3D p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;
        double dz = this.z - p.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    @Override
    public Diem3D doiXung() {
        return new Diem3D(-x, -y, -z);
    }
    public void tinhTien(double dx, double dy, double dz) {
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }
    @Override
    public String toString() {
        return String.format(
            "Diem 3D(%.2f, %.2f, %.2f)", x, y, z
        );
    }
}
