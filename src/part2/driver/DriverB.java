package part2.driver;

import part2.transport.Car;

public class DriverB extends Driver<Car> {
    private String categoryClass;

    public DriverB(String fullName, boolean hasLicense, float internship, Car car, String category) {
        super(fullName, hasLicense, internship, car);
        try {
            setCategoryClass(category);
        } catch (LicenseCategoryException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void startMoving(Car car) {
        System.out.printf("%s start moving on %s %s%n",
                getFullName(),
                car.getBrand(),
                car.getModel());
    }

    @Override
    public void stopMoving(Car car) {
        System.out.printf("%s stop moving on %s %s%n",
                getFullName(),
                car.getBrand(),
                car.getModel());
    }

    @Override
    public void refillTransport(Car car) {
        System.out.printf("%s refill %s %s%n",
                getFullName(),
                car.getBrand(),
                car.getModel());
    }

    public String getCategoryClass() {
        return categoryClass;
    }

    public void setCategoryClass(String categoryClass) throws LicenseCategoryException {
        if (categoryClass == null) {
            throw new LicenseCategoryException("You must specify the category of rights!", this);
        }
        this.categoryClass = categoryClass;
    }

    @Override
    public String toString() {
        return String.format("Category: %s%n" +
                        "Full name: %s%n" +
                        "License: %b%n" +
                        "Internship: %.1f years%n",
                getCategoryClass(),
                getFullName(),
                isHasLicense(),
                getInternship());
    }
}
