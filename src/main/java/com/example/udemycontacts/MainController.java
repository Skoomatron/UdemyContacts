package com.example.udemycontacts;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class MainController {
    private List<Contacts> allContacts;

    @FXML
    private BorderPane mainBorderPane;
    public void initialize() throws IOException {
        List<String> temp = checkContacts();
        initializeContacts(temp);
    }
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

        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            Contacts newContact = controller.getAllInputs();
        }
    }

    public List<String> checkContacts() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("myContacts.txt"));
        return lines;
    }

    public void initializeContacts(List<String> lines) {

        for (int x = 0; x < lines.size(); x += 4) {
            System.out.println(x);
            System.out.println(lines.get(x));
            System.out.println(lines.get(x+1));
            System.out.println(lines.get(x+2));
            System.out.println(lines.get(x+3));
            Contacts thisContact = new Contacts(lines.get(x), lines.get(x+1), lines.get(x+2), lines.get(x+3));
            ContactData.getInstance().addContact(thisContact);
        }
    }
}