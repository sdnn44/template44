package javaFxProject.gui.view.mainWindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainWindowViewFactory {
    public MainWindowView create(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:///D:/studia3rok/praktykaProgramowania/cwJavaFx/app/src/main/resources/sample.fxml"));
        BorderPane borderPane = loader.<BorderPane>load();
        //initialize(null,null);


        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Main Windoww");

        System.out.println("weszlo?");
        return new MainWindowView(new MainWindowViewModel(), stage);
    }
}
