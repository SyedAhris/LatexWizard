module com.example.latexwizard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.latexwizard to javafx.fxml;
    exports com.example.latexwizard;
}