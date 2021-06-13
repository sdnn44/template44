package javaFxProject.gui.view.mainWindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowView {

    public MainWindowView(MainWindowViewModel viewModel, Stage stage)  throws IOException {

        //usernameTextField.textProperty().bindBidirectional(viewModel.enteredUsername());

        Button enter = new Button("Dodaj");
        Button sum = new Button("Suma");
        Button delete = new Button("Cofnij");
        Button clear = new Button("Wyczysc");

        enter.visibleProperty();
        enter.setOnAction(event -> viewModel.calculateTax());

        delete.setOnAction(event -> viewModel.deleteOneDigit());
        clear.setOnAction(event -> viewModel.clearDigit());

        TextField enteredDigitTextField = new TextField();
        enteredDigitTextField.setFocusTraversable(false);

//        enteredAmount.setText(viewModel.getEnteredAmount());

        enteredDigitTextField.textProperty().bindBidirectional(viewModel.enteredAmount());


        enteredDigitTextField.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredAmount(newValue));

        TextField subtotalAmount = new TextField();
        TextField taxAmount = new TextField();
        TextField totalAmount = new TextField();

        subtotalAmount.setEditable(false);
        taxAmount.setEditable(false);
        totalAmount.setEditable(false);
        enteredDigitTextField.setEditable(false);


        subtotalAmount.textProperty().bindBidirectional(viewModel.taxValue());
        taxAmount.textProperty().bindBidirectional(viewModel.taxValue());
        totalAmount.textProperty().bindBidirectional(viewModel.taxValue());

//        subtotalAmount.setText(viewModel.getSubtotalAmount());
//        subtotalAmount.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setSubtotalAmount(newValue));
//        taxAmount.setText(viewModel.getTaxAmount());
//        taxAmount.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setTaxAmount(newValue));
//        totalAmount.setText(viewModel.getTotalAmount());
//        totalAmount.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setTotalAmount(newValue));


        stage.setTitle("Kasa fiskalna");
        BorderPane root = new BorderPane();

        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button zero = new Button("0");
        Button dot = new Button(".");

        dot.setMaxWidth(Double.MAX_VALUE);

        //value1.textProperty().bind(viewModel.setAmount());
        one.setOnAction(event -> viewModel.setTextField1("1"));
        two.setOnAction(event -> viewModel.setTextField1("2"));
        three.setOnAction(event -> viewModel.setTextField1("3"));
        four.setOnAction(event -> viewModel.setTextField1("4"));
        five.setOnAction(event -> viewModel.setTextField1("5"));
        six.setOnAction(event -> viewModel.setTextField1("6"));
        seven.setOnAction(event -> viewModel.setTextField1("7"));
        eight.setOnAction(event -> viewModel.setTextField1("8"));
        nine.setOnAction(event -> viewModel.setTextField1("9"));
        zero.setOnAction(event -> viewModel.setTextField1("0"));
        dot.setOnAction(event -> viewModel.setTextField1("."));

        //number buttons
        GridPane digits = new GridPane();
        digits.add(one, 0, 0);
        digits.add(two, 1, 0);
        digits.add(three, 2, 0);
        digits.add(four, 0, 1);
        digits.add(five, 1, 1);
        digits.add(six, 2, 1);
        digits.add(seven, 0, 2);
        digits.add(eight, 1, 2);
        digits.add(nine, 2, 2);
        digits.add(zero, 1, 3);
        digits.add(dot, 2, 3);
        digits.setAlignment(Pos.BASELINE_CENTER);
        digits.setStyle("-fx-font-size: 12pt;");


        //place for entered numbers
        HBox insertion = new HBox(new Label("Kwota: "), enteredDigitTextField);
        insertion.setAlignment(Pos.CENTER);
        insertion.setPadding(new Insets(15, 0, 15, 0));

        //action buttons
        VBox vboxRight = new VBox();
        vboxRight.getChildren().addAll(enter, sum, delete, clear);
        enter.setMaxWidth(Double.MAX_VALUE);
        sum.setMaxWidth(Double.MAX_VALUE);
        delete.setMaxWidth(Double.MAX_VALUE);
        clear.setMaxWidth(Double.MAX_VALUE);
        vboxRight.setSpacing(5);

        //results area
        GridPane results = new GridPane();
        results.setAlignment(Pos.CENTER);
        results.addRow(0, new Label("Netto"), new VBox(subtotalAmount));
        results.addRow(1, new Label("Podatek"), new VBox(taxAmount));
        results.addRow(2, new Label("Brutto"), new VBox(totalAmount));
        results.setVgap(10);

        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setHalignment(HPos.LEFT);

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setHalignment(HPos.RIGHT);

        results.getColumnConstraints().addAll(
                leftColumn,
                rightColumn
        );

        root.setTop(insertion);
        root.setCenter(digits);
        root.setRight(vboxRight);
        root.setBottom(results);
        root.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);

        stage.show();


//
//        TextField usernameTextField = new TextField();
//        usernameTextField.setEditable(false);
//        Label loginHint = new Label();
//        TextField sum = new TextField();
//        Button value1 = new Button("1");
//        Button value2 = new Button("2");
//        Button value3 = new Button("3");
//        Button value4 = new Button("4");
//        Button value5 = new Button("5");
//        Button enter = new Button("Enter");
//        Button undo = new Button("Undo");
//        Button clear = new Button("Delete");
//        //binding setTextfield = buttonText
//        //usernameTextField.setText(viewModel.enteredAmount());
//        usernameTextField.textProperty().bindBidirectional(viewModel.enteredAmount());
//        //value1.textProperty().bind(viewModel.setAmount());
//        value1.setOnAction(event -> viewModel.setTextField1("1"));
//        value2.setOnAction(event -> viewModel.setTextField1("2"));
//        value3.setOnAction(event -> viewModel.setTextField1("3"));
//        value4.setOnAction(event -> viewModel.setTextField1("4"));
//        value5.setOnAction(event -> viewModel.setTextField1("5"));
//        //sum = usernameTextField;
//
//        sum.textProperty().bindBidirectional(viewModel.taxValue());
//        enter.setOnAction(event -> viewModel.calculateTax());
//
//        undo.setOnAction(event -> viewModel.deleteOneDigit());
//        clear.setOnAction(event -> viewModel.clearDigit());
//        //WindowLayout
//        GridPane form = new GridPane();
//        form.setVgap(5);
//        form.setHgap(5);
//
//        form.addRow(0, new Label("Kwota "), new VBox(usernameTextField, loginHint));
//        form.addRow(1, new Label("Test "), new VBox(sum, loginHint));
//
//        ColumnConstraints leftColumn = new ColumnConstraints();
//        leftColumn.setHalignment(HPos.RIGHT);
//
//        ColumnConstraints rightColumn = new ColumnConstraints();
//        rightColumn.setHalignment(HPos.LEFT);
//
//        form.getColumnConstraints().addAll(
//                leftColumn,
//                rightColumn
//        );
//
//        RowConstraints firstRow = new RowConstraints();
//        firstRow.setValignment(VPos.BASELINE);
//
//        RowConstraints secoundRow = new RowConstraints();
//        secoundRow.setValignment(VPos.BASELINE);
//
//        form.getRowConstraints().addAll(
//                firstRow,
//                secoundRow
//        );
//
//        HBox actionButtonsLayout = new HBox();
//        actionButtonsLayout.setAlignment(Pos.BASELINE_RIGHT);
//        actionButtonsLayout.getChildren().addAll(
//                value1, value2, value3, value4, value5, enter, undo, clear
//        );
//
//        VBox layout = new VBox();
//        layout.setPadding(new Insets(5));
//        layout.setSpacing(5);
//        layout.getChildren().addAll(
//                form,
//                actionButtonsLayout
//                //sum
//        );
////
////        //Window
//        stage.setScene(new Scene(layout, 600, 400));
//////        Parent root = FXMLLoader.load(getClass().getResource("../../../../../resources/sample.fxml"));
//////        stage.setScene(new Scene(root, 300, 300));
//
//        stage.show();
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
