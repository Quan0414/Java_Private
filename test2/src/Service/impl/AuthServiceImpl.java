package Service.impl;

import Model.Account;
import Model.Address;
import Model.Role;
import Model.Status;
import Service.IAuthService;

import java.util.ArrayList;
import java.util.Scanner;

public class AuthServiceImpl implements IAuthService {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Account currentAccount;

    //them tai khoan admin mac dinh
    public AuthServiceImpl() {
        accounts.add(new Account( "1", "Quan", "19", new Address("abc", "def"), "14-04-2005","admin", "admin", Role.ADMIN, Status.ACTIVE));
        accounts.add(new Account("2", "quanneee", "19", new Address("abc", "def"), "14-04-2005","user", "user", Role.USER, Status.ACTIVE));
        currentAccount = null;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    @Override
    public void login(Scanner sc) {
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                currentAccount = account;
                System.out.println("Login successfully!");
                return;
            }
        }
        System.out.println("Login failed!");
    }

    @Override
    public void logout() {
        if (currentAccount != null) {
            System.out.println("Logout successfully!");
            currentAccount = null;
        } else {
            System.out.println("No user is currently logged in!");
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(oldPassword)) {
                account.setPassword(newPassword);
                System.out.println("Change password successfully!");
                return;
            }
        }
        System.out.println("Change password failed!");
    }
}
