package com.example.latexwizard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StartPageController {
    public Button next;
    public TextField title, subTitle, instructorName, semDate;
    public Label titleEmpty, subTitleEmpty, instructorNameEmpty, semDateEmpty;
    public final String emptyError = "*Required Field";

    public void nextHandler () throws IOException {
        boolean emptyCheck = true;
        if (title.getText().isEmpty()) {
            titleEmpty.setText(emptyError);
            emptyCheck = false;
        }
        if (subTitle.getText().isEmpty()) {
            subTitleEmpty.setText(emptyError);
            emptyCheck = false;
        }
        if (instructorName.getText().isEmpty()) {
            instructorNameEmpty.setText(emptyError);
            emptyCheck = false;
        }
        if (semDate.getText().isEmpty()) {
            semDateEmpty.setText(emptyError);
            emptyCheck = false;
        }
        if (emptyCheck) {
            HelloApplication.data.setTitle(title.getText());
            HelloApplication.data.setSubTitle(subTitle.getText());
            HelloApplication.data.setInstructorName(instructorName.getText());
            HelloApplication.data.setSemDate(semDate.getText());
            Parent root = FXMLLoader.load(HelloApplication.class.getResource("bodyPage.fxml"));
            Scene s = new Scene(root, 1200 , 700);
            s.getStylesheets().add("startPageStyles.css");
            Stage currStage =(Stage) next.getScene().getWindow();
            Stage newStage = new Stage();
            newStage.setTitle("Latex Wizard");
            newStage.setScene(s);
            currStage.close();
            newStage.show();
            newStage.setResizable(false);
        }
    }
}
