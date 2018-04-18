package com.wbxy.www.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {



    public static void main(String[] args){
        DBTest dbTest = new DBTest();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select pname from tbl_product";
        Integer rows = -1;
        try {
            connection = dbTest.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("pname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbTest.close(resultSet,preparedStatement,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
