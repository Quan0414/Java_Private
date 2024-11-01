package bai2;
import bai1.Student;

import java.util.Scanner;

public class Entry {

    public static void nhap(Student student, Scanner sc) {
        System.out.println("Nhap MSV: ");
        student.studentCode = sc.nextLine();
        System.out.println("Nhap ten: ");
        student.fullName = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        student.age = sc.nextByte();
        sc.nextLine(); 
        System.out.println("Nhap gioi tinh: ");
        student.gender = sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        student.phoneNumber = sc.nextLine();
        System.out.println("Nhap email: ");
        student.email = sc.nextLine();
    }

    public static void xuat(Student student) {
        System.out.println("MSV: " + student.studentCode);
        System.out.println("Ten: " + student.fullName);
        System.out.println("Tuoi: " + student.age);
        System.out.println("Gioi tinh: " + student.gender);
        System.out.println("So dien thoai: " + student.phoneNumber);
        System.out.println("Email: " + student.email);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        nhap(student, sc);
        xuat(student);
    }
}
