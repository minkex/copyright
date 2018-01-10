package com.seu.service.impl;

import com.seu.dao.PageinfoDAO;
import com.seu.model.Pageinfo;
import com.seu.service.PageinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 */
@Service("pageinfoService")
public class PageinfoServiceImpl implements PageinfoService {
    @Autowired
    private PageinfoDAO pageinfoDAO;
    @Override
    public Pageinfo getPageinfo(int _id) {
        Pageinfo pageinfo = null;
        try {
            pageinfo = pageinfoDAO.fine(_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageinfo;
    }

    @Override
    public List<Pageinfo> getPageinfos(String ctype) {
        List<Pageinfo> pageinfos=new ArrayList<>();
        try {
            pageinfos = pageinfoDAO.fineByCtype(ctype);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageinfos;
    }

}
