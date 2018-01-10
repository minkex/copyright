package com.seu.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by SUN on 2017.12.20.
 */
public class MultiFileDomain {
    private List<String> description;
    private List<MultipartFile> myfile;

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<MultipartFile> getMyfile() {
        return myfile;
    }

    public void setMyfile(List<MultipartFile> myfile) {
        this.myfile = myfile;
    }
}
