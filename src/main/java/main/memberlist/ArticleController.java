package main.memberlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Article;

import java.io.IOException;
import java.util.Date;

public class ArticleController {
    @FXML
    private ImageView articleImage;

    @FXML
    private Text date;

    @FXML
    private Text title;

    Article currentArticle;

    public void setData(Article article){
        Image image = new Image(article.getImage());
        articleImage.setImage(image);
        title.setText(article.getTitle());
        date.setText(article.getDate().toString());
        currentArticle = new Article("", article.getTitle(), "", article.getImage(), article.getDate());
    }

    public void showDetail(MouseEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("detail-article.fxml"));
//        Parent root = loader.load();
//        DetailArticleController controller = loader.getController();
//        controller.getArticleDetail(currentArticle);
//        Scene newScene = new Scene(root, 600, 400);
//        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        window.setScene(newScene);
//        window.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("detail-article.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root, 600, 400);
        DetailArticleController controller = loader.getController();
        controller.getArticleDetail(currentArticle);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }
}
