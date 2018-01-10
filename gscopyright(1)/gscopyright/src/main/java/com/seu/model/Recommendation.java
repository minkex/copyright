package com.seu.model;

import java.util.List;

/**
 * Created by SUN on 2017.12.21.
 */
public class Recommendation {
    private List<Pageinfo> rec_hot;
    private List<Pageinfo> rec_user;

    public List<Pageinfo> getRec_hot() {
        return rec_hot;
    }

    public void setRec_hot(List<Pageinfo> rec_hot) {
        this.rec_hot = rec_hot;
    }

    public List<Pageinfo> getRec_user() {
        return rec_user;
    }

    public void setRec_user(List<Pageinfo> rec_user) {
        this.rec_user = rec_user;
    }
}
