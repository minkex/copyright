package com.seu.service;

import com.seu.model.Pageinfo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by SUN on 2017.12.22.
 */
@Service
public interface CopyrightSearchService {
    public List<Pageinfo> showPageinfoList(int pageNum) throws SQLException;

    public String pagination(int pageNum, String pageUrl) throws SQLException;

}
