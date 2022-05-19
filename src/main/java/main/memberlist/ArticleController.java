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
    private Text title;

    public void setData(Article article){
        Image image = new Image(article.getImage());
        articleImage.setImage(image);
        //content.setText(article.getLead());
        title.setText(article.getTitle());
        //content.setText(article.getLead());
    }
}
