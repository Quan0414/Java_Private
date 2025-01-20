package buoi1;

import java.util.Scanner;

public class bai2 {
    public static int tich(int a) {
        int t = 1;
        while (a > 0) {
            t *= a % 10;
            a /= 10;
        }
        return t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tich(n));
    }

}
