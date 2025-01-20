package buoi4.lt;

import java.util.ArrayList;
import java.util.Scanner;

public class BookManage {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books;

    public void bookInput() {
        books = new ArrayList<>();
        System.out.println("Nhap so luong sach: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sach thu " + (i + 1));
            books.add(BookFunction.enterBook());
        }
    }

    public void bookOutput() {
        for (Book book : books) {
            BookFunction.displayBook(book);
        }
    }

    public void bookMenu() {
        int choosen = 0;
        while (choosen < 7) {
            System.out.println("Nhap lua chon: ");
            System.out.println("1. Them sach");
            System.out.println("2. Sua sach");
            System.out.println("3. In thong tin sach");
            System.out.println("4. In thong tin sach lau doi co kinh nhat");
            System.out.println("5. Cuon sach phu hop voi so tien");
            System.out.println("6. Sap xep sach theo gia tien");
            choosen = sc.nextInt();
            switch (choosen) {
                case 1:
                    BookFunction.addBook(books);
                    break;
                case 2:
                    System.out.println("Nhap ma sach muon sua: ");
                    int id = sc.nextInt();
                    BookFunction.editBook(books, id);
                    break;
                case 3:
                    bookOutput();
                    break;
                case 4:
                    BookFunction.oldestBook(books);
                    break;
                case 5:
                    System.out.println("Nhap gia tien ban co: ");
                    double price = sc.nextDouble();
                    BookFunction.findByPrice(books, price);
                    break;
                case 6:
                    BookFunction.sortByPrice(books);
                    break;
                default:
                    System.out.println("khong hop le, xin moi nhap lai");
                    choosen = 0;
                    break;
            }
        }
    }
}
