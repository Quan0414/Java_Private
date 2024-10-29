package test;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        StringBuilder chu = new StringBuilder();
        StringBuilder so = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                so.append(s.charAt(i));
                if (i + 1 < s.length() && s.charAt(i + 1) >= 'a' && s.charAt(i + 1) <= 'z') {
                    so.append(' ');
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                chu.append(s.charAt(i));
                if (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    chu.append(' ');
                }
            }
        }

        System.out.println(chu.toString());
        System.out.println(so.toString());
        
        scanner.close();
    }
}
