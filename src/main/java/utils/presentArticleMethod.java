package utils;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import models.Article;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class presentArticleMethod {
    public static List<Article> presentArticles(String url, String category) throws Exception {
        // Initialize Variables to capture Data from RSS
        List<Article> ls = new ArrayList<>();
        String title = "", imgURL = "", source = "", content = "";
        Date pubDate;

        // Using rometools lib to fetch Data from RSS using SyndFeed
        URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        List<SyndEntry> entry = feed.getEntries();

        // Capture first 10 Articles from the RSS
        for (int i = 0; i < 10; i++) {
            // Reset content value each time an article is finished fetching
            content = "";

            // Get data from RSS item being handled
            title = entry.get(i).getTitle();
            source = entry.get(i).getLink();
            pubDate = entry.get(i).getPublishedDate();

            System.out.println("-----------------------------");

            // Using RegEx to fetch thumbnail image
            Pattern pattern = Pattern.compile("src=(?:\\\"|\\')?(?<imgSrc>[^>]*[^/].(?:jpg|bmp|gif|png))(?:\\\"|\\')?");
            Matcher matcher = pattern.matcher(entry.get(i).getDescription().getValue());
            while (matcher.find()){
                imgURL = matcher.group(1);
            }

            // fetch thumbnail image from vnexpress using another method
            if (source.matches("(.*)vnexpress.net(.*)")){
                imgURL = getURLInString(entry.get(i).getDescription().getValue());
            }

            // Handle when unable to fetch thumbnail image
            if(imgURL == "" || imgURL == null){
                imgURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png";
            }

            // Using Jsoup to get article content from html
            Document document = Jsoup.connect(source).get();
            Elements elements = new Elements();

            // Fetching <p> element from html as the article content
            if (source.matches("(.*)vnexpress.net(.*)") || source.matches("(.*)tienphong.vn(.*)")){
                elements = document.select("p");
                for (Element e : elements) {
                    content += e.text() + "\n";
                }
            }
            else {
                elements = document.select("p:not([class]), p[class=\"\"]");
                for (Element e : elements) {
                    content += e.text() + "\n";
                }
            }

            Article newArticle = new Article();

            if (pubDate != null){
                newArticle = new Article(title, source, imgURL, content, pubDate, category);
            }
            else {
                newArticle = new Article(title, source, imgURL, content, category);
            }

            ls.add(newArticle);
            System.out.println(newArticle.toString());
        }

        return ls;
    }

    // Function to handle thumbnail img specific for VnExpress
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
