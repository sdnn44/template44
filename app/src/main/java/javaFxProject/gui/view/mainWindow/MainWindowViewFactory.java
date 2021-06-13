package javaFxProject.gui.view.mainWindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainWindowViewFactory {
    public MainWindowView create(Stage stage) throws IOException {
        return new MainWindowView(new MainWindowViewModel(), stage);
    }
}
