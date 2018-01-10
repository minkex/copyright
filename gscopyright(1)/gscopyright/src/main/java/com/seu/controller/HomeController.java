package com.seu.controller;

import com.seu.model.Pageinfo;
import com.seu.model.Recommendation;
import com.seu.service.CopyrightSearchService;
import com.seu.service.PageinfoService;
import com.seu.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by SUN on 2017.12.21.
 */
@Controller
@RequestMapping("/copyright")
public class HomeController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(UpLoadController.class);
    private RecommendService recommendService;//业务的依赖
    private PageinfoService pageinfoService;
    private CopyrightSearchService copyrightSearchService;

    @Autowired
    public void setCopyrightSearchService(CopyrightSearchService copyrightSearchService) {
        this.copyrightSearchService = copyrightSearchService;
    }
    @Autowired
    public void setRecommendService(RecommendService recommendService){
        this.recommendService=recommendService;
    }
    @Autowired
    public void setPageinfoService(PageinfoService pageinfoService){
        this.pageinfoService=pageinfoService;
    }

    //映射一个action
    @RequestMapping("/home")
    public  String index(Map<String, Object> model){
        //输出日志文件
        logger.info("home pages");
        Recommendation recommendation = recommendService.getRecommendation();
        model.put("recommendation",recommendation);
        List<Pageinfo> pageinfos = pageinfoService.getPageinfos("");
        model.put("pageinfos",pageinfos);
        return "home";
    }

    //详情页 /copyright/details/123
    @RequestMapping("/details/{_id}")//将变量绑定到注解的同名参数上
    public String viewCourse2(@PathVariable("_id") Integer _id,
                              Map<String, Object> model) throws Exception {

        logger.debug("显示详情", _id);
        Pageinfo pageinfo = pageinfoService.getPageinfo(_id);
        Recommendation recommendation = recommendService.getRecommendation();
        model.put("pageinfo", pageinfo);
        model.put("recommendation",recommendation);
        return "detailsPage";
    }

    //首页类别查看 /copyright/home/类型
    @RequestMapping("/home/{ctype}")
    public String index(@PathVariable("ctype")String ctype, Map<String, Object> model){
        //输出日志文件
        logger.info("ctype pages");
        Recommendation recommendation = recommendService.getRecommendation();
        model.put("recommendation",recommendation);
        List<Pageinfo> pageinfos = pageinfoService.getPageinfos(ctype);
        model.put("pageinfos",pageinfos);
        return "home";
    }

    //版权检索页 /copyright/copyrightSearch?pageNum=123
    @RequestMapping("/copyrightSearch")
    public String copyrightSearch(@RequestParam("pageNum")String pageNum, HttpServletRequest request,
                                  Map<String, Object> model)throws SQLException {
        logger.info("copyrightSearch pages");
        System.err.println(request.getRequestURI());
        List<Pageinfo> pageinfos = copyrightSearchService.showPageinfoList(Integer.valueOf(pageNum));
        String pagination = copyrightSearchService.pagination(Integer.valueOf(pageNum),request.getRequestURI());
        model.put("pageinfos",pageinfos);
        model.put("pagination",pagination);
        return "copyrightSearch";
    }
}
