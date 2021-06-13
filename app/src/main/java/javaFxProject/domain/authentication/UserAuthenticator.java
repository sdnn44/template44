package javaFxProject.domain.authentication;

public class UserAuthenticator {

    public void authenticate(String username, String password) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
