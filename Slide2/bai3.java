import java.util.Scanner;
public class bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap cac phan tu so nguyen tren 1 dong: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Khong co phan tu nao duoc nhap");
            scanner.close();
            return;
        }

        String[] parts = input.split("\\s+");
        int soPhanTu = parts.length;
        int tong = 0;
        for (int i = 0; i < parts.length; i++) {
            int phanTu = Integer.parseInt(parts[i]);
            tong += phanTu;
        }
        System.out.println("So phan tu: " + soPhanTu); 
        System.out.println("Tong ca phan tu trong mang la: " + tong);
        scanner.close();
    }
}
    