
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// =============================================
// 1. KHAI BÁO INTERFACE SHAPE
// =============================================
interface Shape {

    // Nhóm phương thức tính toán
    double area();                  // Tính diện tích
    double perimeter();             // Tính chu vi
    double distance(Shape other);   // Tính khoảng cách hai hình

    // Nhóm phương thức biến đổi
    void move(double dx, double dy); // Tịnh tiến
    void rotate(double angle);       // Xoay
    void zoom(double ratio);         // Phóng to, thu nhỏ

    // Lấy tọa độ tâm hình
    double getCenterX();
    double getCenterY();
}

// =============================================
// 2. LỚP TRỪU TƯỢNG BASESHAPE
// =============================================
abstract class BaseShape implements Shape {

    // Tính khoảng cách giữa tâm của hai hình
    @Override
    public double distance(Shape other) {
        double dx = getCenterX() - other.getCenterX();
        double dy = getCenterY() - other.getCenterY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    // Xoay một điểm quanh gốc tọa độ O
    protected double[] rotatePoint(double x, double y, double angle) {
        double radian = Math.toRadians(angle);

        double xMoi = x * Math.cos(radian) - y * Math.sin(radian);
        double yMoi = x * Math.sin(radian) + y * Math.cos(radian);

        return new double[]{xMoi, yMoi};
    }

    // Tính khoảng cách giữa hai điểm
    protected double pointDistance(
            double x1, double y1,
            double x2, double y2) {

        double dx = x2 - x1;
        double dy = y2 - y1;

        return Math.sqrt(dx * dx + dy * dy);
    }
}

// =============================================
// 3. LỚP POINT - ĐIỂM
// =============================================
class Point extends BaseShape {

    private double x;
    private double y;

    // Hàm khởi tạo
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter và Setter
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getCenterX() {
        return x;
    }

    @Override
    public double getCenterY() {
        return y;
    }

    // Điểm không có diện tích và chu vi
    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    // Tịnh tiến điểm
    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // Xoay điểm quanh gốc tọa độ
    @Override
    public void rotate(double angle) {
        double[] p = rotatePoint(x, y, angle);
        x = p[0];
        y = p[1];
    }

    // Phóng to hoặc thu nhỏ tọa độ
    @Override
    public void zoom(double ratio) {
        if (ratio > 0) {
            x *= ratio;
            y *= ratio;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Diem: (%.2f, %.2f)", x, y
        );
    }
}

// =============================================
// 4. LỚP CIRCLE - HÌNH TRÒN
// =============================================
class Circle extends BaseShape {

    private double x;
    private double y;
    private double banKinh;

    // Hàm khởi tạo
    public Circle(double x, double y, double banKinh) {
        this.x = x;
        this.y = y;
        this.banKinh = Math.abs(banKinh);
    }

    // Getter và Setter
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        if (banKinh > 0) {
            this.banKinh = banKinh;
        }
    }

    @Override
    public double getCenterX() {
        return x;
    }

    @Override
    public double getCenterY() {
        return y;
    }

    // Tính diện tích hình tròn
    @Override
    public double area() {
        return Math.PI * banKinh * banKinh;
    }

    // Tính chu vi hình tròn
    @Override
    public double perimeter() {
        return 2 * Math.PI * banKinh;
    }

    // Tịnh tiến hình tròn
    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // Xoay tâm hình tròn
    @Override
    public void rotate(double angle) {
        double[] p = rotatePoint(x, y, angle);
        x = p[0];
        y = p[1];
    }

    // Phóng to hoặc thu nhỏ hình tròn
    @Override
    public void zoom(double ratio) {
        if (ratio > 0) {
            x *= ratio;
            y *= ratio;
            banKinh *= ratio;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Hinh tron: Tam(%.2f, %.2f), Ban kinh=%.2f",
            x, y, banKinh
        );
    }
}

// =============================================
// 5. LỚP LINE - ĐOẠN THẲNG
// =============================================
class Line extends BaseShape {

    private double x1, y1;
    private double x2, y2;

    // Hàm khởi tạo
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Getter và Setter
    public double getX1() { return x1; }
    public void setX1(double x1) { this.x1 = x1; }

    public double getY1() { return y1; }
    public void setY1(double y1) { this.y1 = y1; }

    public double getX2() { return x2; }
    public void setX2(double x2) { this.x2 = x2; }

    public double getY2() { return y2; }
    public void setY2(double y2) { this.y2 = y2; }

    // Lấy tọa độ trung điểm đoạn thẳng
    @Override
    public double getCenterX() {
        return (x1 + x2) / 2;
    }

    @Override
    public double getCenterY() {
        return (y1 + y2) / 2;
    }

    // Tính độ dài đoạn thẳng
    public double getLength() {
        return pointDistance(x1, y1, x2, y2);
    }

    @Override
    public double area() {
        return 0;
    }

    // Chu vi đoạn thẳng quy ước bằng độ dài đoạn thẳng
    @Override
    public double perimeter() {
        return getLength();
    }

    // Tịnh tiến đoạn thẳng
    @Override
    public void move(double dx, double dy) {
        x1 += dx;
        y1 += dy;

        x2 += dx;
        y2 += dy;
    }

    // Xoay đoạn thẳng
    @Override
    public void rotate(double angle) {
        double[] p1 = rotatePoint(x1, y1, angle);
        double[] p2 = rotatePoint(x2, y2, angle);

        x1 = p1[0];
        y1 = p1[1];

        x2 = p2[0];
        y2 = p2[1];
    }

    // Phóng to hoặc thu nhỏ đoạn thẳng
    @Override
    public void zoom(double ratio) {
        if (ratio > 0) {
            x1 *= ratio;
            y1 *= ratio;

            x2 *= ratio;
            y2 *= ratio;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Doan thang: A(%.2f, %.2f), B(%.2f, %.2f), Do dai=%.2f",
            x1, y1, x2, y2, getLength()
        );
    }
}

// =============================================
// 6. LỚP TRIANGLE - TAM GIÁC
// =============================================
class Triangle extends BaseShape {

    private double x1, y1;
    private double x2, y2;
    private double x3, y3;

    // Hàm khởi tạo
    public Triangle(
            double x1, double y1,
            double x2, double y2,
            double x3, double y3) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    // Getter và Setter
    public double getX1() { return x1; }
    public void setX1(double x1) { this.x1 = x1; }

    public double getY1() { return y1; }
    public void setY1(double y1) { this.y1 = y1; }

    public double getX2() { return x2; }
    public void setX2(double x2) { this.x2 = x2; }

    public double getY2() { return y2; }
    public void setY2(double y2) { this.y2 = y2; }

    public double getX3() { return x3; }
    public void setX3(double x3) { this.x3 = x3; }

    public double getY3() { return y3; }
    public void setY3(double y3) { this.y3 = y3; }

    // Tính độ dài ba cạnh
    private double canhA() {
        return pointDistance(x1, y1, x2, y2);
    }

    private double canhB() {
        return pointDistance(x2, y2, x3, y3);
    }

    private double canhC() {
        return pointDistance(x3, y3, x1, y1);
    }

    // Tọa độ trọng tâm tam giác
    @Override
    public double getCenterX() {
        return (x1 + x2 + x3) / 3;
    }

    @Override
    public double getCenterY() {
        return (y1 + y2 + y3) / 3;
    }

    // Tính chu vi tam giác
    @Override
    public double perimeter() {
        return canhA() + canhB() + canhC();
    }

    // Tính diện tích bằng công thức Heron
    @Override
    public double area() {
        double p = perimeter() / 2;

        double dienTich = p * (p - canhA())
                            * (p - canhB())
                            * (p - canhC());

        return Math.sqrt(Math.max(0, dienTich));
    }

    // Tịnh tiến tam giác
    @Override
    public void move(double dx, double dy) {
        x1 += dx;
        y1 += dy;

        x2 += dx;
        y2 += dy;

        x3 += dx;
        y3 += dy;
    }

    // Xoay tam giác
    @Override
    public void rotate(double angle) {
        double[] p1 = rotatePoint(x1, y1, angle);
        double[] p2 = rotatePoint(x2, y2, angle);
        double[] p3 = rotatePoint(x3, y3, angle);

        x1 = p1[0];
        y1 = p1[1];

        x2 = p2[0];
        y2 = p2[1];

        x3 = p3[0];
        y3 = p3[1];
    }

    // Phóng to hoặc thu nhỏ tam giác
    @Override
    public void zoom(double ratio) {
        if (ratio > 0) {
            x1 *= ratio;
            y1 *= ratio;

            x2 *= ratio;
            y2 *= ratio;

            x3 *= ratio;
            y3 *= ratio;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Tam giac: A(%.2f, %.2f), B(%.2f, %.2f), C(%.2f, %.2f)",
            x1, y1, x2, y2, x3, y3
        );
    }
}

// =============================================
// 7. LỚP RECTANGLE - HÌNH CHỮ NHẬT
// =============================================
class Rectangle extends BaseShape {

    private double x;
    private double y;
    private double chieuDai;
    private double chieuRong;
    private double gocXoay;

    // Hàm khởi tạo
    public Rectangle(
            double x, double y,
            double chieuDai, double chieuRong) {

        this.x = x;
        this.y = y;
        this.chieuDai = Math.abs(chieuDai);
        this.chieuRong = Math.abs(chieuRong);
        this.gocXoay = 0;
    }

    // Getter và Setter
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getChieuDai() { return chieuDai; }

    public void setChieuDai(double chieuDai) {
        if (chieuDai > 0) this.chieuDai = chieuDai;
    }

    public double getChieuRong() { return chieuRong; }

    public void setChieuRong(double chieuRong) {
        if (chieuRong > 0) this.chieuRong = chieuRong;
    }

    public double getGocXoay() {
        return gocXoay;
    }

    @Override
    public double getCenterX() {
        return x;
    }

    @Override
    public double getCenterY() {
        return y;
    }

    // Tính diện tích hình chữ nhật
    @Override
    public double area() {
        return chieuDai * chieuRong;
    }

    // Tính chu vi hình chữ nhật
    @Override
    public double perimeter() {
        return 2 * (chieuDai + chieuRong);
    }

    // Tịnh tiến hình chữ nhật
    @Override
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // Xoay hình chữ nhật quanh gốc tọa độ
    @Override
    public void rotate(double angle) {
        double[] p = rotatePoint(x, y, angle);

        x = p[0];
        y = p[1];

        gocXoay += angle;
    }

    // Phóng to hoặc thu nhỏ hình chữ nhật
    @Override
    public void zoom(double ratio) {
        if (ratio > 0) {
            x *= ratio;
            y *= ratio;

            chieuDai *= ratio;
            chieuRong *= ratio;
        }
    }

    @Override
    public String toString() {
        return String.format(
            "Hinh chu nhat: Tam(%.2f, %.2f), Dai=%.2f, Rong=%.2f, Goc xoay=%.2f",
            x, y, chieuDai, chieuRong, gocXoay
        );
    }
}

// =============================================
// 8. LỚP MAIN - CHƯƠNG TRÌNH CHÍNH
// =============================================
public class Main {

    static Random random = new Random();

    // Tạo một hình ngẫu nhiên
    public static Shape taoHinhNgauNhien() {

        int loai = random.nextInt(5);

        double x = random.nextInt(20) + 1;
        double y = random.nextInt(20) + 1;

        switch (loai) {

            // Tạo điểm
            case 0:
                return new Point(x, y);

            // Tạo hình tròn
            case 1:
                return new Circle(
                    x, y, random.nextInt(10) + 1
                );

            // Tạo đoạn thẳng
            case 2:
                return new Line(
                    x, y,
                    x + random.nextInt(10) + 1,
                    y + random.nextInt(10) + 1
                );

            // Tạo tam giác
            case 3:
                double a = random.nextInt(10) + 1;
                double b = random.nextInt(10) + 1;

                return new Triangle(
                    x, y,
                    x + a, y,
                    x, y + b
                );

            // Tạo hình chữ nhật
            default:
                return new Rectangle(
                    x, y,
                    random.nextInt(10) + 1,
                    random.nextInt(10) + 1
                );
        }
    }

    // Hiển thị danh sách hình
    public static void hienThiDanhSach(List<Shape> danhSach) {

        System.out.println("\n========== DANH SACH CAC HINH ==========");

        for (int i = 0; i < danhSach.size(); i++) {

            Shape hinh = danhSach.get(i);

            System.out.println("\nHinh thu " + (i + 1));
            System.out.println(hinh);

            System.out.printf("Dien tich: %.2f\n", hinh.area());
            System.out.printf("Chu vi: %.2f\n", hinh.perimeter());
        }
    }

    // Tính tổng diện tích và tổng chu vi
    public static void tinhTong(List<Shape> danhSach) {

        double tongDienTich = 0;
        double tongChuVi = 0;

        for (Shape hinh : danhSach) {
            tongDienTich += hinh.area();
            tongChuVi += hinh.perimeter();
        }

        System.out.println("\n========== TONG KET ==========");

        System.out.printf("Tong dien tich: %.2f\n", tongDienTich);
        System.out.printf("Tong chu vi: %.2f\n", tongChuVi);
    }

    // Tìm hình có diện tích lớn nhất và nhỏ nhất
    public static void timMaxMin(List<Shape> danhSach) {

        if (danhSach.isEmpty()) {
            System.out.println("Danh sach hinh dang trong!");
            return;
        }

        Shape max = danhSach.get(0);
        Shape min = danhSach.get(0);

        for (Shape hinh : danhSach) {

            if (hinh.area() > max.area()) {
                max = hinh;
            }

            if (hinh.area() < min.area()) {
                min = hinh;
            }
        }

        System.out.println("\n========== TIM DIEN TICH ==========");

        System.out.println("Hinh co dien tich lon nhat:");
        System.out.println(max);
        System.out.printf("Dien tich: %.2f\n", max.area());

        System.out.println("\nHinh co dien tich nho nhat:");
        System.out.println(min);
        System.out.printf("Dien tich: %.2f\n", min.area());
    }

    // Tính khoảng cách giữa hai hình đầu tiên
    public static void tinhKhoangCach(List<Shape> danhSach) {

        if (danhSach.size() < 2) {
            System.out.println("Can it nhat hai hinh!");
            return;
        }

        Shape hinh1 = danhSach.get(0);
        Shape hinh2 = danhSach.get(1);

        double khoangCach = hinh1.distance(hinh2);

        System.out.println("\n========== KHOANG CACH ==========");

        System.out.println("Hinh thu nhat: " + hinh1);
        System.out.println("Hinh thu hai: " + hinh2);

        System.out.printf(
            "Khoang cach giua hai tam: %.2f\n",
            khoangCach
        );
    }

    // Phóng to hoặc thu nhỏ tất cả các hình
    public static void phongToTatCa(List<Shape> danhSach, double tiLe) {

        if (tiLe <= 0) {
            System.out.println("Ti le phai lon hon 0!");
            return;
        }

        for (Shape hinh : danhSach) {
            hinh.zoom(tiLe);
        }

        System.out.println(
            "\nDa bien doi tat ca hinh voi ti le: " + tiLe
        );
    }

    // Tịnh tiến tất cả các hình
    public static void diChuyenTatCa(
            List<Shape> danhSach, double dx, double dy) {

        for (Shape hinh : danhSach) {
            hinh.move(dx, dy);
        }

        System.out.println("\nDa di chuyen tat ca cac hinh!");
    }

    // Xoay tất cả các hình
    public static void xoayTatCa(List<Shape> danhSach, double goc) {

        for (Shape hinh : danhSach) {
            hinh.rotate(goc);
        }

        System.out.println("\nDa xoay tat ca cac hinh!");
    }

    // =============================================
    // HÀM MAIN
    // =============================================
    public static void main(String[] args) {

        // Tạo danh sách quản lý các hình
        List<Shape> danhSach = new ArrayList<>();

        // Tạo 10 hình ngẫu nhiên
        for (int i = 0; i < 10; i++) {
            danhSach.add(taoHinhNgauNhien());
        }

        // 1. Hiển thị danh sách hình
        hienThiDanhSach(danhSach);

        // 2. Tính tổng diện tích và chu vi
        tinhTong(danhSach);

        // 3. Tìm hình có diện tích lớn nhất và nhỏ nhất
        timMaxMin(danhSach);

        // 4. Tính khoảng cách giữa hai hình
        tinhKhoangCach(danhSach);

        // 5. Phóng to tất cả hình lên 2 lần
        phongToTatCa(danhSach, 2);

        System.out.println("\n--- DANH SACH SAU KHI PHONG TO ---");
        hienThiDanhSach(danhSach);

        // 6. Di chuyển tất cả hình
        diChuyenTatCa(danhSach, 5, 5);

        System.out.println("\n--- DANH SACH SAU KHI DI CHUYEN ---");
        hienThiDanhSach(danhSach);

        // 7. Xoay tất cả hình 45 độ
        xoayTatCa(danhSach, 45);

        System.out.println("\n--- DANH SACH SAU KHI XOAY ---");
        hienThiDanhSach(danhSach);

        System.out.println("\n========== KET THUC CHUONG TRINH ==========");
    }
}
