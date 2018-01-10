package com.seu.utils;

import com.mysql.jdbc.Driver;
import com.seu.dao.PageinfoDAO;
import com.seu.model.Pageinfo;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 * 将不同的新闻类别的新闻ID存入另一张表
 */
public class MaintenanceCategoryLlist {
    private static String addr = "223.3.68.10";
    public Connection getConnection(String dbName, String userName,
                                    String password) throws SQLException {

        String url = "jdbc:mysql://"+addr+":3306/" + dbName
                + "?characterEncoding=utf-8";

        DriverManager.registerDriver(new Driver());

        return DriverManager.getConnection(url, userName, password);
    }
    public Connection getConnection() throws SQLException {
        return getConnection("copyright", "root", "root");
    }
    @Test//更新对应类别的列表
    public void maintenance() throws Exception {
        String[] types = new String[]{"allcates","politics","finance","local","technology","international",
                "car","taiwan","education","sports","HKM","health","house","energy"};
        for(String str:types){
            String sql = "update categorylist set "+str+" = ? WHERE _id = 1";
            Connection conn = null;
            PreparedStatement preStmt = null;
            String s="";
            try {
                conn = getConnection();
                preStmt = conn.prepareStatement(sql);
                s= fineByCtype(str).toString();
                preStmt.setString(1, s.substring(1,s.length()-1));
                preStmt.executeUpdate();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            finally {
                preStmt.close();
                conn.close();
            }
            System.out.println(s.substring(1,s.length()-1));
        }
    }
    //根据类别查找
    public List<Integer> fineByCtype(String ctype) throws Exception{
        String sql,ctypeCH="";
        if(ctype.equals("allcates"))
            sql = "select * from pageinfo order by _id DESC";
        else{
            switch (ctype){
                case "politics":{ctypeCH="时政";break;}
                case "finance":{ctypeCH="财经";break;}
                case "local":{ctypeCH="地方";break;}
                case "technology":{ctypeCH="科技";break;}
                case "international":{ctypeCH="国际";break;}
                case "car":{ctypeCH="汽车";break;}
                case "taiwan":{ctypeCH="台湾";break;}
                case "education":{ctypeCH="教育";break;}
                case "sports":{ctypeCH="体育";break;}
                case "HKM":{ctypeCH="港澳";break;}
                case "health":{ctypeCH="健康";break;}
                case "house":{ctypeCH="房产";break;}
                case "energy":{ctypeCH="能源";break;}
            }
            sql = "select * from pageinfo where ctype= ? order by _id DESC";
        }
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            preStmt = conn.prepareStatement(sql);
            if(!ctype.equals("allcates"))
                preStmt.setString(1,ctypeCH);
            rs = preStmt.executeQuery();
            List<Integer> list = new ArrayList<>();
            int i=20;
            while (rs.next()&&i>0){
                list.add(rs.getInt("_id"));i--;
            }
            return list;
        }finally {
            if(rs!=null) rs.close();
            if(preStmt!=null) preStmt.close();
            if(conn!=null) conn.close();
        }
    }

    @Test
    public void f() throws Exception {
        for(Pageinfo p:fineByCtype1("")){
            System.out.println(p.getTitle());
        }
    }

    public List<Pageinfo> fineByCtype1(String ctype) throws Exception{
        if(ctype==null||ctype.equals(""))
            ctype="allcates";
        String sql = "select * from categorylist where _id =1";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            int[] _ids = new int[5];
            String _idsStr = "";
            while (rs.next()){
                _idsStr=rs.getString(ctype);
                System.out.println(_idsStr);
            }
            List<Pageinfo> list = new ArrayList<>();
            PageinfoDAO d = new PageinfoDAO();
            for(int i=0;i<_ids.length;i++){
                _ids[i]=Integer.parseInt(_idsStr.charAt(i)+"");
                Pageinfo p = d.fine(_ids[i]);
                list.add(p);
            }
            return list;
        }finally {
            if(rs!=null) rs.close();
            if(preStmt!=null) preStmt.close();
            if(conn!=null) conn.close();
        }
    }

}
