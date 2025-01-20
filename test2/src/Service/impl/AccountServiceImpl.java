package Service.impl;

import Model.Account;
import Model.Status;
import Service.IAccountService;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAllAccount() {
        //tra ve tat ca tai khoan
        return accounts;
    }

    @Override
    public void createNewAccount(Account account) {
        //them tai khoan moi
        for (Account acc : accounts) {
            if (acc.getUsername().equals(account.getUsername())) {
                System.out.println("Account existed!");
                return;
            }
        }
        accounts.add(account);
    }

    @Override
    public Account getAccountByUsername(String username) {
        //tra ve tai khoan theo username
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        System.out.println("Account not found!");
        return null;
    }

    @Override
    public void deleteAccount(String username) {
        for (int i = accounts.size() - 1; i >= 0; i--) {
            if (accounts.get(i).getUsername().equals(username)) {
                accounts.remove(i);
                System.out.println("Delete account successfully!");
                return;
            }
        }
        System.out.println("Account not found!");
    }

    @Override
    public void changeStatus(String username, Status status) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                account.setStatus(status);
                System.out.println("Change status successfully!");
                return;
            }
        }
        System.out.println("Account not found!");
    }
}
