import db.dbConnect;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = dbConnect.getConnection();
            while (true) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter id: ");
                        int id = scanner.nextInt();
                        String selectById = "SELECT * FROM Product WHERE id = ?";
                        PreparedStatement preparedStatement1 = connection.prepareStatement(selectById);
                        preparedStatement1.setInt(1, id);
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        while (resultSet.next()) {
                            System.out.println(resultSet.getString("name"));
                        }
                        break;
                    case 2:
                        System.out.println("Enter id: ");
                        String name = scanner.nextLine();
                        int id2 = scanner.nextInt();
                        String query = "UPDATE Product SET name = ? WHERE id = ?";
                        PreparedStatement preparedStatement2 = connection.prepareStatement(query);
                        preparedStatement2.setString(1, name);
                        preparedStatement2.setInt(2, id2);

                        ResultSet resultSet2 = preparedStatement2.executeQuery();
                        while (resultSet2.next()) {
                            System.out.println(resultSet2.getString("name"));
                        }
                        break;

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
//---------------------------------------------------------------------------------------
//            int id = scanner.nextInt();
//            Connection connection = dbConnect.getConnection();
//            String query = "UDATE Product SET name = ? WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, "CLB HIT 2");
//            preparedStatement.setInt(2, id);
//            System.out.println(preparedStatement.executeUpdate());
//
//
//            String selectById = "SELECT * FROM Product WHERE id = ?";
//            PreparedStatement preparedStatement2 = connection.prepareStatement(selectById);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//
//            //tạo menu chọn 1: select, 2: update
//
//
//
//
//
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("name"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

