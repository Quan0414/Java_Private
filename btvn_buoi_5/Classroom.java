package buoi5.btvn_buoi_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Classroom {
	static ArrayList<Student> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public void sortByGpa() {
		list.sort(Comparator.comparing(Student::getGpa).reversed());
	}
	
	public void inputList() {
		while(true) {
			list.add(new Student());
			list.getLast().nhap();
			System.out.println("Nhập Thành Công Sinh Viên!");
			if (list.getLast().getId() == 555) return;
		}
	}
	
	public void outputList() {
		for(Student students : list) {
			students.xuat();
		}
	}
	
	public void removeById() {
		System.out.println("Nhập Vào ID cần Xóa:");
		int IdToRemove = sc.nextInt();
		

		if (list.removeIf(c -> c.getId() == IdToRemove)) {
			System.out.println("Đã Xóa");
		} else System.out.println("Không tồn tại để xóa!");
	}
	
	public static void main(String[] args) {
		
		Classroom Class = new Classroom();
		int n;
		do {
			System.out.println("1. Nhập Thông Tin Sinh Viên (đến khi có mã sinh viên 555 thì dừng nhập)");
			System.out.println("2. In Thông Tin Sinh Viên Dạng Bảng");
			System.out.println("3. Sắp xếp danh sách sinh viên theo gpa");
			System.out.println("4. Xóa sinh viên theo id");
			System.out.println("5. Exit");
			
			n = sc.nextInt();
			
			switch (n) {
			case 1: 
				Class.inputList();
				break;
			case 2:
				Class.outputList();
				break;
			case 3:
				Class.sortByGpa();
				break;
			case 4:
				Class.removeById();
				break;
				
			}
			
		} while (n < 5);
	}
}
