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
import java.util.List;
import java.util.ResourceBundle;
import utils.presentArticleMethod;

import static javafx.application.Application.launch;


public class MainController implements Initializable {

    @FXML
    private GridPane fifthPage;

    @FXML
    private GridPane firstPage;

    @FXML
    private GridPane fourthPage;

    @FXML
    private GridPane secondPage;

    @FXML
    private GridPane seventhPage;

    @FXML
    private GridPane sixthPage;

    @FXML
    private GridPane thirdPage;
    @FXML
    private VBox btnCategories;

    private List<Article> presentArticles;

    @FXML
    private Button businessButton;

    @FXML
    void handleButtonClick (ActionEvent event){
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
//        renderArticles(presentArticleMethod.presentArticles(button.getText()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            renderArticles(presentArticleMethod.presentArticles());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //renderCategoriesButton();
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
            for(int i = 40; i < presentArticles.size(); i++){
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



}