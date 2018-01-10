package com.seu.service;

import com.seu.model.Pageinfo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 */
@Service
public interface UserService {
    boolean login(String username,String passwd);
    boolean loginmedia(String medianame,String password);
    boolean logout();
    boolean regist(String username,String pwd,String email,String sex);
    String addItem(String user_id,String page_id);
    String buyItem(String user_id,String page_id);
    List<Pageinfo> showPageinfoList(int pageNum,String str) throws SQLException;
    String pagination(int pageNum, String pageUrl,String str) throws SQLException;
    String getCommdities(String user_id) throws Exception;
    String getOrders(String user_id) throws Exception;
}
