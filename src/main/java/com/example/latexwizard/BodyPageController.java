package com.example.latexwizard;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Watchable;
import java.util.Locale;

public class BodyPageController {

    public Button section, subsection, code, path, list, back, create, vspace, rightArrow;
    public TextArea body;

    public void sectionHandler () {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);
        layout.setPadding(new Insets(15));
        Label sectionNameLabel = new Label("Section Name:");
        TextField sectionName = new TextField();
        sectionName.setPrefHeight(300);
        sectionName.setPrefHeight(40);
        sectionName.setPromptText("Enter Section Name");
        Button add = new Button("Add");
        add.setPrefHeight(35);
        add.setPrefWidth(150);
        Button back = new Button("Back");
        back.setPrefHeight(35);
        back.setPrefWidth(150);
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(15));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back , add);
        layout.getChildren().addAll(sectionNameLabel, sectionName, buttons);
        Scene sectionScene = new Scene(layout, 300, 200);
        sectionScene.getStylesheets().add("style.css");
        Stage sectionWindow = new Stage();
        sectionWindow.setTitle("Add Section");
        sectionWindow.setScene(sectionScene);
        sectionWindow.show();

        add.setOnAction(e->{
           body.setText(body.getText() + "\n \\section{" + sectionName.getText() + "}");
            sectionWindow.close();
        });
        back.setOnAction(l->{
            sectionWindow.close();
        });

    }
    public void subsectionHandler () {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);
        layout.setPadding(new Insets(15));
        Label subsectionNameLabel = new Label("Subsection Name:");
        TextField subsectionName = new TextField();
        subsectionName.setPrefHeight(300);
        subsectionName.setPrefHeight(40);
        subsectionName.setPromptText("Enter Subsection Name");
        Button add = new Button("Add");
        add.setPrefHeight(35);
        add.setPrefWidth(150);
        Button back = new Button("Back");
        back.setPrefHeight(35);
        back.setPrefWidth(150);
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(15));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back , add);
        layout.getChildren().addAll(subsectionNameLabel, subsectionName, buttons);
        Scene subsectionScene = new Scene(layout, 300, 200);
        subsectionScene.getStylesheets().add("style.css");
        Stage subsectionWindow = new Stage();
        subsectionWindow.setTitle("Add Subsection");
        subsectionWindow.setScene(subsectionScene);
        subsectionWindow.show();

        add.setOnAction(e->{
            body.setText(body.getText() + "\n \\subsection{" + subsectionName.getText() + "}");
            subsectionWindow.close();
        });
        back.setOnAction(l->{
            subsectionWindow.close();
        });
    }
    public void codeHandler() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);
        layout.setPadding(new Insets(15));
        Label codeLabel = new Label("Code:");
        Label codeNameLabel = new Label("Code Caption:");
        TextArea code = new TextArea();
        code.setPrefHeight(300);
        code.setPrefHeight(300);
        code.setPromptText("Enter Code");
        TextField codeName = new TextField();
        codeName.setPrefHeight(300);
        codeName.setPrefHeight(300);
        codeName.setPromptText("Enter Code Caption");
        Button add = new Button("Add");
        add.setPrefHeight(35);
        add.setPrefWidth(150);
        Button back = new Button("Back");
        back.setPrefHeight(35);
        back.setPrefWidth(150);
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(15));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back , add);
        layout.getChildren().addAll(codeNameLabel, codeName, codeLabel, code, buttons);
        Scene codeScene = new Scene(layout, 300, 300);
        codeScene.getStylesheets().add("style.css");
        Stage codeWindow = new Stage();
        codeWindow.setTitle("Add Code");
        codeWindow.setScene(codeScene);
        codeWindow.show();

        add.setOnAction(e->{
            body.setText(body.getText() + "\n\\begin{lstlisting}[language=Java]%, caption=" + codeName.getText() +"] \n\n" + code.getText() + "\n\n\\end{lstlisting}");
            codeWindow.close();
        });
        back.setOnAction(p->{
            codeWindow.close();
        });
    }
    public void pathHandler() {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);
        layout.setPadding(new Insets(15));
        Label pathLabel = new Label("Path: ");
        TextField path = new TextField();
        path.setPrefHeight(300);
        path.setPrefHeight(40);
        path.setPromptText("Enter Path");
        Button add = new Button("Add");
        add.setPrefHeight(35);
        add.setPrefWidth(150);
        Button back = new Button("Back");
        back.setPrefHeight(35);
        back.setPrefWidth(150);
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(15));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back , add);
        layout.getChildren().addAll(pathLabel, path, buttons);
        Scene pathScene = new Scene(layout, 300, 200);
        pathScene.getStylesheets().add("style.css");
        Stage pathWindow = new Stage();
        pathWindow.setTitle("Add Path");
        pathWindow.setScene(pathScene);
        pathWindow.show();

        add.setOnAction(e->{
            body.setText(body.getText() + "\n" + "\\path{" + path.getText() + "}\n");
            pathWindow.close();
        });
        back.setOnAction(l->{
            pathWindow.close();
        });
    }
    public void listHandler () {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);
        layout.setPadding(new Insets(15));
        Label noOfListLabel = new Label("Number of List Items: ");
        TextField noOfList = new TextField();
        noOfList.setPrefHeight(300);
        noOfList.setPrefHeight(40);
        noOfList.setPromptText("Enter Number of List Items");
        Button next = new Button("Next");
        next.setPrefHeight(35);
        next.setPrefWidth(150);
        Button back = new Button("Back");
        back.setPrefHeight(35);
        back.setPrefWidth(150);
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(15));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back , next);
        layout.getChildren().addAll(noOfListLabel, noOfList, buttons);
        Scene noOfListScene = new Scene(layout, 300, 200);
        noOfListScene.getStylesheets().add("style.css");
        Stage noOfListWindow = new Stage();
        noOfListWindow.setTitle("Add List");
        noOfListWindow.setScene(noOfListScene);
        noOfListWindow.show();

        next.setOnAction(e->{
            int items = Integer.parseInt(noOfList.getText());
            ScrollPane addListlayout = new ScrollPane();
            addListlayout.setFitToHeight(true);
            addListlayout.setFitToWidth(true);
            VBox allRows = new VBox();
            allRows.setAlignment(Pos.CENTER);
            TextArea[] listItems = new TextArea[items];
            Button[] addCodes = new Button[items];
            Button[] addPaths = new Button[items];
            for (int i = 0; i < items; i++) {
                HBox oneField = new HBox();
                oneField.setAlignment(Pos.CENTER);
                TextArea list = new TextArea();
                list.prefHeight(50);
                list.maxHeight(50);
                list.minHeight(50);
                Button addCode = new Button("+ Code");
                addCode.getStyleClass().add("empty");
                addCode.setPrefWidth(100);
                addCode.setPrefHeight(35);
                addCode.setOnAction(o->{
                    VBox layoutlistCode = new VBox();
                    layoutlistCode.setAlignment(Pos.CENTER);
                    layoutlistCode.setSpacing(15);
                    layoutlistCode.setPadding(new Insets(15));
                    Label codeLabel = new Label("Code:");
                    Label codeNameLabel = new Label("Code Caption:");
                    TextArea code = new TextArea();
                    code.setPrefHeight(300);
                    code.setPrefHeight(300);
                    code.setPromptText("Enter Code");
                    TextField codeName = new TextField();
                    codeName.setPrefHeight(300);
                    codeName.setPrefHeight(300);
                    codeName.setPromptText("Enter Code Caption");
                    Button add = new Button("Add");
                    add.setPrefHeight(35);
                    add.setPrefWidth(150);

                    layoutlistCode.getChildren().addAll(codeNameLabel, codeName, codeLabel, code, add);
                    Scene codeScene = new Scene(layoutlistCode, 300, 200);
                    codeScene.getStylesheets().add("style.css");
                    Stage codeWindow = new Stage();
                    codeWindow.setTitle("Add Code");
                    codeWindow.setScene(codeScene);
                    codeWindow.show();

                    add.setOnAction(k->{
                        list.setText(list.getText() + "\n\\begin{lstlisting}[language=Java]%, caption=" + codeName.getText() +"] \n\n" + code.getText() + "\n\n\\end{lstlisting}");
                        list.requestFocus();
                        list.end();
                        codeWindow.close();
                    });
                });
                Button addPath = new Button("+ Path");
                addPath.getStyleClass().add("empty");
                addPath.setPrefWidth(100);
                addPath.setPrefHeight(35);
                addPath.setOnAction(j->{
                    VBox layoutListPath = new VBox();
                    layoutListPath.setAlignment(Pos.CENTER);
                    layoutListPath.setSpacing(15);
                    layoutListPath.setPadding(new Insets(15));
                    Label pathLabel = new Label("Path: ");
                    TextField path = new TextField();
                    path.setPrefHeight(300);
                    path.setPrefHeight(40);
                    path.setPromptText("Enter Path");
                    Button add = new Button("Add");
                    add.setPrefHeight(35);
                    add.setPrefWidth(150);

                    layoutListPath.getChildren().addAll(pathLabel, path, add);
                    Scene pathScene = new Scene(layoutListPath, 300, 200);
                    pathScene.getStylesheets().add("style.css");
                    Stage pathWindow = new Stage();
                    pathWindow.setTitle("Add Path");
                    pathWindow.setScene(pathScene);
                    pathWindow.show();

                    add.setOnAction(f->{
                        list.setText(list.getText() + "\n" + "\\path{" + path.getText() + "}\n");
                        list.requestFocus();
                        list.end();
                        pathWindow.close();
                    });
                });
                Button addRightArrow = new Button("+ Right Arrow");
                addRightArrow.getStyleClass().add("empty");
                addRightArrow.setPrefWidth(100);
                addRightArrow.setPrefHeight(35);
                addRightArrow.setOnAction(ew->{
                    list.setText(list.getText() + "$\\Rightarrow$");
                    list.requestFocus();
                    list.end();
                });
                Button addVspace = new Button("+ Vspace");
                addVspace.getStyleClass().add("empty");
                addVspace.setPrefWidth(100);
                addVspace.setPrefHeight(35);
                addVspace.setOnAction(po->{
                    VBox layoutVspaceAdd = new VBox();
                    layoutVspaceAdd.setAlignment(Pos.CENTER);
                    layoutVspaceAdd.setSpacing(15);
                    layoutVspaceAdd.setPadding(new Insets(15));
                    Label valueLabel = new Label("Value: ");
                    TextField value = new TextField();
                    value.setPrefHeight(300);
                    value.setPrefHeight(40);
                    value.setPromptText("Enter Value");
                    Button add = new Button("Add");
                    add.setPrefHeight(35);
                    add.setPrefWidth(150);
                    Button back2 = new Button("Back");
                    back2.setPrefHeight(35);
                    back2.setPrefWidth(150);
                    HBox buttons2 = new HBox();
                    buttons2.setSpacing(15);
                    buttons2.setPadding(new Insets(15));
                    buttons2.setAlignment(Pos.CENTER);
                    buttons2.getChildren().addAll(back2 , add);
                    layoutVspaceAdd.getChildren().addAll(valueLabel, value, buttons2);
                    Scene vspaceScene = new Scene(layoutVspaceAdd, 300, 200);
                    vspaceScene.getStylesheets().add("style.css");
                    Stage vspaceWindow = new Stage();
                    vspaceWindow.setTitle("Add Path");
                    vspaceWindow.setScene(vspaceScene);
                    vspaceWindow.show();

                    add.setOnAction(qw->{
                        list.setText(list.getText() + "\n\\vspace{" + value.getText() + "}\n");
                        list.requestFocus();
                        list.end();
                        vspaceWindow.close();
                    });

                    back.setOnAction(k->{
                        vspaceWindow.close();
                    });
                });
                oneField.getChildren().addAll(list, addCode, addPath, addRightArrow, addVspace);
                oneField.setSpacing(10);
                oneField.setPadding(new Insets(15));
                listItems[i] = list;
                addCodes[i] = addCode;
                addPaths[i] = addPath;
                allRows.getChildren().add(oneField);
            }
            HBox buttons1 = new HBox();
            buttons1.setAlignment(Pos.CENTER);
            buttons1.setSpacing(15);
            buttons1.setPadding(new Insets(15));
            Button back1 = new Button("Back");
            back1.setPrefWidth(100);
            back1.setPrefHeight(35);
            Button confirm = new Button("Confirm");
            confirm.setPrefWidth(100);
            confirm.setPrefHeight(35);
            buttons1.getChildren().addAll(back1, confirm);
            allRows.getChildren().addAll(buttons1);
            addListlayout.setContent(allRows);
            Scene addListScene = new Scene(addListlayout, 1000, 500);
            addListScene.getStylesheets().add("style.css");
            Stage addListWindow = new Stage();
            addListWindow.setTitle("Add List");
            addListWindow.setScene(addListScene);
            addListWindow.show();
            noOfListWindow.close();
            back1.setOnAction(l->{
                addListWindow.close();
                noOfListWindow.show();
            });
            confirm.setOnAction(a->{
                String list = "\n\\begin{enumerate}";
                for (int i = 0; i<items; i++) {
                    list = list + ("\n  \\item " + listItems[i].getText());
                }
                list = list + "\n\\end{enumerate}";
                body.setText(body.getText() + list);
                addListWindow.close();
            });
        });
        back.setOnAction(p->{
            noOfListWindow.close();
        });
    }
    public void backHandler () throws IOException {
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("startPage.fxml"));
        Scene s = new Scene(root, 500 , 500);
        s.getStylesheets().add("startPageStyles.css");
        Stage currStage =(Stage) back.getScene().getWindow();
        Stage newStage = new Stage();
        newStage.setTitle("Latex Wizard");
        newStage.setScene(s);
        currStage.close();
        newStage.show();
        newStage.setResizable(false);
    }
    public void createHandler () throws IOException {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);
        layout.setPadding(new Insets(15));
        Label pathLabel = new Label("File Location: ");
        Label pathLabelError = new Label();
        TextField path = new TextField();
        path.setText("C:\\");
        path.setPrefHeight(300);
        path.setPrefHeight(40);
        path.setPromptText("Enter Path for the file");
        Label fileNameLabel = new Label("File Name: ");
        TextField fileName = new TextField();
        fileName.setPrefHeight(40);
        fileName.setText("doc");
        fileName.setPromptText("Enter File Name with how you want to save it.");
        Button add = new Button("Generate");
        add.setPrefHeight(35);
        add.setPrefWidth(150);
        Button back = new Button("Back");
        back.setPrefHeight(35);
        back.setPrefWidth(150);
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(15));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back , add);
        layout.getChildren().addAll(pathLabel, path, fileNameLabel, fileName, pathLabelError, buttons);
        Scene pathScene = new Scene(layout, 300, 300);
        pathScene.getStylesheets().add("style.css");
        pathLabelError.getStyleClass().add("error");
        Stage pathWindow = new Stage();
        pathWindow.setTitle("Finishing Touches");
        pathWindow.setScene(pathScene);
        pathWindow.show();

        add.setOnAction(e->{
            boolean checkEmpty = false;
            if (path.getText().isEmpty()) {
                checkEmpty = true;
                pathLabelError.setText("*Required");
                path.requestFocus();
            }
            if (fileName.getText().isEmpty()) {
                checkEmpty = true;
                pathLabelError.setText("*Required");
                path.requestFocus();
            }
            if (!checkEmpty) {
                HelloApplication.data.setPath(path.getText());
                HelloApplication.data.setFileName(fileName.getText());
                if (HelloApplication.data.checkPath()) {
                    pathLabelError.setText("Invalid Address or File already exists");
                } else {
                    HelloApplication.data.setBody(body.getText());
                    try {
                        HelloApplication.data.createTexFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Platform.exit();
                }
            }
        });
        back.setOnAction(l->{
            pathWindow.close();
        });


    }

    public void rightArrowHandler () {
        body.setText(body.getText() + "$\\Rightarrow$");
        body.requestFocus();
        body.end();
    }

    public void vspaceHandler () {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);
        layout.setPadding(new Insets(15));
        Label valueLabel = new Label("Value: ");
        TextField value = new TextField();
        value.setPrefHeight(300);
        value.setPrefHeight(40);
        value.setPromptText("Enter Value");
        Button add = new Button("Add");
        add.setPrefHeight(35);
        add.setPrefWidth(150);
        Button back = new Button("Back");
        back.setPrefHeight(35);
        back.setPrefWidth(150);
        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(15));
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(back , add);
        layout.getChildren().addAll(valueLabel, value, buttons);
        Scene vspaceScene = new Scene(layout, 300, 200);
        vspaceScene.getStylesheets().add("style.css");
        Stage vspaceWindow = new Stage();
        vspaceWindow.setTitle("Add Path");
        vspaceWindow.setScene(vspaceScene);
        vspaceWindow.show();

        add.setOnAction(e->{
            body.setText(body.getText() + "\n\\vspace{" + value.getText() + "}");
            body.requestFocus();
            body.end();
            vspaceWindow.close();
        });

        back.setOnAction(k->{
            vspaceWindow.close();
        });
    }
}
