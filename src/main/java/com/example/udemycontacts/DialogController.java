package com.example.udemycontacts;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DialogController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextArea notes;
    private List<Contacts> theseContacts = new ArrayList<Contacts>();
    private static String fileName = "myContacts.txt";

    public Contacts getAllInputs() {
        String first = firstName.getText();
        String last = lastName.getText();
        String phone = phoneNumber.getText();
        String note = notes.getText();

        System.out.println(first + last + phone + note);

        Contacts newContacts = new Contacts(first, last, phone, note);
        theseContacts.add(newContacts);
        try {
            storeContacts();

        } catch (IOException e) {
            System.out.println(e);
        }
        return newContacts;
    }
    public void storeContacts() throws IOException {
        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<Contacts> iter = theseContacts.iterator();
            while (iter.hasNext()) {
                Contacts contact = iter.next();
                bw.write(String.format("%s\t%s\t%s\t%s", contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getNotes()));
                bw.newLine();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }
}
