package test;

import java.util.Scanner;

public class bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextLong();
        }
        
        long[] pre = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                pre[i] = a[i];
            } else {
                pre[i] = pre[i - 1] + a[i];
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(pre[i] + " ");
        }
        System.out.println();
        
        int q = scanner.nextInt();
        while (q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l == 1) {
                System.out.println(pre[r]);
            } else {
                System.out.println(pre[r] - pre[l - 1]);
            }
        }
        
        
    }
}
