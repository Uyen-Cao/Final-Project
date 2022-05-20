package main.memberlist;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import models.Article;

public class ArticleController {
    @FXML
    private ImageView articleImage;

    @FXML
    private Text content;

    @FXML
    private Text date;

    @FXML
    private Label title;

    public void setData(Article article){
        Image image = new Image(article.getThumbnail_url());
        articleImage.setImage(image);
        content.setText(article.getSource());
        title.setText(article.getTitle());
        date.setText(article.getTimePassed());
    }
}
