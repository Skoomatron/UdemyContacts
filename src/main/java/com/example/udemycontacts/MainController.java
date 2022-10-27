package com.example.udemycontacts;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class MainController {
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    public void exitApplication() {
        Platform.exit();
    }
    @FXML
    public void addContact() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        dialog.setHeaderText("Contact");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't Find the Dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();

//        if (result.isPresent() && result.get() == ButtonType.OK) {
//            DialogController controller = fxmlLoader.getController();
//            TodoItem newItem = controller.processResults();
//            todoListView.getSelectionModel().select(newItem);
//        }
    }
}