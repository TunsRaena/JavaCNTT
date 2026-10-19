import java.util.Scanner;
import java.util.Arrays;
public class bai2 {
    public static int[] nhapMang(Scanner scanner, String tenMang) {
        System.out.print("Nhap so luong phan tu cua " + tenMang + ": ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.println("Nhap lai phan tu n > 0: ");
            n = scanner.nextInt();
        }
        int[] mang = new int[n];

        System.out.println("Nhap " + n + " phan tu cho " + tenMang + ":");
        for (int i = 0; i < n; i++) {
            mang[i] = scanner.nextInt();
        }
        return mang;
    }
    public static int[] tongHaiMang(int[] mang1, int[] mang2) {
        int n = Math.max(mang1.length, mang2.length);
        int[] mangTong = new int[n];
        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = 0;
            if (i < mang1.length) {
                x = mang1[i];
            }
            if (i < mang2.length) {
                y = mang2[i];
            }
            mangTong[i] = x + y;
        }
        return mangTong;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mang1 = nhapMang(scanner, "mang 1");
        int[] mang2 = nhapMang(scanner, "mang 2");
        int[] mangTong = tongHaiMang(mang1, mang2);
        System.out.println("Mang 1: " + Arrays.toString(mang1));
        System.out.println("Mang 2: " + Arrays.toString(mang2));
        System.out.println("Tong hai mang: " + Arrays.toString(mangTong));
        scanner.close();
    }
}
