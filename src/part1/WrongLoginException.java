package part1;

public class WrongLoginException extends Exception {
    private final String login;

    public WrongLoginException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
