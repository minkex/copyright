package com.seu.dao;

import com.seu.model.Pageinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 */
@Repository
public class PageinfoDAO {
    private DBSetting dbSetting;

    @Autowired
    public void setDbSetting(DBSetting dbSetting) {
        this.dbSetting = dbSetting;
    }

    public DBSetting getDbSetting() {
        return dbSetting;
    }

    public Pageinfo fine(int _id) throws Exception {
        String sql = "select * from pageinfo where _id= ?";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, _id);
            rs = preStmt.executeQuery();
            if (rs.next()) {
                Pageinfo pageinfo = new Pageinfo();
                pageinfo.set_id(_id);
                pageinfo.setMg_id(rs.getString("mg_id"));
                pageinfo.setUrl(rs.getString("url"));
                pageinfo.setNewstime(rs.getString("newstime"));
                pageinfo.setType(rs.getString("type"));
                pageinfo.setTitle(rs.getString("title"));
                pageinfo.setAuthors(rs.getString("authors"));
                pageinfo.setEditor(rs.getString("editor"));
                pageinfo.setCopyright(rs.getString("copyright"));
                pageinfo.setSource(rs.getString("source"));
                pageinfo.setCtype(rs.getString("ctype"));
                pageinfo.setSubtype(rs.getString("subtype"));
                pageinfo.setKeywords(rs.getString("keywords"));
                pageinfo.setAbstract_(rs.getString("abstract"));
                pageinfo.setContent(rs.getString("content"));
                pageinfo.setCopyright_code(rs.getString("copyright_code"));
                return pageinfo;
            } else
                return null;
        } finally {
            if (rs != null) rs.close();
            if (preStmt != null) preStmt.close();
            if (conn != null) conn.close();
        }
    }

    public List<Pageinfo> fineByCtype(String ctype) throws Exception {
        if (ctype == null || ctype.equals(""))
            ctype = "allcates";//所有类别
        String sql = "select * from categorylist where _id =1";
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            int[] _ids = new int[5];
            String _idsStr = "";
            while (rs.next()) {
                _idsStr = rs.getString(ctype);
//                System.out.println(_idsStr);
            }
            List<Pageinfo> list = new ArrayList<>();
            for (int i = 0; i < _ids.length; i++) {
                _ids[i] = Integer.parseInt(_idsStr.split(",")[i].trim());
//                System.out.println(_ids[i]);
                Pageinfo p = fine(_ids[i]);
                list.add(p);
            }
            return list;
        } finally {
            if (rs != null) rs.close();
            if (preStmt != null) preStmt.close();
            if (conn != null) conn.close();
        }
    }

    //根据类别查找（未建立映射表，查询太慢）
//    public List<Pageinfo> fineByCtype(String ctype) throws Exception{
//        String sql,ctypeCH="";
//        if(ctype==null||ctype.equals(""))
//            sql = "select * from pageinfo order by _id DESC";
//        else{
//            switch (ctype){
//                case "politics":{ctypeCH="时政";break;}
//                case "finance":{ctypeCH="财经";break;}
//                case "local":{ctypeCH="地方";break;}
//                case "technology":{ctypeCH="科技";break;}
//                case "international":{ctypeCH="国际";break;}
//                case "car":{ctypeCH="汽车";break;}
//                case "taiwan":{ctypeCH="台湾";break;}
//                case "education":{ctypeCH="教育";break;}
//                case "sports":{ctypeCH="体育";break;}
//                case "HKM":{ctypeCH="港澳";break;}
//                case "health":{ctypeCH="健康";break;}
//                case "house":{ctypeCH="房产";break;}
//                case "energy":{ctypeCH="能源";break;}
//
//            }
//            sql = "select * from pageinfo where ctype= ? order by _id DESC";
//        }
//        Connection conn = null;
//        PreparedStatement preStmt = null;
//        ResultSet rs = null;
//        try {
//            conn = getConnection();
//            preStmt = conn.prepareStatement(sql);
//            if(ctype!=null&&!ctype.equals(""))
//                preStmt.setString(1,ctypeCH);
//            rs = preStmt.executeQuery();
//            List<Pageinfo> list = new ArrayList<>();
//            int i=5;
//            while (rs.next()&&i>0){
//                Pageinfo pageinfo = new Pageinfo();
//                pageinfo.set_id(rs.getInt("_id"));
//                pageinfo.setMg_id(rs.getString("mg_id"));
//                pageinfo.setUrl(rs.getString("url"));
//                pageinfo.setNewstime(rs.getString("time"));
//                pageinfo.setType(rs.getString("type"));
//                pageinfo.setTitle(rs.getString("title"));
//                pageinfo.setAuthors(rs.getString("authors"));
//                pageinfo.setEditor(rs.getString("editor"));
//                pageinfo.setCopyright(rs.getString("copyright"));
//                pageinfo.setSource(rs.getString("source"));
//                pageinfo.setCtype(rs.getString("ctype"));
//                pageinfo.setSubtype(rs.getString("subtype"));
//                pageinfo.setKeywords(rs.getString("keywords"));
//                pageinfo.setAbstract_(rs.getString("abstract"));
//                pageinfo.setContent(rs.getString("content"));
//                pageinfo.setCopyright_code(rs.getString("copyright_code"));
//                list.add(pageinfo);i--;
//            }
//            return list;
//        }finally {
//            if(rs!=null) rs.close();
//            if(preStmt!=null) preStmt.close();
//            if(conn!=null) conn.close();
//        }
//    }

    public int getCount(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = dbSetting.getConnection();
            stmt = conn.createStatement();
            System.err.println(sql);
            rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getInt(1);
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
    }

    public void setParams(PreparedStatement preStmt, Object... params)
            throws SQLException {

        if (params == null || params.length == 0)
            return;

        for (int i = 1; i <= params.length; i++) {
            Object param = params[i - 1];
            if (param == null) {
                preStmt.setNull(i, Types.NULL);
            } else if (param instanceof Integer) {
                preStmt.setInt(i, (Integer) param);
            } else if (param instanceof String) {
                preStmt.setString(i, (String) param);
            } else if (param instanceof Double) {
                preStmt.setDouble(i, (Double) param);
            } else if (param instanceof Long) {
                preStmt.setDouble(i, (Long) param);
            } else if (param instanceof Timestamp) {
                preStmt.setTimestamp(i, (Timestamp) param);
            } else if (param instanceof Boolean) {
                preStmt.setBoolean(i, (Boolean) param);
            } else if (param instanceof Date) {
                preStmt.setDate(i, (Date) param);
            }
        }
    }

    //分页查找用于copyrightSearch
    public List<Pageinfo> copyrightSearch(int pageNum,String cartstr) throws SQLException {
        final int pageSize = 15;    // 一页显示pageSize条记录
//        pageNum = 1; 			// 当前页数
//        int pageCount = 1;            // 总页数
//        int recordCount = 0;        // 总记录数

        String sql = null;

        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        List<Pageinfo> list = new ArrayList<>(pageSize);
        try {
//            sql = "SELECT count(*) FROM pageinfo ";
//            recordCount = getCount(sql);
//            // 计算总页数
//            pageCount = (recordCount + pageSize - 1) / pageSize;
            // 本页从 startRecord 行开始
            int startRecord = (pageNum - 1) * pageSize;

            if(cartstr.equals(""))
                // MySQL 使用limit实现分页
                sql = "SELECT * FROM pageinfo LIMIT ?, ? ";
            else
                //用户中心展示购物车和订单
                sql = "SELECT * FROM pageinfo WHERE _id IN " + cartstr + " LIMIT ?, ? ";

            System.err.println(sql);
            conn = dbSetting.getConnection();
            preStmt = conn.prepareStatement(sql);
            setParams(preStmt, startRecord, pageSize);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                Pageinfo p = new Pageinfo();
                p.setSource(rs.getString("source"));
                p.setCtype(rs.getString("ctype"));
                p.set_id(rs.getInt("_id"));
                p.setEditor(rs.getString("editor"));
                p.setNewstime(rs.getString("newstime"));
                p.setTitle(rs.getString("title"));
                list.add(p);
//                p.setUrl();
//                p.setType();
//                p.setAuthors();
//                p.setCopyright();
//                p.setSubtype();
//                p.setKeywords();
//                p.setAbstract_();
//                p.setContent();
//                p.setCopyright_code();
//                p.setCrawltime();
//                p.setHeat();
            }

        } catch (SQLException e) {
            System.err.println("执行SQL：" + sql + "时发生异常：" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (preStmt != null) preStmt.close();
            if (conn != null) conn.close();
        }
        return list;
    }


}
