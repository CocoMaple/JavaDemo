package com.wbxy.www.test;

import java.sql.*;

public class DBTest {

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost/shopxx","root","root");
        return  connection;
    }

    public void close(ResultSet rs, PreparedStatement preparedStatement ,Connection connection) throws SQLException {

        if(null != rs){
            rs.close();
        }
        if(null != preparedStatement){
            preparedStatement.close();
        }
        if(null != connection){
            connection.close();
        }

    }

}
