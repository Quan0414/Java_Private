import db.DbConnect;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner Ip = new Scanner(System.in);
        String id= Ip.nextLine();
        try {
            Connection connection = DbConnect.getConnection();
            String query= "UPDATE Product SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "CLB HIT 2");
            preparedStatement.setString(2, id);
            System.out.println(preparedStatement.executeUpdate());


            String selectById= "SELECT * FROM Product WHERE id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(selectById);
            preparedStatement1.setString(1, id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while(resultSet.next()){
                String productId = resultSet.getString("id");
                String productName = resultSet.getString("name");
                String productPrice = resultSet.getString("price");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}