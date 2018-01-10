package com.seu.controller;

import com.seu.model.FileDomain;
import com.seu.model.MultiFileDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2017.12.5.
 */
// 注解标注此类为springmvc的controller，url映射为"/home"
@Controller
@RequestMapping("/copyright")
public class UpLoadController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(UpLoadController.class);

    //映射一个action
    @RequestMapping("/upload")
    public  String index(){
        //输出日志文件
        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "upload";
    }

    @RequestMapping("/updown")
    public  String upload(){
        logger.info("上传页面");
        return "UpDownLoad/upload_download";
    }

    /**
     * 单文件上传
     * */
    @RequestMapping("/onefile")
    public  String oneFileUpload(@ModelAttribute FileDomain fileDomain,
                                 HttpServletRequest request){

        //设置文件路径
        String realpath = request.getServletContext().getRealPath("uploadfiles");
        String fileName = fileDomain.getMyfile().getOriginalFilename();
        File targetFile = new File(realpath,fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //上传
        try {
            fileDomain.getMyfile().transferTo(targetFile);
            logger.info("成功");
            System.out.println(realpath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "UpDownLoad/showOne";
    }

    /**
     * 多文件上传
     * */
    @RequestMapping("/multifile")
    public String multiFileUpload(@ModelAttribute MultiFileDomain multiFileDomain,
                                  HttpServletRequest request){
        String realpath = request.getServletContext().getRealPath("uploadfiles");
//        String fileName = fileDomain.getMyfile().getOriginalFilename();
        File targetDir = new File(realpath);
        if(!targetDir.exists()){
            targetDir.mkdirs();
        }
        List<MultipartFile> files = multiFileDomain.getMyfile();
        for(int i=0;i<files.size();i++){
            MultipartFile file = files.get(i);
            String fileName = file.getOriginalFilename();
            File targetFile = new File(realpath,fileName);
            //上传
            try {
                file.transferTo(targetFile);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "UpDownLoad/showMulti";
    }

    /**
     * 下载文件，show、down、toUTF8String
     * */
    //show
    @RequestMapping("showDownFiles")
    public String show(HttpServletRequest request,Model model){
        String realpath = request.getServletContext().getRealPath("uploadfiles");
        File dir = new File(realpath);
        File files[] = dir.listFiles();
        ArrayList<String> fileName = new ArrayList<>();
        for(int i=0;i<files.length;i++){
            fileName.add(files[i].getName());
        }
        model.addAttribute("files",fileName);
        return "UpDownLoad/showDownFiles";
    }

    //down
    @RequestMapping("down")
    public String down(@RequestParam String filename, HttpServletRequest request,
                       HttpServletResponse response){
        String aFilePath = null;
        FileInputStream in = null;
        ServletOutputStream out = null;
        try {
            System.out.println(filename);
            aFilePath=request.getServletContext().getRealPath("uploadfiles");
            response.setHeader("Content-Type","application/x-msdownload");
            response.setHeader("Content-Disposition",
                    "attachment;filename="+toUTF8String(filename));

            in=new FileInputStream(aFilePath+"\\"+filename);
            out=response.getOutputStream();
            out.flush();
            int aRead=0;
            byte[] b = new byte[1024];
            while ((aRead = in.read(b))!=-1&&in!=null){
                out.write(b,0,aRead);
            }
            out.flush();
            in.close();
            out.close();
        }catch (Throwable e){
            e.printStackTrace();
        }
        logger.info("下载成功");
        return null;
    }

    //toUTF8String
    public String toUTF8String(String str){
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for(int i=0;i<len;i++){
            char c = str.charAt(i);
            if(c>=0&&c<=255){
                sb.append(c);
            }else {
                byte b[];
                try {
                    b=Character.toString(c).getBytes("UTF-8");
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                    b=null;
                }
                for(int j=0;j<b.length;j++){
                    int k = b[j];
                    if(k<0){
                        k&=255;
                    }
                    sb.append("%"+Integer.toHexString(k).toUpperCase());
                }
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}