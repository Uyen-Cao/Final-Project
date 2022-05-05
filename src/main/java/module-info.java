module main.memberlist {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires com.rometools.rome;


    opens main.memberlist to javafx.fxml;
    exports main.memberlist;
}