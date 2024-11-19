package buoi5.btvn_buoi_5;

import java.util.Scanner;

public class Person {
    protected String name;
    protected int age;
    Address address;

    public Person() {
    }
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten: ");
        this.name = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap dia chi: ");
        this.address = new Address();
        this.address.nhap();
    }

    public void xuat() {
        System.out.printf("%-20s%-20s",name,age);
        address.display();
    }
}
