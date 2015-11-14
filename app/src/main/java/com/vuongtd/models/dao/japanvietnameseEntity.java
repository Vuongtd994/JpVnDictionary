package com.vuongtd.models.dao;

/**
 * Created by vuongtd on 11/10/2015.
 */
public class japanvietnameseEntity {
    private int id;
    private String word;
    private String content;

    public japanvietnameseEntity(String content, int id, String word) {
        this.content = content;
        this.id = id;
        this.word = word;
    }

    public japanvietnameseEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
