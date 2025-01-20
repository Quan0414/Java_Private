import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class JDBCConnector {
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static String DRIVER;

    static {
        try (InputStream fis = JDBCConnector.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (fis == null) {
                throw new FileNotFoundException("File application.properties không tồn tại!");
            }
            Properties properties = new Properties();
            properties.load(fis);

            URL = properties.getProperty("datasource.url");
            USERNAME = properties.getProperty("datasource.username");
            PASSWORD = properties.getProperty("datasource.password");
            DRIVER = properties.getProperty("datasource.driver-class-name");

            Class.forName(DRIVER);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void addUser(Scanner sc) {
        try {
            Connection connection = getConnection();
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            System.out.println("Enter position: ");
            String position = sc.nextLine();
            System.out.println("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter hire date: ");
            String hireDate = sc.nextLine();
            String query = "INSERT INTO employees(name, position, salary, hire_date) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setDouble(3, salary);
            preparedStatement.setString(4, hireDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(Scanner sc) {
        try {
            Connection connection = getConnection();
            System.out.println("Enter id: ");
            int id = sc.nextInt();
            String query = "DELETE FROM employees WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void display() {
        System.out.println("Danh sách nhân viên:");
        String query = "SELECT * FROM employees";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             var resultSet = preparedStatement.executeQuery()) {

            // Hiển thị tiêu đề cột
            System.out.printf("%-5s %-20s %-20s %-10s %-15s%n", "ID", "Tên", "Chức vụ", "Lương", "Ngày tuyển dụng");
            System.out.println("---------------------------------------------------------------------------------");

            // Duyệt qua từng bản ghi
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");
                String hireDate = resultSet.getString("hire_date");

                // Hiển thị dữ liệu
                System.out.printf("%-5d %-20s %-20s %-10.2f %-15s%n", id, name, position, salary, hireDate);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi truy vấn dữ liệu: " + e.getMessage());
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        try {
            Connection connection = JDBCConnector.getConnection();
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add user");
        System.out.println("2. Delete user");
        System.out.println("3. Display");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addUser(sc);
                display();
                break;
            case 2:
                deleteUser(sc);
                display();
                break;
                case 3:
                    display();
                    break;
        }
    }
}
