package com.totoro.jdbc.v2;

import com.totoro.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
    public static void main(String[] args) {
        new JdbcTest().queryUser();
        //  new JdbcTest().addUser();
    }
    /**
     *
     * 通过JDBC查询用户信息
     */
    public void queryUser(){
        Connection conn = null;
        Statement stmt = null;
        User user = new User();
        ResultSet rs = null;
        try {
            // 打开连接
            conn = DBUtils.getConnection();
            // 执行查询
            stmt = conn.createStatement();
            String sql = "SELECT id,user_name,real_name,password,age,d_id from t_user where id = 1";
            rs = stmt.executeQuery(sql);

            // 获取结果集
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String userName = rs.getString("user_name");
                String realName = rs.getString("real_name");
                String password = rs.getString("password");
                Integer age = rs.getInt("age");
                Integer did = rs.getInt("d_id");
                user.setId(id);
                user.setUserName(userName);
                user.setRealName(realName);
                user.setPassword(password);
                user.setAge(age);
                user.setDId(did);
                System.out.println(user);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,stmt,rs);
        }
    }

    /**
     * 通过JDBC实现添加用户信息的操作
     */
    public void addUser(){
        Connection conn = null;
        Statement stmt = null;
        try {
            // 打开连接
            conn = DBUtils.getConnection();
            // 执行查询
            stmt = conn.createStatement();
            String sql = "INSERT INTO T_USER(user_name,real_name,password,age,d_id)values('wangwu','王五','111',22,1001)";
            int i = stmt.executeUpdate(sql);
            System.out.println("影响的行数:" + i);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn,stmt);
        }
    }
}
