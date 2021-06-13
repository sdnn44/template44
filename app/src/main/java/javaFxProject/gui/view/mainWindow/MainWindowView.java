package javaFxProject.gui.view.mainWindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowView implements Initializable {
//    private final MainWindowViewModel viewModel;
    MainWindowViewModel viewModel = new MainWindowViewModel();
//    Stage stage = new Stage();
    @FXML TextField usernameTextField;
    @FXML Label loginHint;
    @FXML PasswordField passwordField;
    @FXML Label passwordHint;
    @FXML Button loginButton;
    @Override
        public void initialize(URL location, ResourceBundle resources) {
            usernameTextField.textProperty().bindBidirectional(viewModel.enteredUsername());
            System.out.println("elo");
            loginHint.textProperty().bind(viewModel.usernameHintMessage());
    }

//    public MainWindowView() {
//        usernameTextField.textProperty().bindBidirectional(viewModel.enteredUsername());
//        loginHint.textProperty().bind(viewModel.usernameHintMessage());
//    }
//    @FXML public void initialize() {
//        usernameTextField.textProperty().bindBidirectional(viewModel.enteredUsername());
//        loginHint.textProperty().bind(viewModel.usernameHintMessage());
//    }

    public MainWindowView(MainWindowViewModel viewModel, Stage stage)  throws IOException {



        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///D:/studia3rok/praktykaProgramowania/cwJavaFx/app/src/main/resources/sample.fxml"));
        BorderPane borderPane = loader.<BorderPane>load();
        //initialize(null,null);


        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Main Windoww");

        System.out.println("weszlo?");
        stage.show();
    }
//        VBox layout = new VBox();
//        layout.setPadding(new Insets(20));
//        layout.setSpacing(5);
//        layout.getChildren().addAll(new Label("elo"));
//
//        stage.setScene(new Scene(layout));
//        stage.setTitle("Main Window");
//        stage.show();
}
