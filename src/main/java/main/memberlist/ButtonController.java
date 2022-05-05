package main.memberlist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.Article;
import models.Category;
import utils.presentArticleMethod;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ButtonController {
    private List<Article> articleList;

    @FXML
    private Button category;

    @FXML
    private ImageView logo;

    public void setData(String categoryButton){
        String imageURL = "/images/"+ category +".png";
//        Image image = new Image(getClass().getResourceAsStream(imageURL));
        category.setText(categoryButton);
//        logo.setImage(image);
    }

    @FXML
    void handleButtonClick(ActionEvent event) {
//        articleList = new ArrayList<>(presentArticleMethod.presentArticles(category.getText()));
//        System.out.println(articleList);
//        int column = 0;
//        int row = 1;
//        try{
//            for(Article article: articleList){
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("article.fxml"));
//                Pane cardBox = fxmlLoader.load();
//                ArticleController articleController = fxmlLoader.getController();
//                articleController.setData(article);
//
//                if(column == 3) {
//                    column = 0;
//                    ++row;
//                }
//                //MainController.renderArticles(articleList);
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }

}
