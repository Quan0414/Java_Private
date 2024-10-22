package ex;

import java.util.Scanner;

public class Patient {
    private String patientCode;
    private String patientFullname;
    private int patientAge;
    private String patientHistory;
    private String patientDiagnosis;

    public Patient() {
    }

    public Patient(String patientCode, String patientFullname, int patientAge, String patientHistory, String patientDiagnosis) {
        this.patientCode = patientCode;
        this.patientFullname = patientFullname;
        this.patientAge = patientAge;
        this.patientHistory = patientHistory;
        this.patientDiagnosis = patientDiagnosis;
    }

    public Patient(String patienCode) {
        this.patientCode = patienCode;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientFullname() {
        return patientFullname;
    }

    public void setPatientFullname(String patientFullname) {
        this.patientFullname = patientFullname;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(String patientHistory) {
        this.patientHistory = patientHistory;
    }

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }
    
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma benh nhan: ");
        patientCode = sc.nextLine();
        System.out.print("Nhap ten benh nhan: ");
        patientFullname = sc.nextLine();
        System.out.print("Nhap tuoi benh nhan: ");
        patientAge = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap tien su benh: ");
        patientHistory = sc.nextLine();
        System.out.print("Nhap chan doan: ");
        patientDiagnosis = sc.nextLine();
    }

    public void xuat() {
        System.out.println("Ma benh nhan: " + patientCode);
        System.out.println("Ten benh nhan: " + patientFullname);
        System.out.println("Tuoi benh nhan: " + patientAge);
        System.out.println("Tien su benh: " + patientHistory);
        System.out.println("Chan doan: " + patientDiagnosis);
    }
   
}