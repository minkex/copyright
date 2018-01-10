package com.seu.model;

public class MediaDomain {
    private String medianame;
    private String username;
    private String IDnumber;
    private String registernumber;
    private String password;
    public void setMedianame(String medianame){
        this.medianame=medianame;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setIDnumber(String IDnumber){
        this.IDnumber=IDnumber;
    }
    public void setRegisternumber(String registernumber){
        this.registernumber=registernumber;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getMedianame(){
        return medianame;
    }
    public String getUsername(){
        return username;
    }
    public String getIDnumber(){
        return IDnumber;
    }
    public String getRegisternumber(){
        return registernumber;
    }
    public String getPassword(){
        return password;
    }
}
