package javaFxProject.gui.view.userAuthentication;
import javafx.stage.Stage;

import java.io.IOException;

public class UserAuthenticationViewFactory {
    public UserAuthenticationView create(Stage stage, Runnable onUserAuthenticated) throws IOException {
        UserAuthenticationViewModel viewModel = new UserAuthenticationViewModel(onUserAuthenticated);
        return new UserAuthenticationView(viewModel, stage);
    }
}
