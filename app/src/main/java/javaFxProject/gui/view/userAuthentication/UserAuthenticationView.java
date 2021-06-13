package javaFxProject.gui.view.userAuthentication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class UserAuthenticationView {
//    @FXML TextField usernameTextField;
//    @FXML Label loginHint;
//    @FXML PasswordField passwordField;
//    @FXML Label passwordHint;
//    @FXML Button loginButton;
    public UserAuthenticationView(UserAuthenticationViewModel viewModel, Stage stage) throws IOException{
//
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(new URL("file:///D:/studia3rok/praktykaProgramowania/cwJavaFx/app/src/main/resources/sample.fxml"));
//        BorderPane borderPane = loader.<BorderPane>load();
//
//        Scene scene = new Scene(borderPane);
//        stage.setScene(scene);
//        stage.setTitle("Main Window");
        TextField usernameTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        Label loginHint = new Label("Not gut");
        Label passwordHint = new Label("Not gut");
        Button loginButton = new Button("Zaloguj");



        //BINDINGs
        usernameTextField.disableProperty().bind(viewModel.cannotChangeUsername());
        usernameTextField.textProperty().bindBidirectional(viewModel.enteredUsername());

        passwordField.disableProperty().bind(viewModel.cannotChangePassword());
        passwordField.textProperty().bindBidirectional(viewModel.enteredPassword());

        loginHint.textProperty().bind(viewModel.usernameHintMessage());
        loginHint.visibleProperty().bind(viewModel.shouldShowUsernameHint());
        loginHint.managedProperty().bind(viewModel.shouldShowUsernameHint());

        passwordHint.textProperty().bind(viewModel.passwordHintMessage());
        passwordHint.visibleProperty().bind(viewModel.shouldShowPasswordHint());
        passwordHint.managedProperty().bind(viewModel.shouldShowPasswordHint());

        loginButton.disableProperty().bind(viewModel.cannotRequestLogin());
        loginButton.setOnAction(event -> viewModel.loginRequested());

        //WindowLayout
        GridPane form = new GridPane();
        form.setVgap(5);
        form.setHgap(5);

        form.addRow(0, new Label("Login:"), new VBox(usernameTextField, loginHint));
        form.addRow(1, new Label("Haslo:"), new VBox(passwordField, passwordHint));

        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setHalignment(HPos.RIGHT);

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setHalignment(HPos.LEFT);

        form.getColumnConstraints().addAll(
                leftColumn,
                rightColumn
        );

        RowConstraints firstRow = new RowConstraints();
        firstRow.setValignment(VPos.BASELINE);

        RowConstraints secoundRow = new RowConstraints();
        secoundRow.setValignment(VPos.BASELINE);

        form.getRowConstraints().addAll(
                firstRow,
                secoundRow
        );

        HBox actionButtonsLayout = new HBox();
        actionButtonsLayout.setAlignment(Pos.BASELINE_RIGHT);
        actionButtonsLayout.getChildren().addAll(
                loginButton
        );

        VBox layout = new VBox();
        layout.setPadding(new Insets(5));
        layout.setSpacing(5);
        layout.getChildren().addAll(
                form,
                actionButtonsLayout
        );
//
//        //Window
        stage.setScene(new Scene(layout, 600, 400));
////        Parent root = FXMLLoader.load(getClass().getResource("../../../../../resources/sample.fxml"));
////        stage.setScene(new Scene(root, 300, 300));
        stage.show();
    }
}
