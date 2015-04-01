package com.cheesecake.pojo;

import java.io.Serializable;

/**
 * Created by Ricardo Freire on 3/29/15.
 *
 * POJO that represents the Article read from the JSON.
 *
 */
public class ArticlePojo implements Serializable {

    private String title;
    private String content;
    private String authors;
    private String date;
    private String website;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
