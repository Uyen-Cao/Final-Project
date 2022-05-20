module main.memberlist {
    requires javafx.controls;
    requires javafx.fxml;
    //requires json.simple;
    requires com.rometools.rome;
    requires org.jsoup;


    opens main.memberlist to javafx.fxml;
    exports main.memberlist;
}