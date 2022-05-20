package main.memberlist;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Article;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class WaitingScene {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label articleTitle;

    private Article article;

}
