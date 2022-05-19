package utils;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import models.Article;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class presentArticleMethod {
    public static List<Article> presentArticles(String category) throws Exception {
        List<Article> ls = new ArrayList<>();
        String url = null;
        if(category.equals("")){
            url = "https://vnexpress.net/rss/tin-moi-nhat.rss";
        }else if (category.equals("World")){
            url = "https://vnexpress.net/rss/the-gioi.rss";
        }else if(category.equals("Covid")){
            url = "https://vnexpress.net/rss/suc-khoe.rss";
        }else if(category.equals("Business")){
            url = "https://vnexpress.net/rss/kinh-doanh.rss";
        }else if(category.equals("Health")){
            url = "https://vnexpress.net/rss/suc-khoe.rss";
        }else if(category.equals("Sports")){
            url = "https://vnexpress.net/rss/the-thao.rss";
        }else if(category.equals("Technology")){
            url = "https://vnexpress.net/rss/khoa-hoc.rss";
        }


        URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
            System.out.println("-----------------------------");
            System.out.println("Title : " + entry.getTitle());
            System.out.println("Author: "+entry.getDescription().getValue());
            String convertedURL = getURLInString(entry.getDescription().getValue());
            System.out.println("Link URL  : "+convertedURL);
            if(convertedURL == null){
                convertedURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png";
            }
            System.out.println("Link  : "+entry.getLink());
            Article newArticle = new Article("123", entry.getTitle(), entry.getUri(), convertedURL);
            ls.add(newArticle);
        }
        return ls;
    }

    public static String getURLInString(String string){
        List<String> list = new ArrayList<>();
        String regexString =  "\"([^\"]*)\"";
        Pattern pattern = Pattern.compile(regexString,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            list.add(string.substring(matcher.start(0),matcher.end(0)));
        }
        for(int index = 0; index < list.size(); index++){
            if(index == 1){
                return list.get(index).replaceAll("\"", "");
            }
        }
        return null;
    }
}
