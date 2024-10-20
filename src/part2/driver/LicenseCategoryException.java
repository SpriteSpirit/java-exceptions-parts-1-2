package part2.driver;

public class LicenseCategoryException extends Exception{
    private Driver driver;
    public LicenseCategoryException(String message, Driver driver) {
        super(message);
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}
