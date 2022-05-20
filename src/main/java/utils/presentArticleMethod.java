package utils;

import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Item;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import models.Article;

import java.io.Closeable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class presentArticleMethod {
    public static List<Article> presentArticles(String url) throws Exception {
        List<Article> ls = new ArrayList<>();
        int count = 0;

        //String url = "https://vnexpress.net/rss/tin-moi-nhat.rss";
        URL feedUrl = new URL(url);

        String title = "", imgURL = "", source = "", content = "", dateHolder;
        Date pubDate;


        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        List<SyndEntry> entry = feed.getEntries();

//        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
//            System.out.println("-----------------------------");
//            System.out.println("Title : " + entry.getTitle());
//            System.out.println("Author: "+entry.getDescription().getValue());
//            String convertedURL = getURLInString(entry.getDescription().getValue());
//            System.out.println("Link URL  : "+convertedURL);
//            if(convertedURL == null){
//                convertedURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png";
//            }
//            System.out.println("Link  : "+entry.getLink());
//            Article newArticle = new Article("123", entry.getTitle(), entry.getUri(), convertedURL);
//            ls.add(newArticle);
//
//        }

        for (int i = 0; i < 10; i++) {
            title = entry.get(i).getTitle();
            source = entry.get(i).getLink();
            pubDate = entry.get(i).getPublishedDate();

            Document document1 = Jsoup.connect(source).get();
            Elements elements1 = document1.select("description");






            System.out.println("-----------------------------");
            System.out.println("pubDate : " + pubDate);


            System.out.println("Title : " + title);

            //System.out.println("img Link: "+entry.get(i).getDescription().getValue());

            Pattern pattern = Pattern.compile("src=(?:\\\"|\\')?(?<imgSrc>[^>]*[^/].(?:jpg|bmp|gif|png))(?:\\\"|\\')?");
            Matcher matcher = pattern.matcher(entry.get(i).getDescription().getValue());
            while (matcher.find()){
                imgURL = matcher.group(1);
                System.out.println("img URL : " + imgURL);
            }

            if (source.matches("(.*)vnexpress.net(.*)")){
                imgURL = getURLInString(entry.get(i).getDescription().getValue());
                System.out.println("img URL : " + imgURL);
            }

            if(imgURL == "" || imgURL == null){
                imgURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png";
            }


            //System.out.println("Date  : "+ pubDate.toString());



//            String convertedURL = getURLInString(entry.get(i).getDescription().getValue());
//            System.out.println("Link URL  : "+convertedURL);
//            if(convertedURL == null){
//                convertedURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png";
//            }
            System.out.println("Link  : "+ source);

            Document document = Jsoup.connect(source).get();
            Elements elements = new Elements();


            System.out.println("Content  : ");

            if (entry.get(i).getLink().matches("(.*)vnexpress.net(.*)")){
                elements = document.select("p");
                for (Element e : elements) {
                    content = e.text();
                    System.out.println(content);
                }
            }
            else {
                elements = document.select("p:not([class]), p[class=\"\"]");
                for (Element e : elements) {
                    content = e.text();
                    System.out.println(content);
                }
            }

            Article newArticle = new Article();

            if (pubDate != null){
                newArticle = new Article(title, source, imgURL, content, pubDate);

            }
            else {
                newArticle = new Article(title, source, imgURL, content);
            }

            System.out.println("Time Passed  : "+ newArticle.getTimePassed());

            System.out.println(newArticle.getContent());

            //Article newArticle = new Article("123", entry.get(i).getTitle(), entry.get(i).getUri(), "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png", elements.text());
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
