package buoi1;

import java.util.Scanner;
import java.util.Arrays;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[3] + " " + arr[4]);
    }
    
}
