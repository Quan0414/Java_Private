package Service;

import java.util.Scanner;

public interface IAuthService {
    public void login(Scanner sc);
    public void logout();
    public void changePassword(String username, String oldPassword, String newPassword);
}
