package Service;

import Model.Account;
import Model.Status;

import java.util.List;

public interface IAccountService {
    List<Account> getAllAccount();
    void createNewAccount(Account account);
    Account getAccountByUsername(String username);
    void deleteAccount(String username);
    void changeStatus(String username, Status status);

}
