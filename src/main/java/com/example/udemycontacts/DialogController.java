package com.example.udemycontacts;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextArea notes;

    public Contacts getAllInputs() {
        String first = firstName.getText();
        String last = lastName.getText();
        String phone = phoneNumber.getText();
        String note = notes.getText();

        System.out.println(first + last + phone + note);

        Contacts newContacts = new Contacts(first, last, phone, note);
        ContactData.getInstance().addContact(newContacts);
        return newContacts;
    }
}
