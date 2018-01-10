package com.seu.service.impl;

import com.seu.dao.PageinfoDAO;
import com.seu.model.Pageinfo;
import com.seu.model.Recommendation;
import com.seu.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 */
@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private PageinfoDAO pageinfoDAO;
    public Recommendation getRecommendation(){
        Recommendation recommendation = new Recommendation();
        List<Pageinfo> rec_hot = new ArrayList<>();
        List<Pageinfo> rec_user = new ArrayList<>();
        for(int i=1;i<6;i++){
            Pageinfo p = null;
            try {
                p = pageinfoDAO.fine(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rec_hot.add(p);
        }
        for(int i=6;i<11;i++){
            Pageinfo p = null;
            try {
                p = pageinfoDAO.fine(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            rec_user.add(p);
        }
        recommendation.setRec_hot(rec_hot);
        recommendation.setRec_user(rec_user);
        return recommendation;
    }
}
