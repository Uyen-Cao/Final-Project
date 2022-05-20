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

    String[] newestRSS = {
            "https://tuoitre.vn/rss/tin-moi-nhat.rss",
            "https://vnexpress.net/rss/tin-moi-nhat.rss",
            "https://www.doisongphapluat.com/trang-chu.rss",
            "https://tienphong.vn/rss/home.rss",
            "https://vtc.vn/rss/feed.rss"
    };

//    String[] newestRSS = {
//            "https://vnexpress.net/rss/tin-moi-nhat.rss",
//            "https://tuoitre.vn/rss/tin-moi-nhat.rss",
//            "https://www.doisongphapluat.com/trang-chu.rss",
//            "https://www.doisongphapluat.com/trang-chu.rss",
//            "https://vtc.vn/rss/feed.rss"
//    };


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
//            Parent root = null;
//            try {
//                root = FXMLLoader.load(getClass().getResource("waiting-scene.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Scene newScene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(newScene);
//            stage.show();
            try {
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

            Task progressBarHandle = new Task() {
                @Override
                protected Object call() throws Exception {
                    for(int i = 0; i < 10; i++) {
                            System.out.println("Child Thread");
                            updateProgress(i+1, 10);
                            Thread.sleep(3000);

                    }
                    return null;
                }
            };
        progressBar.progressProperty().bind(progressBarHandle.progressProperty());
        new Thread(progressBarHandle).start();
        if(page.equals("1")){

            Task loadingArticle = new Task() {
                int column = 0;
                int row = 1;
                @Override
                protected Object call() throws Exception {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            firstPage.getChildren().clear();
                        }
                    });
                    for(int i = 0; i < 10; i++){
                        System.out.println(i);
                        int finalI = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                                Pane cardBox = null;
                                try {
                                    cardBox = fxmlLoader.load();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                ArticleController articleController = fxmlLoader.getController();
                                articleController.setData(presentArticles.get(finalI));
                                if(column == 5){
                                    column = 0;
                                    ++row;
                                }
                                firstPage.add(cardBox, column++, row);
                            }
                        });
                        Thread.sleep(3000);
                    }
                    return null;
                }
            };
            new Thread(loadingArticle).start();

        }else if(page.equals("2")) {

            Task loadingArticle = new Task() {
                int column = 0;
                int row = 1;
                @Override
                protected Object call() throws Exception {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            secondPage.getChildren().clear();
                        }
                    });
                    for(int i = 10; i < 20; i++){
                        System.out.println(i);
                        int finalI = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
                                Pane cardBox = null;
                                try {
                                    cardBox = fxmlLoader.load();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                ArticleController articleController = fxmlLoader.getController();
                                articleController.setData(presentArticles.get(finalI));
                                if(column == 5){
                                    column = 0;
                                    ++row;
                                }
                                secondPage.add(cardBox, column++, row);
                            }
                        });
                        Thread.sleep(3000);
                    }
                    return null;
                }
            };
            new Thread(loadingArticle).start();
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
    }
}
