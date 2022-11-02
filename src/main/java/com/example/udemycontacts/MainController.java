package com.example.udemycontacts;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MainController {
    private List<Contacts> allContacts;

    @FXML
    private BorderPane mainBorderPane;
    public void initialize() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("myContacts.txt"));
//        System.out.println(lines.get(0));
//        System.out.println(lines.get(1));
//        System.out.println(lines.get(2));
//        System.out.println(lines.get(3));
//        for (int x = 0; x < lines.size(); x += 3) {
//            System.out.println(x);
//            System.out.println(lines.get(0));
//            System.out.println(lines.get(1));
//            System.out.println(lines.get(2));
//            System.out.println(lines.get(3));
//
//        }

//        Scanner s = new Scanner(new File("myContacts.txt"));
//        ArrayList<String> list = new ArrayList<String>();
//        while (s.hasNext()) {
//            System.out.println(s.next());
//            list.add(s.next());
//        }
//        s.close();
    }
    @FXML
    public void exitApplication() {
//        ContactData data = ContactData.getInstance();
//        data.storeContacts();
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
}