module org.example.intentocrud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.example.intentocrud to javafx.fxml;
    exports org.example.intentocrud;
}