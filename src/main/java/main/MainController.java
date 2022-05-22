package main;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private Button Business;

    @FXML
    private Button Covid;

    @FXML
    private Button Health;

    @FXML
    private Button Newest;

    @FXML
    private Button Politics;

    @FXML
    private Button Entertainment;

    @FXML
    private Button Others;

    @FXML
    private Button Sports;

    @FXML
    private Button Technology;

    @FXML
    private Button World;


    @FXML
    private GridPane fifthPage;

    @FXML
    private GridPane firstPage;

    @FXML
    private GridPane fourthPage;

    @FXML
    private GridPane secondPage;

    @FXML
    private GridPane thirdPage;

    private List<Article> presentArticles;

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

    String[] otherRSS ={
            "https://tuoitre.vn/rss/xe.rss",
            "https://vnexpress.net//rss/oto-xe-may.rss",
            "https://www.doisongphapluat.com/rss/the-gioi-xe.rss",
            "https://tienphong.vn/rss/xe-113.rss",
            "https://vtc.vn/rss/oto-xe-may.rss"
    };


    String currentCategoryChosen = "Newest";
    String currentPage = "1";

    @FXML
    void handleButtonClick (ActionEvent event) throws Exception {
        if(currentCategoryChosen.equals("Newest")){
            Newest.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("World")){
            World.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("Covid")){
            Covid.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("Business")){
            Business.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("Health")){
            Health.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("Sports")){
            Sports.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("Technology")){
            Technology.setStyle("-fx-background-color: #43afe3;");
        } else if(currentCategoryChosen.equals("Politics")){
            Politics.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("Entertainment")){
            Entertainment.setStyle("-fx-background-color: #43afe3;");
        }else if(currentCategoryChosen.equals("Others")){
            Others.setStyle("-fx-background-color: #43afe3;");
        }
        Button button = (Button) event.getSource();
        System.out.println(button.getText());
        button.setStyle("-fx-background-color: #3781a4;");
        currentCategoryChosen = button.getText();
        if(button.getText().equals("Newest")){
            renderArticles(presentArticleMethod.presentArticles(newestRSS[Integer.parseInt(currentPage) - 1], "Newest"), currentPage);
        }else if(button.getText().equals("World")){
            renderArticles(presentArticleMethod.presentArticles(worldRSS[Integer.parseInt(currentPage) - 1], "World"), currentPage);
        }else if(button.getText().equals("Covid")){
            renderArticles(presentArticleMethod.presentArticles(healthRSS[Integer.parseInt(currentPage) - 1], "Covid"), currentPage);
        }else if(button.getText().equals("Business")){
            renderArticles(presentArticleMethod.presentArticles(businessRSS[Integer.parseInt(currentPage)- 1], "Business"), currentPage);
        }else if(button.getText().equals("Health")){
            renderArticles(presentArticleMethod.presentArticles(healthRSS[Integer.parseInt(currentPage) - 1], "Health"), currentPage);
        }else if(button.getText().equals("Sports")){
            renderArticles(presentArticleMethod.presentArticles(sportRSS[Integer.parseInt(currentPage) - 1], "Sports"), currentPage);
        }else if(button.getText().equals("Technology")){
            renderArticles(presentArticleMethod.presentArticles(techRSS[Integer.parseInt(currentPage) - 1], "Technology"), currentPage);
        }else if(button.getText().equals("Politics")){
            renderArticles(presentArticleMethod.presentArticles(politicRSS[Integer.parseInt(currentPage) - 1], "Politics"), currentPage);
        } else if(button.getText().equals("Entertainment")){
            renderArticles(presentArticleMethod.presentArticles(entertainmentRSS[Integer.parseInt(currentPage) - 1], "Entertainment"), currentPage);
        }else if(button.getText().equals("Others")){
            renderArticles(presentArticleMethod.presentArticles(otherRSS[Integer.parseInt(currentPage) - 1], "Others"), currentPage);
        }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources){

        myTabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            currentPage = newTab.getText();
            try {
                if(currentCategoryChosen.equals("Newest")){
                    renderArticles(presentArticleMethod.presentArticles(newestRSS[Integer.parseInt(newTab.getText()) - 1],"Newest" ), newTab.getText());
                }else if(currentCategoryChosen.equals("World")){
                    renderArticles(presentArticleMethod.presentArticles(worldRSS[Integer.parseInt(newTab.getText())- 1], "World"), newTab.getText());
                }else if(currentCategoryChosen.equals("Covid")){
                    renderArticles(presentArticleMethod.presentArticles(healthRSS[Integer.parseInt(newTab.getText()) - 1], "Covid"), newTab.getText());
                } else if(currentCategoryChosen.equals("Business")){
                    renderArticles(presentArticleMethod.presentArticles(businessRSS[Integer.parseInt(newTab.getText()) - 1], "Business"), newTab.getText());
                }else if(currentCategoryChosen.equals("Health")){
                    renderArticles(presentArticleMethod.presentArticles(healthRSS[Integer.parseInt(newTab.getText()) - 1], "Health"), newTab.getText());
                }else if(currentCategoryChosen.equals("Sports")){
                    renderArticles(presentArticleMethod.presentArticles(sportRSS[Integer.parseInt(newTab.getText()) - 1], "Sports"), newTab.getText());
                }else if(currentCategoryChosen.equals("Politics")){
                    renderArticles(presentArticleMethod.presentArticles(politicRSS[Integer.parseInt(newTab.getText()) - 1], "Politics"), currentPage);
                } else if(currentCategoryChosen.equals("Entertainment")){
                    renderArticles(presentArticleMethod.presentArticles(entertainmentRSS[Integer.parseInt(newTab.getText()) - 1], "Entertainment"), currentPage);
                }else if(currentCategoryChosen.equals("Others")){
                    renderArticles(presentArticleMethod.presentArticles(otherRSS[Integer.parseInt(newTab.getText()) - 1], "Others"), currentPage);
                }  else if(currentCategoryChosen.equals("Technology")){
                renderArticles(presentArticleMethod.presentArticles(techRSS[Integer.parseInt(newTab.getText()) - 1], "Technology"), currentPage);
            }
        } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Newest.setStyle("-fx-background-color: #3781a4;");
            renderArticles(presentArticleMethod.presentArticles(newestRSS[1], "Newest"), "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void renderArticles(List<Article> articleListAPI, String page){

        presentArticles = articleListAPI;

        //Thread for progress bar
        Task progressBarHandle = new Task() {
                @Override
                protected Object call() throws Exception {
                    for(int i = 0; i < 10; i++) {
                            System.out.println("Child Thread");
                            updateProgress(i+1, 10);
                            Thread.sleep(3500);

                    }
                    return null;
                }
            };

        //Thread for rendering articles
        Task loadingArticle = new Task() {
            int column = 0;
            int row = 1;
            @Override
            protected Object call() throws Exception {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if(page.equals("1")){
                                firstPage.getChildren().clear();
                            }else if(page.equals("2")){
                                secondPage.getChildren().clear();
                            }else if(page.equals("3")){
                                thirdPage.getChildren().clear();
                            } else if(page.equals("4")){
                                fourthPage.getChildren().clear();
                            } else if(page.equals("5")){
                                fifthPage.getChildren().clear();
                            }

                        }
                    });
                    for (int i = 0; i < 10; i++) {
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
                                if (column == 4) {
                                    column = 0;
                                    ++row;
                                }
                                if(page.equals("1")){
                                    firstPage.add(cardBox, column++, row);
                                }else if(page.equals("2")){
                                    secondPage.add(cardBox, column++, row);
                                }else if(page.equals("3")){
                                    thirdPage.add(cardBox, column++, row);
                                } else if(page.equals("4")){
                                    fourthPage.add(cardBox, column++, row);
                                } else if(page.equals("5")){
                                    fifthPage.add(cardBox, column++, row);
                                }


                            }
                        });
                        Thread.sleep(3500);
                    }
                    return null;
                }
            };
            new Thread(loadingArticle).start();
            progressBar.progressProperty().bind(progressBarHandle.progressProperty());
            new Thread(progressBarHandle).start();
    }
}
