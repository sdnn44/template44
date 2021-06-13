package javaFxProject.gui.view;

import javaFxProject.gui.view.mainWindow.MainWindowViewFactory;
import javaFxProject.gui.view.mainWindow.MainWindowViewModel;
import javaFxProject.gui.view.userAuthentication.UserAuthenticationViewFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Router {
    private final UserAuthenticationViewFactory userAuthenticationViewFactory;
    private final MainWindowViewFactory mainWindowViewFactory;

    private Stage mainWindowStage;

    public Router(UserAuthenticationViewFactory userAuthenticationViewFactory, MainWindowViewFactory mainWindowViewFactory) {
        this.userAuthenticationViewFactory = userAuthenticationViewFactory;
        this.mainWindowViewFactory = mainWindowViewFactory;
    }

    public void setMainWindowStage(Stage mainWindowStage) {
        this.mainWindowStage = mainWindowStage;
    }

    public void showAuthentication() throws IOException {
        Runnable onUserAuthenticated = () -> {
            Stage mainWindow = new Stage();
            mainWindowStage.close();
            try {
                mainWindowViewFactory.create(mainWindow);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        userAuthenticationViewFactory.create(mainWindowStage, onUserAuthenticated);
    }

}
