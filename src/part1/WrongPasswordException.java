package part1;

public class WrongPasswordException extends Exception {
    private final String password;
    public WrongPasswordException(String message, String password) {
        super(message);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
