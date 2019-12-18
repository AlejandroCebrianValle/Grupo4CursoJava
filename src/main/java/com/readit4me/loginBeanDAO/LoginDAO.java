package com.readit4me.loginBeanDAO;

import java.sql.*;
import com.readit4me.loginBeanDAO.LoginBean;

public class LoginDAO {

    public int validate(LoginBean loginBean) throws ClassNotFoundException {
        //boolean status = false;
        int codUser = -1;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/readit4me?useSSL=false", "root", "Azf$2069");
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from USER where nameUser = ? and contrasenna = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
            	codUser = rs.getInt("codUser");
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        
		return codUser;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}