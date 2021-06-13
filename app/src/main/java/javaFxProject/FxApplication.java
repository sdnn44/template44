package javaFxProject;

import javaFxProject.gui.view.Router;
import javaFxProject.gui.view.mainWindow.MainWindowViewFactory;
import javaFxProject.gui.view.userAuthentication.UserAuthenticationViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class FxApplication extends Application {

    private final Router router;

    public FxApplication() {
        router = new Router(new UserAuthenticationViewFactory(), new MainWindowViewFactory());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/sample.fxml"));
//        primaryStage.setScene(new Scene(root, 300, 300));
        router.setMainWindowStage(primaryStage);
        router.showAuthentication();
//        primaryStage.show();
    }
}
