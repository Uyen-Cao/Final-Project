module main.memberlist {
    requires javafx.controls;
    requires javafx.fxml;
    //requires json.simple;
    requires com.rometools.rome;
    requires org.jsoup;


    opens main to javafx.fxml;
    exports main;
}