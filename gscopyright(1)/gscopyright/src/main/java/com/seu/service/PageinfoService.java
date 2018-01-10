package com.seu.service;

import com.seu.model.Pageinfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 */
@Service
public interface PageinfoService {
    Pageinfo getPageinfo(int _id);
    List<Pageinfo> getPageinfos(String ctype);
}
