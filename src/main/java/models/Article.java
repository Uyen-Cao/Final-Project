package models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.sun.javafx.css.FontFaceImpl.FontFaceSrcType.URL;

public class Article {

    private String title;
    private String source;
    private String thumbnail_url;
    private Date date;
    private String timePassed;
    private String content;
    private String category;



    public Article(String title, String source, String thumbnail_url, String content, Date date, String category) {

        this.title = title;
        this.source = source;
        this.thumbnail_url = thumbnail_url;
        this.date = date;
        this.content= content;
        this.category = category;

        Date currentDate = new Date();

        long diff = currentDate.getTime() - date.getTime();
        TimeUnit time = TimeUnit.MINUTES;
        long timeDiff = time.convert(diff, TimeUnit.MILLISECONDS);
        long hourDiff = (timeDiff - 1440*(timeDiff/1440))/60;
        long minuteDiff = timeDiff - 1440*(timeDiff/1440) - hourDiff*60;
        timePassed = (timeDiff/1440) + " days, " + hourDiff + " hours, " + minuteDiff + " minutes";
    }
    public Article(String title, String source, String thumbnail_url, String content, String category) {
        this.title = title;
        this.source = source;
        this.thumbnail_url = thumbnail_url;
        this.date = null;
        this.timePassed = "Can not Retrieve Publication Date";
        this.content= content;
        this.category = category;
    }

    public Article(){
        this.title = null;
        this.source = null;
        this.thumbnail_url = null;
        this.date = null;
    }

    @Override
    public String toString() {
        return "Date:      " + date +
                "\nTitle:     " + title +
                "\nlink:      " + source +
                "\nImg Link:  " + thumbnail_url +
                "\nTime Passed: " + timePassed +
                "\nContent:   " + content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(String timePassed) {
        this.timePassed = timePassed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
