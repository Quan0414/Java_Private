package buoi4.btvn_buoi_4;

import java.util.Scanner;

public class Entry {
    public static void nhap(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien: ");
        student.setStudentCode(sc.nextLine());
        System.out.println("Nhap ten sinh vien: ");
        student.setFullName(sc.nextLine());
        System.out.println("Nhap tuoi sinh vien: ");
        student.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap gioi tinh sinh vien: ");
        student.setGender(sc.nextLine());
        System.out.println("Nhap so dien thoai sinh vien: ");
        student.setPhoneNumber(sc.nextLine());
        System.out.println("Nhap email sinh vien: ");
        student.setEmail(sc.nextLine());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        nhap(student);
        student.inTD();
        student.xuat();
    }
}
