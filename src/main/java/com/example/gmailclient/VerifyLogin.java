package com.example.gmailclient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerifyLogin {



    public static boolean checkLogin( String email,String pass){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        boolean status=false;
        connection = DatabaseConnection.getConnection();
        try {

            PreparedStatement ps=connection.prepareStatement("Select * from demo where email = ? and pass =?");
            ps.setString(1,email);
            ps.setString(2,pass);
            ResultSet rs=ps.executeQuery();
            status=rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
