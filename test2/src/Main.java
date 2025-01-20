import Model.Account;
import Model.Role;
import Model.Status;
import Service.impl.AccountServiceImpl;
import Service.impl.AuthServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthServiceImpl authService = new AuthServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
        Scanner sc = new Scanner(System.in);

        authService.login(sc);
        Account curAcc = authService.getCurrentAccount();

        while (curAcc != null) {
            System.out.println("\n========== Hệ thống quản lí tài khoản ==========");
            if (curAcc.getRole() == Role.ADMIN) {
                System.out.println("Xin chào ADMIN: " + curAcc.getUsername());
                System.out.println("Chọn 1 trong các chức năng sau:");
                System.out.println("1. Xem danh sách tài khoản");
                System.out.println("2. Tạo tài khoản mới");
                System.out.println("3. Tìm kiếm tài khoản theo username");
                System.out.println("4. Xóa tài khoản");
                System.out.println("5. Thay đổi trạng thái tài khoản");
                System.out.println("6. Xem thông tin cá nhân");
                System.out.println("0. Đăng xuất");
                System.out.println("---------------------------------------------");
                System.out.println("Nhập lựa chọn của bạn: ");
            } else {
                System.out.println("\n========== Hệ thống người dùng ==========");
                System.out.println("Xin chào USER: " + curAcc.getUsername());
                System.out.println("Chọn 1 trong các chức năng sau:");
                System.out.println("1. Đổi mật khẩu");
                System.out.println("2. Xem thông tin cá nhân");
                System.out.println("0. Đăng xuất");
                System.out.println("---------------------------------------------");
                System.out.println("Nhập lựa chọn của bạn: ");
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (curAcc.getRole() == Role.ADMIN) {
                        List<Account> accounts = accountService.getAllAccount();
                        for (Account account : accounts) {
                            System.out.println(account);
                        }
                    } else {
                        System.out.println("Nhập mật khẩu cũ: ");
                        String oldPassword = sc.nextLine();
                        System.out.println("Nhập mật khẩu mới: ");
                        String newPassword = sc.nextLine();
                        authService.changePassword(curAcc.getUsername(), oldPassword, newPassword);
                    }
                    break;
                case 2:
                    if (curAcc.getRole() == Role.ADMIN) {
                        System.out.println("Nhập tên tài khoản mới: ");
                        String newUsername = sc.nextLine();
                        System.out.println("Nhập mật khẩu mới: ");
                        String newPassword = sc.nextLine();
                        System.out.println("Nhập role (ADMIN/USER): ");
                        Role role = Role.valueOf(sc.nextLine().toUpperCase());
                        Account newAccount = new Account(newUsername, newPassword, role, Status.ACTIVE);
                        accountService.createNewAccount(newAccount);

                    } else {
                        System.out.println(curAcc);
                    }
                    break;
                case 3:
                    if (curAcc.getRole() == Role.ADMIN) {
                        System.out.println("Nhập username cần tìm: ");
                        String searchUsername = sc.nextLine();
                        Account account = accountService.getAccountByUsername(searchUsername);
                        if (account != null) {
                            System.out.println(account);
                        }
                    }
                    break;
                case 4:
                    if (curAcc.getRole() == Role.ADMIN) {
                        System.out.println("Nhập username cần xóa: ");
                        String deleteUsername = sc.nextLine();
                        accountService.deleteAccount(deleteUsername);
                    }
                    break;
                case 5:
                    if (curAcc.getRole() == Role.ADMIN) {
                        System.out.println("Nhập username cần thay đổi trạng thái: ");
                        String statusUsername = sc.nextLine();
                        System.out.println("Nhập trạng thái mới (ACTIVE/BAN): ");
                        Status status = Status.valueOf(sc.nextLine().toUpperCase());
                        accountService.changeStatus(statusUsername, status);
                    }
                    break;
                case 6:
                    if (curAcc.getRole() == Role.ADMIN) {
                        System.out.println(curAcc);
                    }
                    break;
                case 0:
                    authService.logout();
                    curAcc = null;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

            if (curAcc == null) {
                authService.login(sc);
                curAcc = authService.getCurrentAccount();
            }
        }
    }
}