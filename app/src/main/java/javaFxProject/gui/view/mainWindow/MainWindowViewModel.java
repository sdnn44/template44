package javaFxProject.gui.view.mainWindow;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import java.util.regex.Pattern;

public class MainWindowViewModel {
//    @FXML TextField usernameTextField;
//    @FXML Label loginHint;
//    @FXML PasswordField passwordField;
//    @FXML Label passwordHint;
//    @FXML Button loginButton;

    private final StringProperty enteredUsername;
    private final SimpleStringProperty usernameHintMessage;
    private final SimpleStringProperty enteredAmount;
    private final SimpleStringProperty setAmount;
    private final SimpleStringProperty taxValue;

    private static final Pattern MONEY_FORMAT = Pattern.compile("(?<enteredAmount>\\d+(?:\\.\\d{1,2})?)");

    public MainWindowViewModel() {
        enteredUsername = new SimpleStringProperty();
        usernameHintMessage = new SimpleStringProperty();
        enteredAmount = new SimpleStringProperty("");
        setAmount = new SimpleStringProperty();
        taxValue = new SimpleStringProperty();
//        usernameHintMessage =
        enteredAmount.addListener((observable, oldValue, newValue) -> {

        });

    }

    public Property<String> enteredAmount() {
        return enteredAmount;
    }

    public void setTextField1(String amount) {
        enteredAmount.setValue(enteredAmount.getValue()+amount);
        //enteredAmount.set(amount);
    }

    public Property<String> setAmount() {
        return setAmount;
    }

    public void calculateTax() {
        taxValue.set(enteredAmount.getValue());
    }

    public Property<String> taxValue() {
        return taxValue;
    }

    public void deleteOneDigit() {
        if (enteredAmount.getValue().length() > 0)
            enteredAmount.set(enteredAmount.getValue().substring(0, enteredAmount.getValue().length()-1));
    }

    public void clearDigit() {
        enteredAmount.set("");
    }

    public void setEnteredAmount(String newValue) {

    }
}

