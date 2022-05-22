package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Article;

import java.io.IOException;

public class ArticleController {
    @FXML
    private ImageView articleImage;

    @FXML
    private Text date;

    @FXML
    private Text title;

    Article currentArticle;

    public void setData(Article article){
        Image image = new Image(article.getThumbnail_url());
        articleImage.setImage(image);
        title.setText(article.getTitle());
        if(article.getDate() == null){
            date.setText("Can not retrieve published date");
        }else{
            date.setText(article.getTimePassed());
        }


        if (article.getDate() == null){
            currentArticle = new Article(article.getTitle(), article.getSource(), article.getThumbnail_url(), article.getContent(), article.getCategory() );
        }
        else {
            currentArticle = new Article(article.getTitle(), article.getSource(), article.getThumbnail_url(), article.getContent(), article.getDate(), article.getCategory() );
        }

    }

    public void showDetail(MouseEvent event) throws IOException {

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
