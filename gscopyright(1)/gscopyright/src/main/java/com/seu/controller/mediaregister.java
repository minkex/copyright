package com.seu.controller;


import com.seu.dao.UserInfoDAO;
import com.seu.model.MediaDomain;
import com.seu.model.UserTransactionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class mediaregister {
    private static final Logger logger = LoggerFactory.getLogger(UpLoadController.class);
    private UserTransactionInfo userTransactionInfo;
    @Autowired
    private UserInfoDAO userInfoDAO;

    @RequestMapping("/mediaregister")
    public  String registerPage(Map<String, Object> model){
        //输出日志文件
        logger.info("mediaregister pages");
        return "mediaregister";
    }
    @RequestMapping ("/mediaregister.do")
    public String regiser(MediaDomain mediaDomain, Model model, HttpSession session){
        String medianame=mediaDomain.getMedianame();
        String username=mediaDomain.getUsername();
        String idnumber=mediaDomain.getIDnumber();
        String registernumber=mediaDomain.getRegisternumber();
        String password=mediaDomain.getPassword();
        try{
            int id=userInfoDAO.findId();
            System.out.println(id);
            String mediacode="S"+String.valueOf(id-1);
            System.out.println(mediacode);
            userInfoDAO.add(medianame,username,idnumber,registernumber,password,mediacode);
            session.setAttribute("session_username",mediacode.substring(1));

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/copyright/home";
    }
}
