package buoi5.btvn_buoi_5;

import java.util.Scanner;

public class Student extends Person {
    private int id;
    private String nameClass;
    private float gpa;
    private final float criteria = 2;

    public Student() {
    }

    public Student(int id, String nameClass, float gpa) {
        this.id = id;
        this.nameClass = nameClass;
        this.gpa = gpa;
    }

    public Student(String name, int age, Address address, int id, String nameClass, float gpa) {
        super(name, age, address);
        this.id = id;
        this.nameClass = nameClass;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public float getCriteria() {
        return criteria;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap ma sinh vien: ");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten lop: ");
        this.nameClass = sc.nextLine();
        System.out.println("Nhap diem trung binh: ");
        this.gpa = sc.nextFloat();
    }

    public void xuat() {
        super.xuat();
        System.out.println("Ma sinh vien: " + this.id);
        System.out.println("Ten lop: " + this.nameClass);
        System.out.println("Diem trung binh: " + this.gpa);
    }

    boolean checkFall() {
        return this.gpa < this.criteria;
    }
}
