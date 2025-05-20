module org.example.javafxviktoriinim2ng {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxviktoriinim2ng to javafx.fxml;
    exports org.example.javafxviktoriinim2ng;
}