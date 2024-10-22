package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class Entry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Patient[] patients = new Patient[10];
        System.out.println("Nhap so benh nhan: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            patients[i] = new Patient();
            patients[i].nhap();
        }

        String ma = scanner.nextLine();
        System.out.println("Nhap ma benh nhan can tim: ");
        ma = scanner.nextLine();

        for(int i = 0; i < n; i++) {
            if(patients[i].getPatientCode().equals(ma)) {
                System.out.println("Benh nhan can tim la: " + patients[i]);
            }
        }
      

        System.out.println("List of patients:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + patients[i]);
        }
        scanner.close();
    }
}
