package models;

import com.sun.syndication.feed.synd.SyndEntry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Article {

    private String title;
    private String source;
    private String thumbnail_url;
    private Date date;
    private String timePassed;
    private String content;


    public Article(String title, String source, String thumbnail_url, String content, Date date) {

//        title = input.getTitle();
//        URL = input.getLink();
//        this.category = category;
//        date = input.getPublishedDate().toString();

        this.title = title;
        this.source = source;
        this.thumbnail_url = thumbnail_url;
        this.date = date;
        this.content= content;

        Date currentDate = new Date();

        long diff = currentDate.getTime() - date.getTime();
        TimeUnit time = TimeUnit.MINUTES;
        long timeDiff = time.convert(diff, TimeUnit.MILLISECONDS);
        long hourDiff = (timeDiff - 1440*(timeDiff/1440))/60;
        long minuteDiff = timeDiff - 1440*(timeDiff/1440) - hourDiff*60;
        timePassed = (timeDiff/1440) + " days, " + hourDiff + " hours, " + minuteDiff + " minutes";
    }
    public Article(String title, String source, String thumbnail_url, String content) {
        this.title = title;
        this.source = source;
        this.thumbnail_url = thumbnail_url;
        this.date = null;
        this.timePassed = "Can not Retrieve Publication Date";
        this.content= content;
    }

    public Article(){
        this.title = null;
        this.source = null;
        this.thumbnail_url = null;
        this.date = null;
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
}
