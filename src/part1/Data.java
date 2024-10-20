package part1;

public class Data {

    private Data() {
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            checkData(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkData(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null) { throw new WrongLoginException("Login cannot be empty.", null);}
        if (login.length() > 20) { throw new WrongLoginException("Login length more than 20 characters.", login);}
        if (!login.matches("[a-zA-Z0-9_]+")) { throw new WrongLoginException("Login contains unsupported characters.", login);}

        if (password == null) { throw new WrongPasswordException("Password cannot be empty.", null);}
        if (password.length() > 20) { throw new WrongPasswordException("Password length more than 20 characters", password);}
        if (!password.matches("[a-zA-Z0-9_]+")) { throw new WrongPasswordException("Password contains unsupported characters.", password);}
        if (!password.equals(confirmPassword)) { throw new WrongPasswordException("Passwords unmatched", password);}
    }
}
