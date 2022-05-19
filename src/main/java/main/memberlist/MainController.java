package main.memberlist;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
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
    private Button goBackButton;

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
    private TabPane myTabPane;

    @FXML
    private ProgressBar progressBar;




    @FXML
    void handleButtonClick (ActionEvent event) throws Exception {
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
        button.setStyle("-fx-background-color: white;");
        renderArticles(presentArticleMethod.presentArticles(button.getText()), "1");
    }




    @Override
    public void initialize(URL location, ResourceBundle resources){

        myTabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            try {
                secondPage.getChildren().clear();
                renderArticles(presentArticleMethod.presentArticles(""), newTab.getText());
                System.out.println("123");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            renderArticles(presentArticleMethod.presentArticles(""), "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void renderArticles(List<Article> articleListAPI, String page){

        presentArticles = articleListAPI;
        int column = 0;
        int row = 1;
        System.out.println(page);


        try{
            if(page.equals("1")){
                secondPage.getChildren().clear();
                for(int i = 0; i < 10; i++){
                    System.out.println(i);
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                    Pane cardBox = null;
                    cardBox = fxmlLoader.load();
                    ArticleController articleController = fxmlLoader.getController();
                    articleController.setData(presentArticles.get(i));
                    if(column == 3){
                        column = 0;
                        ++row;
                    }
                    secondPage.add(cardBox, column++, row);
                }
            }else if(page.equals("2")) {
                secondPage.getChildren().clear();
                for (int i = 10; i < 20; i++) {
                    System.out.println(i);
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                    Pane cardBox = fxmlLoader.load();
                    ArticleController articleController = fxmlLoader.getController();
                    articleController.setData(presentArticles.get(i));
                    if (column == 3) {
                        column = 0;
                        ++row;
                    }
                    secondPage.add(cardBox, column++, row);
                }
            }
//            else if(page.equals("3")){
//                double k = 0.1;
//                thirdPage.getChildren().clear();
//                for(int i = 20; i < 30; i++){
//                    FXMLLoader fxmlLoader = new FXMLLoader();
//                    fxmlLoader.setLocation(getClass().getResource("article.fxml"));
//                    Pane cardBox = fxmlLoader.load();
//                    ArticleController articleController = fxmlLoader.getController();
//                    articleController.setData(presentArticles.get(i));
//
//                    if(column == 3){
//                        column = 0;
//                        ++row;
//                    }
//                    thirdPage.add(cardBox, column++, row);
//                    progressBar.setProgress(k);
//                    k += 0.1;
//                }
//                progressBar.setProgress(1);
//            } else if(page.equals("4")){
//                fourthPage.getChildren().clear();
//                for(int i = 30; i < 40; i++){
//                    FXMLLoader fxmlLoader = new FXMLLoader();
//                    fxmlLoader.setLocation(getClass().getResource("article.fxml"));
//                    Pane cardBox = fxmlLoader.load();
//                    ArticleController articleController = fxmlLoader.getController();
//                    articleController.setData(presentArticles.get(i));
//
//                    if(column == 3){
//                        column = 0;
//                        ++row;
//                    }
//                    fourthPage.add(cardBox, column++, row);
//                }
//            } else if(page.equals("5")){
//                fifthPage.getChildren().clear();
//                for(int i = 40; i < presentArticles.size(); i++){
//                    FXMLLoader fxmlLoader = new FXMLLoader();
//                    fxmlLoader.setLocation(getClass().getResource("article.fxml"));
//                    Pane cardBox = fxmlLoader.load();
//                    ArticleController articleController = fxmlLoader.getController();
//                    articleController.setData(presentArticles.get(i));
//
//                    if(column == 3){
//                        column = 0;
//                        ++row;
//                    }
//                    fifthPage.add(cardBox, column++, row);
//                }
//            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }



}