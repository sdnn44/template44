package javaFxProject.gui.view.userAuthentication;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javaFxProject.domain.authentication.UserAuthenticator;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;

public class UserAuthenticationViewModel {
    private final ObservableBooleanValue cannotChangeUsername;
    private final StringProperty enteredUsername;
    private final BooleanProperty cannotChangePassword;
    private final StringProperty enteredPassword;
    private final SimpleStringProperty usernameHintMessage;
    private final BooleanBinding shouldShowUsernameHint;
    private final StringProperty passwordHintMessage;
    private final BooleanProperty shouldShowPasswordHint;
    private final SimpleBooleanProperty loginInProgress = new SimpleBooleanProperty();
    private final BooleanBinding cannotRequestLogin;
    private final Runnable onUserAuthenticated;

    public UserAuthenticationViewModel(Runnable onUserAuthenticated) {
        this.onUserAuthenticated = onUserAuthenticated;

        enteredUsername = new SimpleStringProperty();
        enteredPassword = new SimpleStringProperty();
        usernameHintMessage = new SimpleStringProperty();
        passwordHintMessage = new SimpleStringProperty();
        shouldShowPasswordHint = new SimpleBooleanProperty();

        enteredUsername.addListener((observable, oldValue, newValue) -> {
            if (newValue.isBlank()) usernameHintMessage.set("Login nie moze być pusty");
            else if (newValue.length() < 3) usernameHintMessage.set("Login nie moze byc krotszy niz 3 znaki");
            else if (newValue.length() > 30) usernameHintMessage.set("Login nie moze byc dluzszy niz 30 znakow");
            else usernameHintMessage.set(null);
        });

        shouldShowUsernameHint = usernameHintMessage.isNotEmpty();

        cannotChangeUsername = loginInProgress;
        cannotChangePassword = loginInProgress;

        cannotRequestLogin = loginInProgress
                .or(enteredUsername.isNull()).or(usernameHintMessage.isNotEmpty())
                .or(enteredPassword.isNull()).or(enteredPassword.isEmpty());
    }

    public ObservableValue<Boolean> cannotChangeUsername() {
        return cannotChangeUsername;
    }

    public Property<String> enteredUsername() {
        return enteredUsername;
    }

    public ObservableValue<Boolean> cannotChangePassword() {
        return cannotChangePassword;
    }

    public Property<String> enteredPassword() {
        return enteredPassword;
    }

    public ObservableValue<String> usernameHintMessage() {
        return usernameHintMessage;
    }

    public ObservableValue<Boolean> shouldShowUsernameHint() {
        return shouldShowUsernameHint;
    }

    public ObservableValue<String> passwordHintMessage() {
        return passwordHintMessage;
    }

    public ObservableValue<Boolean> shouldShowPasswordHint() {
        return shouldShowPasswordHint;
    }

    public ObservableValue<Boolean> cannotRequestLogin() {
        return cannotRequestLogin;
    }

    public void loginRequested() {

        loginInProgress.set(true);
        /*
        Thread thread = new Thread(() -> {
            new UserAuthenticator().authenticate(enteredUsername.get(), enteredPassword.get());
            Platform.runLater(()-> {
                    loginInProgress.set(false);
            });
        });
        thread.start();*/
        Completable.fromRunnable(()-> {
                new UserAuthenticator().authenticate(enteredUsername.get(), enteredPassword.get());
            })
            .subscribeOn(Schedulers.io())
            .observeOn(JavaFxScheduler.platform())
            .doFinally(() -> loginInProgress.set(false))
            .subscribe(
                    () -> {
                        onUserAuthenticated.run();
                    },
                    throwable -> {
                        //...
                    }
            );
    }

}
