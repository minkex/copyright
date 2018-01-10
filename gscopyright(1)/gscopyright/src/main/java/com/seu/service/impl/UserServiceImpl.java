package com.seu.service.impl;

import com.seu.dao.PageinfoDAO;
import com.seu.dao.UserInfoDAO;
import com.seu.dao.UserTransactionDAO;
import com.seu.model.Pageinfo;
import com.seu.service.UserService;
import com.seu.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoDAO userInfoDAO;
    @Autowired
    private UserTransactionDAO transactionDAO;
    @Autowired
    public PageinfoDAO pageinfoDAO;

    @Override
    public boolean login(String username, String passwd) {
        try {
            if (passwd.equals(userInfoDAO.findPasswd(username)))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean loginmedia(String medianame,String password){
        try {
            if (password.equals(userInfoDAO.findmediaPasswd(medianame))){
                System.out.println("true");
                return true;
            }

            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean regist(String username, String pwd, String email, String sex) {
        try {
            if (userInfoDAO.findPasswd(username) == null) {
                userInfoDAO.add(username, pwd, email, sex);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String addItem(String user_id, String page_id) {
        try {
            if (transactionDAO.isExistList(user_id, "order_list", page_id)) {
                return "order0";
            }
            int state = transactionDAO.addList(user_id, "commodity_list", page_id);
            return "commodity" + state;
        } catch (Exception e) {
            e.printStackTrace();
            return "commodity-1";
        }
    }

    @Override
    public String buyItem(String user_id, String page_id) {
        try {
            if (transactionDAO.isExistList(user_id, "order_list", page_id)) {
                return "order0";
            }
            int state = transactionDAO.addList(user_id, "order_list", page_id);
            transactionDAO.deleteList(user_id, "commodity_list", page_id);//购买后从购物车删除
            return "order" + state;
        } catch (Exception e) {
            e.printStackTrace();
            return "order-1";
        }
    }

    //展示购物车和订单中的列表
    @Override
    public List<Pageinfo> showPageinfoList(int pageNum, String cartstr) throws SQLException {
        List<Pageinfo> list = pageinfoDAO.copyrightSearch(pageNum, cartstr);
        return list;
    }

    //分页
    @Override
    public String pagination(int pageNum, String pageUrl, String str) throws SQLException {
        final int pageSize = 7;    // 一页显示pageSize条记录
        int recordCount = pageinfoDAO.getCount("SELECT count(*) FROM pageinfo WHERE _id IN " + str);
        int pageCount = (recordCount + pageSize - 1) / pageSize;
        return Pagination.getPagination(pageNum, pageCount, recordCount, pageUrl);
    }

    @Override
    public String getCommdities(String user_id) throws Exception {
        String cartstr = "(";
        for (String s : transactionDAO.getCommodities(user_id)) {
            cartstr += s + ",";
        }
        if (cartstr.length() > 1)
            cartstr = cartstr.substring(0, cartstr.length() - 1);
        cartstr += ")";
        return cartstr;
    }

    @Override
    public String getOrders(String user_id) throws Exception {
        String orderStr = "(";
        for (String s : transactionDAO.getOrders(user_id)) {
            orderStr += s + ",";
        }
        if (orderStr.length() > 1)
            orderStr = orderStr.substring(0, orderStr.length() - 1);
        orderStr += ")";
        return orderStr;
    }

}
