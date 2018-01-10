package com.seu.service.impl;

import com.seu.dao.PageinfoDAO;
import com.seu.model.Pageinfo;
import com.seu.service.CopyrightSearchService;
import com.seu.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by SUN on 2017.12.22.
 */
@Service("copyrightSearchService")
public class CopyrightSearchServiceImpl implements CopyrightSearchService {
    @Autowired
    public PageinfoDAO pageinfoDAO;

    public List<Pageinfo> showPageinfoList(int pageNum) throws SQLException {
        List<Pageinfo> list = pageinfoDAO.copyrightSearch(pageNum,"");
        return list;
    }

    public String pagination(int pageNum, String pageUrl) throws SQLException {
        final int pageSize = 15;    // 一页显示pageSize条记录
        int recordCount = pageinfoDAO.getCount("SELECT count(*) FROM pageinfo");
        int pageCount =( recordCount + pageSize - 1 ) / pageSize;;
        return Pagination.getPagination(pageNum,pageCount,recordCount,pageUrl);
    }

}
