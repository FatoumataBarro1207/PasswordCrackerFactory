package target;

public class LocalTarget implements Target {
    private String validLogin = "admin";
    private String validPassword = "pas123";

    @Override
    public boolean authenticate(String login, String password) {
        return validLogin.equals(login) && validPassword.equals(password);
    }
}
