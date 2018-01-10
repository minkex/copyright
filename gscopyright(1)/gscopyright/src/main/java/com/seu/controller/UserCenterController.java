package com.seu.controller;

import com.seu.dao.UserInfoDAO;
import com.seu.model.Pageinfo;
import com.seu.model.Recommendation;
import com.seu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by SUN on 2017.12.21.
 */
@Controller
@RequestMapping("/usercenter")
public class UserCenterController {
    private static final Logger logger = LoggerFactory.getLogger(UpLoadController.class);
    @Autowired
    private UserInfoDAO userInfoDAO;
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/register")
    public  String registerPage(Map<String, Object> model){
        //输出日志文件
        logger.info("register pages");
        return "register";
    }

    @RequestMapping("/register.do")
    public  String regist(HttpServletRequest request, HttpSession session){
        //输出日志文件
        logger.info("register.do");
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String emailmatch="^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        if(email.matches(emailmatch)&&userService.regist(username,pwd,email,sex)){
            session.setAttribute("session_username",username);
            return "redirect:/copyright/home";
        }else {
            return "register";
        }
    }

    @RequestMapping("/login")
    public  String loginPage(Map<String, Object> model){
        //输出日志文件
        logger.info("login pages");
        return "login";
    }

    @RequestMapping("/login.do")
    public  String login(HttpServletRequest request, HttpSession session){
        //输出日志文件
        logger.info("login.do");
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");
        String usertype=request.getParameter("usertype");
        System.out.println(usertype);
        String code=session.getAttribute("code").toString().toLowerCase();
        if(usertype.equals("u")) {
            if (userService.login(username, passwd) && request.getParameter("vcode").toLowerCase().equals(code)) {
                session.setAttribute("session_username", username);
                return "redirect:/copyright/home";
            } else {
                return "login";
            }
        }
        else {
           if(userService.loginmedia(username,passwd) && request.getParameter("vcode").toLowerCase().equals(code)){
               try {
                   String id=userInfoDAO.getID(username);
                   session.setAttribute("session_username", id);
               }catch (Exception e){
                   e.printStackTrace();
               }
               return "redirect:/copyright/home";
           }else {
               return "login";
           }
        }
    }

    @RequestMapping("/logou")
    public  String logout(HttpSession session){
        //输出日志文件
        logger.info("logou");
        session.invalidate();
        return "redirect:/copyright/home";
    }

    @RequestMapping("/addItem")
    public  String addItem(HttpServletRequest request,HttpSession session){
        //输出日志文件
        logger.info("addItem");
        String page_id=request.getParameter("_id");
        String user_id=(String)request.getSession().getAttribute("session_username");
        if(user_id==null||user_id.equals(""))
            return "login";
        String state=userService.addItem(user_id,page_id);
        session.setAttribute("addCart_state",state);
        return "redirect:/copyright/details/"+page_id;
    }

    @RequestMapping("/buyItem")
    public  String buyItem(HttpServletRequest request,HttpSession session){
        //输出日志文件
        logger.info("buyItem");
        String page_id=request.getParameter("_id");
        String user_id=(String)request.getSession().getAttribute("session_username");
        if(user_id==null||user_id.equals(""))
            return "login";
        String state=userService.buyItem(user_id,page_id);
        session.setAttribute("addCart_state",state);
        return "redirect:/copyright/details/"+page_id;
    }

    @RequestMapping("/myCenter")
    public  String userSenter()
            throws Exception {
        //输出日志文件
        logger.info("myCenter");
        return "/userCenter";
    }

    @RequestMapping("/userCart")
    public  String userCart(@RequestParam("cart")String cartNum,
                              HttpServletRequest request,Map<String, Object> model,HttpSession session)
            throws Exception {
        //输出日志文件
        logger.info("userCart");
        String user_id = (String)session.getAttribute("session_username");
        String cartStr = userService.getCommdities(user_id);
        request.setAttribute("cartOrOrder","cart");
        if(!cartStr.equals("()")){
            List<Pageinfo> cartList = userService.showPageinfoList(Integer.valueOf(cartNum),cartStr);
            String cartPagination = userService.pagination(Integer.valueOf(cartNum),request.getRequestURI(),cartStr);
            model.put("cartList",cartList);
            model.put("cartPagination",cartPagination);
        }
        return "/userCartAndOrder";
    }

    @RequestMapping("/userOrder")
    public  String userOrder(@RequestParam("order")String orderNum,
                              HttpServletRequest request,Map<String, Object> model,HttpSession session)
            throws Exception {
        //输出日志文件
        logger.info("userOrder");
        String user_id = (String)session.getAttribute("session_username");
        String orderStr = userService.getOrders(user_id);
        request.setAttribute("cartOrOrder","order");
        if(!orderStr.equals("()")) {
            List<Pageinfo> orderList = userService.showPageinfoList(Integer.valueOf(orderNum), orderStr);
            String orderPagination = userService.pagination(Integer.valueOf(orderNum), request.getRequestURI(), orderStr);
            model.put("orderList", orderList);
            model.put("orderPagination", orderPagination);
        }
        return "/userCartAndOrder";
    }
}
