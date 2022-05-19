package main.memberlist;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import models.Article;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import utils.presentArticleMethod;

import static javafx.application.Application.launch;


public class    MainController implements Initializable {

    @FXML
    private Button btnBusiness;

    @FXML
    private VBox btnCategories;

    @FXML
    private Button btnCovid;

    @FXML
    private Button btnHealth;

    @FXML
    private Button btnNews;

    @FXML
    private Button btnOther;

    @FXML
    private Button btnSport;

    @FXML
    private Button btnTech;

    @FXML
    private Button btnWorld;

    @FXML
    private GridPane firstPage;

    @FXML
    private GridPane secondPage;

    @FXML
    private GridPane thirdPage;

    @FXML
    private GridPane fourthPage;

    @FXML
    private GridPane fifthPage;


    private List<Article> presentArticles;

    @FXML
    private Button businessButton;

    @FXML
    void handleButtonClick (ActionEvent event){
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
//        renderArticles(presentArticleMethod.presentArticles(button.getText()));
    }

    String[] newestRSS = {
            "https://tuoitre.vn/rss/tin-moi-nhat.rss",
            "https://vnexpress.net/rss/tin-moi-nhat.rss",
            "https://www.doisongphapluat.com/trang-chu.rss",
            "https://tienphong.vn/rss/home.rss",
            "https://vtc.vn/rss/feed.rss"
    };


    String[] politicRSS = {
            "https://tuoitre.vn/rss/thoi-su.rss",
            "https://vnexpress.net/rss/thoi-su.rss",
            "https://www.doisongphapluat.com/rss/tin-tuc.rss",
            "https://tienphong.vn/rss/the-gioi-5.rss",
            "https://vtc.vn/rss/thoi-su.rss",
    };

    String[] businessRSS = {
            "https://tuoitre.vn/rss/kinh-doanh.rss",
            "https://vnexpress.net/rss/kinh-doanh.rss",
            "https://www.doisongphapluat.com/rss/kinh-doanh.rss",
            "https://tienphong.vn/rss/kinh-te-3.rss",
            "https://vtc.vn/rss/kinh-te.rss",
    };

    String[] techRSS = {
            "https://tuoitre.vn/rss/nhip-song-so.rss",
            "https://vnexpress.net/rss/khoa-hoc.rss",
            "https://www.doisongphapluat.com/rss/cong-nghe.rss",
            "https://tienphong.vn/rss/cong-nghe-khoa-hoc-46.rss",
            "https://vtc.vn/rss/khoa-hoc-cong-nghe.rss"
    };

    String[] healthRSS = {
            "https://tuoitre.vn/rss/suc-khoe.rss",
            "https://vnexpress.net/rss/suc-khoe.rss",
            "https://doisongphapluat.com/rss/y-te.rss",
            "https://tienphong.vn/rss/suc-khoe-210.rss",
            "https://vtc.vn/rss/suc-khoe.rss"
    };

    String[] sportRSS = {
            "https://tuoitre.vn/rss/the-thao.rss",
            "https://vnexpress.net/rss/the-thao.rss",
            "https://www.doisongphapluat.com/rss/the-thao.rss",
            "https://tienphong.vn/rss/the-thao-11.rss",
            "https://vtc.vn/rss/the-thao.rss"
    };

    String[] entertainmentRSS = {
            "https://tuoitre.vn/rss/giai-tri.rss",
            "https://vnexpress.net/rss/giai-tri.rss",
            "https://www.doisongphapluat.com/rss/giai-tri.rss",
            "https://tienphong.vn/rss/giai-tri-36.rss",
            "https://vtc.vn/rss/van-hoa-giai-tri.rss"
    };
    String[] worldRSS ={
            "https://tuoitre.vn/rss/the-gioi.rss",
            "https://vnexpress.net/rss/the-gioi.rss",
            "https://www.doisongphapluat.com/rss/tin-the-gioi.rss",
            "https://tienphong.vn/rss/the-gioi-5.rss",
            "https://vtc.vn/rss/the-gioi.rss"
    };

    @Override
    public void initialize(URL location, ResourceBundle resources){
        loadArticles(newestRSS);
    }

    public void loadArticles (String[] rssString){
        try {
            List<Article> newestArticles = new ArrayList<>();

            List<Article> temp = new ArrayList<>();

            for (int i = 0; i < 5  ; i++) {
                newestArticles.addAll(presentArticleMethod.presentArticles(rssString[i]));
            }

            for (Article display : newestArticles) {
                System.out.println(display.getTitle());
            }

            renderArticles(newestArticles);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void renderArticles(List<Article> articleListAPI){
        presentArticles = articleListAPI;
        int column = 0;
        int row = 1;

        try{

            //for(Article article: presentArticles){
            for(int i = 0; i < 10; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                Pane cardBox = fxmlLoader.load();
                ArticleController articleController = fxmlLoader.getController();
                articleController.setData(presentArticles.get(i));

                if(column == 3){
                    column = 0;
                    ++row;
                }
                firstPage.add(cardBox, column++, row);
            }
            for(int i = 10; i < 20; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                Pane cardBox = fxmlLoader.load();
                ArticleController articleController = fxmlLoader.getController();
                articleController.setData(presentArticles.get(i));

                if(column == 3){
                    column = 0;
                    ++row;
                }
                secondPage.add(cardBox, column++, row);
            }
            for(int i = 20; i < 30; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                Pane cardBox = fxmlLoader.load();
                ArticleController articleController = fxmlLoader.getController();
                articleController.setData(presentArticles.get(i));

                if(column == 3){
                    column = 0;
                    ++row;
                }
                thirdPage.add(cardBox, column++, row);
            }
            for(int i = 30; i < 40; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                Pane cardBox = fxmlLoader.load();
                ArticleController articleController = fxmlLoader.getController();
                articleController.setData(presentArticles.get(i));

                if(column == 3){
                    column = 0;
                    ++row;
                }
                fourthPage.add(cardBox, column++, row);
            }
            for(int i = 40; i < 50; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                Pane cardBox = fxmlLoader.load();
                ArticleController articleController = fxmlLoader.getController();
                articleController.setData(presentArticles.get(i));

                if(column == 3){
                    column = 0;
                    ++row;
                }
                fifthPage.add(cardBox, column++, row);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonBusinessClick(ActionEvent event) {
        clearPages();

        loadArticles(businessRSS);
    }


    @FXML
    void handleButtonSportClick(ActionEvent event) {
        clearPages();

        loadArticles(sportRSS);

    }

    @FXML
    void handleButtonCovidClick(ActionEvent event) {

    }

    @FXML
    void handleButtonHealthClick(ActionEvent event) {
        clearPages();

        loadArticles(healthRSS);
    }

    @FXML
    void handleButtonNewsClick(ActionEvent event) {
        clearPages();

        loadArticles(newestRSS);
    }

    @FXML
    void handleButtonOtherClick(ActionEvent event) {


    }

    @FXML
    void handleButtonTechClick(ActionEvent event) {
        clearPages();

        loadArticles(techRSS);
    }

    @FXML
    void handleButtonWorldClick(ActionEvent event) {
        clearPages();

        //btnWorld.setStyle("-fx-background-color: #ff1234; ");

        loadArticles(worldRSS);
    }

    public void clearPages(){
        firstPage.getChildren().clear();
        secondPage.getChildren().clear();
        thirdPage.getChildren().clear();
        fourthPage.getChildren().clear();
        fifthPage.getChildren().clear();
    }



}