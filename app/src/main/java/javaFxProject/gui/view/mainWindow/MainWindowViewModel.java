package javaFxProject.gui.view.mainWindow;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainWindowViewModel {
//    @FXML TextField usernameTextField;
//    @FXML Label loginHint;
//    @FXML PasswordField passwordField;
//    @FXML Label passwordHint;
//    @FXML Button loginButton;

    private final StringProperty enteredUsername;
    private final SimpleStringProperty usernameHintMessage;

    public MainWindowViewModel() {
        enteredUsername = new SimpleStringProperty();
        usernameHintMessage = new SimpleStringProperty();
//        usernameHintMessage =
        enteredUsername.addListener((observable, oldValue, newValue) -> {
            if (newValue.isBlank()) usernameHintMessage.set("Login nie może być pusty");
        });

    }
    public Property<String> enteredUsername() {
        return enteredUsername;
    }
    public ObservableValue<String> usernameHintMessage() {
        return usernameHintMessage;
    }
}

