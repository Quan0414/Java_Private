import Service.IUserService;
import Service.impl.IUserServiceImpl;
import Service.IProductManager;
import Service.impl.IProductManagerImpl;
import Model.Product;
import Model.Role;
import Model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IUserService userService = new IUserServiceImpl();
        IProductManager productManager = new IProductManagerImpl();

        userService.login(sc);

        User currentUser = ((IUserServiceImpl) userService).getCurrentUser();
        if (currentUser != null) {
            if (currentUser.getRole() == Role.ADMIN) {
                adminMenu(sc, productManager);
            } else {
                customerMenu(sc, productManager);
            }
        }
    }

    private static void adminMenu(Scanner sc, IProductManager productManager) {
        while (true) {
            System.out.println("=== Quản lý Sản phẩm (Admin) ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo tên");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Cập nhật thông tin sản phẩm");
            System.out.println("6. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Nhập thông tin sản phẩm:");
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Giá: ");
                    double price = sc.nextDouble();
                    System.out.print("Số lượng: ");
                    int quantity = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    Product product = new Product(id, name, price, quantity) {
                        @Override
                        public double totalPrice() {
                            return getPrice() * getQuantity();
                        }
                    };
                    productManager.addProduct(product);
                    break;
                case 2:
                    productManager.displayProduct();
                    break;
                case 3:
                    System.out.print("Nhập tên sản phẩm: ");
                    String searchName = sc.nextLine();
                    productManager.searchProduct(searchName);
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm: ");
                    String deleteId = sc.nextLine();
                    productManager.deleteProduct(deleteId);
                    break;
                case 5:
                    System.out.print("Nhập mã sản phẩm: ");
                    String updateId = sc.nextLine();
                    productManager.updateProduct(updateId);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void customerMenu(Scanner sc, IProductManager productManager) {
        while (true) {
            System.out.println("=== Xem Sản phẩm (Customer) ===");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm theo tên");
            System.out.println("3. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    productManager.displayProduct();
                    break;
                case 2:
                    System.out.print("Nhập tên sản phẩm: ");
                    String searchName = sc.nextLine();
                    productManager.searchProduct(searchName);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}