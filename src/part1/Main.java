package part1;

public class Main {
    public static void main(String[] args) {
        String login = "Correct_login";
        String password = "Correct_password";
        String confirmPassword = "Correct_password";

        boolean success = Data.validate(login, password, confirmPassword);
//            System.out.println(login.length());
//            System.out.println(password.length());
        if (success) {
            System.out.println("Data is correct");
        }
        else {
            System.out.println("Data is uncorrected");
        }
    }
}