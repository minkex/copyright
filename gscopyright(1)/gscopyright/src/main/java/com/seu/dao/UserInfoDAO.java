package com.seu.dao;

import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by SUN on 2017.12.21.
 */
@Repository
public class UserInfoDAO {
    @Autowired
    private DBSetting dbSetting;
    @Autowired
    private UserTransactionDAO userTransactionDAO;
    public String findPasswd(String name) throws Exception {
        String sql = "select * from userinfo where name= ?";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, name);
            rs = preStmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("passwd");
                return password;
            } else
                return null;
        } finally {
            if (rs != null) rs.close();
            if (preStmt != null) preStmt.close();
            if (conn != null) conn.close();
        }
    }
    public String findmediaPasswd(String name) throws Exception {
        String sql = "select * from mediainfo where medianame= ?";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, name);
            rs = preStmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");

                return password;
            } else
                return null;
        } finally {
            if (rs != null) rs.close();
            if (preStmt != null) preStmt.close();
            if (conn != null) conn.close();
        }
    }
    public void add(String name, String password, String email, String sex) throws Exception {
        String sql = "insert into userinfo(name,passwd,email,sex) values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, name);
            preStmt.setString(2, password);
            preStmt.setString(3, email);
            preStmt.setString(4, sex);
            preStmt.executeUpdate();
            userTransactionDAO.add(name);//新增用户同时新增user_transaction表中user_id
        } finally {
            preStmt.close();
            conn.close();
        }

    }
    public void add(String medianame, String username, String idnumber, String registernumber,String password,String mediacode) throws Exception {
        String sql = "insert into mediainfo(medianame,username,idnumber,registernumber,password,mediacode) values(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, medianame);
            preStmt.setString(2, username);
            preStmt.setString(3, idnumber);
            preStmt.setString(4, registernumber);
            preStmt.setString(5, password);
            preStmt.setString(6, mediacode);
            preStmt.executeUpdate();
            userTransactionDAO.add(mediacode.substring(1));//新增用户同时新增user_transaction表中user_id
        } finally {
            preStmt.close();
            conn.close();
        }

    }
    public String getID(String medianame) throws Exception {

        String sql = "select * from mediainfo where medianame= ?";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, medianame);
            rs = preStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                return String.valueOf(id);
            } else
                return null;
        } finally {
            if (rs != null) rs.close();
            if (preStmt != null) preStmt.close();
            if (conn != null) conn.close();
        }

    }
    public int findId() throws Exception {
        String sql = "select MAX(id) from mediainfo";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            } else
                return 0;
        } finally {
            if (rs != null) rs.close();
            if (preStmt != null) preStmt.close();
            if (conn != null) conn.close();
        }
    }
}
