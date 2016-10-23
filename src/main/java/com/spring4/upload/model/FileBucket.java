package com.spring4.upload.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by thangnguyen-imac on 10/23/16.
 */
public class FileBucket {

    private MultipartFile file;

    private String name;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
