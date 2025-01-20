package buoi4.btvn_buoi_4;

public class Student {
    private String studentCode;
    private String fullName;
    private int age;
    private String gender;
    private String phoneNumber;
    private String email;

    public Student() {
    }

    public Student(String studentCode, String fullName, int age, String gender, String phoneNumber, String email) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
    
    public void inTD() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s \n", "Ma sinh vien", "Ten sinh vien", "Tuoi", "Gioi tinh", "So dien thoai", "Email");
    }

    public void xuat() {
        System.out.printf("%-15s %-15s %-15d %-15s %-15s %-15s \n", studentCode, fullName, age, gender, phoneNumber, email);
    }
}
