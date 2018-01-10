package com.seu.model;

/**
 * Created by SUN on 2017.12.21.
 */
public class UserTransactionInfo {
    private String user_id="";
    private String commodity_list="";
    private String collection_list="";
    private String order_list="";

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCommodity_list() {
        return commodity_list;
    }

    public void setCommodity_list(String commodity_list) {
        this.commodity_list = commodity_list;
    }

    public String getCollection_list() {
        return collection_list;
    }

    public void setCollection_list(String collection_list) {
        this.collection_list = collection_list;
    }

    public String getOrder_list() {
        return order_list;
    }

    public void setOrder_list(String order_list) {
        this.order_list = order_list;
    }
}
