package com.seu.dao;

import com.mysql.jdbc.Driver;
import com.seu.model.UserTransactionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * Created by SUN on 2017.12.21.
 */
@Repository
public class UserTransactionDAO {
    @Autowired
    private DBSetting dbSetting;

    public UserTransactionInfo fine(String user_id) throws Exception{
        String sql = "select * from user_transaction where user_id= ?";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,user_id);
            rs = preStmt.executeQuery();
            if(rs.next()){
                UserTransactionInfo userTransactionInfo = new UserTransactionInfo();
                userTransactionInfo.setUser_id(user_id);
                userTransactionInfo.setCommodity_list(rs.getString("commodity_list"));
                userTransactionInfo.setCollection_list(rs.getString("collection_list"));
                userTransactionInfo.setOrder_list(rs.getString("order_list"));

                return userTransactionInfo;
            }else
                return null;
        }finally {
            if(rs!=null) rs.close();
            if(preStmt!=null) preStmt.close();
            if(conn!=null) conn.close();
        }
    }

    public String[] getCommodities(String user_id) throws Exception {
        UserTransactionInfo userTransactionInfo = fine(user_id);
        return userTransactionInfo.getCommodity_list().split(";");
    }
    public String[] getCollections(String user_id) throws Exception {
        UserTransactionInfo userTransactionInfo = fine(user_id);
        return userTransactionInfo.getCollection_list().split(";");
    }
    public String[] getOrders(String user_id) throws Exception {
        UserTransactionInfo userTransactionInfo = fine(user_id);
        return userTransactionInfo.getOrder_list().split(";");
    }

    public String getCommodity_list(String user_id) throws Exception {
        UserTransactionInfo userTransactionInfo = fine(user_id);
        return userTransactionInfo.getCommodity_list();
    }
    public String getCollection_list(String user_id) throws Exception {
        UserTransactionInfo userTransactionInfo = fine(user_id);
        return userTransactionInfo.getCollection_list();
    }
    public String getOrder_list(String user_id) throws Exception {
        UserTransactionInfo userTransactionInfo = fine(user_id);
        return userTransactionInfo.getOrder_list();
    }

    public boolean isExistList(String user_id,String listName,String page_id) throws Exception {
        String[] lists=null;
        if(listName.equals("commodity_list"))
            lists=getCommodities(user_id);
        if(listName.equals("collection_list"))
            lists=getCollections(user_id);
        if(listName.equals("order_list"))
            lists=getOrders(user_id);
        //判断是否已经添加购物车或者购买
        for(String s:lists){
            if(s.equals(""))
                continue;
            if(s.equals(page_id))
                return true;//表示已经存在
        }
        return false;
    }

    public void add(String user_id) throws Exception {
        String sql = "insert into user_transaction(user_id,commodity_list,collection_list,order_list) values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, user_id);
            preStmt.setString(2, "");
            preStmt.setString(3, "");
            preStmt.setString(4, "");

            preStmt.executeUpdate();
        } finally {
            preStmt.close();
            conn.close();
        }
    }

    public int addList(String user_id,String listName,String page_id) throws Exception {
        String[] lists=null;
        if(listName.equals("commodity_list"))
            lists=getCommodities(user_id);
        if(listName.equals("collection_list"))
            lists=getCollections(user_id);
        if(listName.equals("order_list"))
            lists=getOrders(user_id);
        //判断是否已经添加购物车或者购买
        String str="";
        for(String s:lists){
            if(s.equals(""))
                continue;
            str+=s+";";
            if(s.equals(page_id))
                return 0;//表示已经存在
        }
        //若不存在更新列表
        str+=page_id+";";
        String sql = "update user_transaction set "+listName+" = ? where user_id= ?";
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, str);
            preStmt.setString(2, user_id);
            preStmt.executeUpdate();
            return 1;//表示更新成功
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;//表示更新失败
        }
        finally {
            preStmt.close();
            conn.close();
        }
    }

    public void deleteList(String user_id,String listName,String page_id) throws Exception {
        String[] lists=null;
        if(listName.equals("commodity_list"))
            lists=getCommodities(user_id);
        if(listName.equals("collection_list"))
            lists=getCollections(user_id);
        if(listName.equals("order_list"))
            lists=getOrders(user_id);
        //判断是否已经添加购物车或者购买
        String str="";
        for(String s:lists){
            if(s.equals(""))
                continue;
            if(s.equals(page_id)){
                continue;
            }
            str+=s+";";
        }
        String sql = "update user_transaction set "+listName+" = ? where user_id= ?";
        Connection conn = null;
        PreparedStatement preStmt = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, str);
            preStmt.setString(2, user_id);
            preStmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            preStmt.close();
            conn.close();
        }
    }
}
