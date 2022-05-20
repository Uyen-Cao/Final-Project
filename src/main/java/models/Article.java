package models;

import com.rometools.rome.feed.synd.SyndContent;

import java.util.Date;

public class Article {
    String article_id;
    String title;
    String lead;
    String thumbnail_url;
    Date publishedDate;
    public Article(String article_id, String title, String lead, String thumbnail_url, Date publishedDate){
        this.article_id = article_id;
        this.title = title;
        this.lead = lead;
        this.thumbnail_url = thumbnail_url;
        this.publishedDate = publishedDate;
    }

    public String getTitle(){
        return this.title;
    }

    public String getLead(){
        return this.lead;
    }

    public String getImage(){
        return this.thumbnail_url;
    }

    public Date getDate() { return this.publishedDate;}


}
