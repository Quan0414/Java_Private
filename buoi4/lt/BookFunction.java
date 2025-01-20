package buoi4.lt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class BookFunction {

    static Scanner scanner = new Scanner(System.in);

    public static Book enterBook() {
        System.out.println("Nhap ma sach: ");
        int maSach = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap ten sach: ");
        String tenSach = scanner.nextLine();
        Tacgia tenTacGia = new Tacgia(scanner.nextLine());
        System.out.println("Nhap nam san xuat: ");
        int namSanXuat = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap tom tat noi dung: ");
        String tomTatNoiDung = scanner.nextLine();
        System.out.println("Nhap gia tien: ");
        double giaTien = scanner.nextDouble();

        return new Book(maSach, tenSach, tenTacGia, namSanXuat, tomTatNoiDung, giaTien);
    }

    public static void displayBook(Book book) {
        book.display();
    }

    public static void addBook(ArrayList<Book> books) {
        System.out.println("Nhap thong tin sach can them: ");
        books.add(enterBook());
    }

    public static void editBook(ArrayList<Book> books, int id) {
        for (Book book : books) {
            if (Objects.equals(book.getMaSach(), id)) {
                Book newBook = enterBook();
                book.setMaSach(newBook.getMaSach());
                book.setTenSach(newBook.getTenSach());
                book.setTenTacGia(newBook.getTenTacGia());
                book.setNamSanXuat(newBook.getNamSanXuat());
                book.setTomTatNoiDung(newBook.getTomTatNoiDung());
                book.setGiaTien(newBook.getGiaTien());
                System.out.println("Sua thanh cong!");
                return;
            }
        }
    }

    public static void oldestBook(ArrayList<Book> books) {
        Book oldestBook = books.get(0);
        for (Book book : books) {
            if (book.getNamSanXuat() < oldestBook.getNamSanXuat()) {
                oldestBook = book;
            }
        }
        System.out.println("Sach lau doi co kinh nhat la: ");
        oldestBook.display();
    }

    public static void findByPrice(ArrayList<Book> books, double price) {
        double diff = Math.abs(books.get(0).getGiaTien() - price);
        Book suitBook = books.get(0);
        for (Book book : books) {
            if (Math.abs(book.getGiaTien() - price) < diff) {
                diff = Math.abs(book.getGiaTien() - price);
                suitBook = book;
            }
        }
        System.out.println("Sach phu hop voi ban la: ");
        suitBook.display();
    }

    public static void sortByPrice(ArrayList<Book> books) {
        books.sort(Comparator.comparingDouble(Book::getGiaTien));
        System.out.println("Sach theo gia tang dan: ");
        for (Book book : books) {
            book.display();
        }
    }
}
