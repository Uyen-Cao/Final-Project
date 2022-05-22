package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Article;

import java.io.IOException;

public class DetailArticleController {
    @FXML
    private Text date;

    @FXML
    private Text lead;

    @FXML
    private ImageView thumbnail;

    @FXML
    private Text title;

    private Article article;

    public void getArticleDetail(Article currentArticle){
        article = currentArticle;
        title.setText(article.getTitle());
        Image image = new Image(article.getThumbnail_url());
        thumbnail.setImage(image);
        date.setText(article.getTimePassed());
        lead.setText(article.getContent());
        System.out.println(article.getContent());
    }

    public void handleGoBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene mainScene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
}
