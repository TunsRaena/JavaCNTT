import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("n la mot so nguye duong");
            scanner.close();
        }

        int[] a = new int[n];
        System.out.println("Nhap " + n + " phan tu:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int tong = 0;
        for (int i = 0; i < n; i++) {
            tong += a[i];
        }
        System.out.println("Tong ca phan tu trong mang la: " + tong);
        scanner.close();
    }
}