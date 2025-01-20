package buoi1;

import java.util.Scanner;

public class bai1 {

    public static String doiCoSo(int n, int coSo) {
        String s = "0123456789ABCDEF";
        String kq = "";
        while (n > 0) {
            kq = s.charAt(n % coSo) + kq;
            n /= coSo;
        }
        return kq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        System.out.print("Nhap co so: ");
        int coSo = sc.nextInt();
        System.out.println("Ket qua: " + doiCoSo(n, coSo));

    }
}