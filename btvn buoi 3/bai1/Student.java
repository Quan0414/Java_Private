package bai1;

public class Student {
    public String studentCode;
    public String fullName;
    public byte age;
    public String gender;
    public String phoneNumber;
    public String email;

    public Student() {

    }

    public Student(String studentCode, String fullName, byte age, String gender, String phoneNumber, String email) {
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display() {
        System.out.printf("%-15s %-15s %-15s %-15d %-15s %-15s", "Student Code", "Full Name", "Age", "Gender", "Phone Number", "Email");
        System.out.printf("%-15s %-15s %-15s %-15d %-15s %-15s", studentCode, fullName, age, gender, phoneNumber, email);
    }
}