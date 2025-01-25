module org.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires fontawesomefx;

    requires java.sql;


    opens org.example.demo1 to javafx.fxml;
    opens org.example.demo1.chat to javafx.fxml;
    exports org.example.demo1;
    exports org.example.demo1.chat;
}