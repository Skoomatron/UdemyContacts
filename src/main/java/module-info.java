module com.example.udemycontacts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.udemycontacts to javafx.fxml;
    exports com.example.udemycontacts;
}