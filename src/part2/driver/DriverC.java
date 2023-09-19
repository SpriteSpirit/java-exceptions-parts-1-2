package part2.driver;

import part2.transport.Truck;

public class DriverC extends Driver<Truck> {
    private  String categoryClass;

    public DriverC(String fullName, boolean hasLicense, float internship, Truck truck, String category) {
        super(fullName, hasLicense, internship, truck);
        try {
            setCategoryClass(category);
        } catch (LicenseCategoryException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void startMoving(Truck truck) throws LicenseCategoryException {
            if (!isHasLicense()) {
                throw new LicenseCategoryException("You must specify the category of rights: ", this);
            }
        System.out.printf("%s start moving on %s %s%n",
                getFullName(),
                truck.getBrand(),
                truck.getModel());
    }

    @Override
    public void stopMoving(Truck truck) {
        System.out.printf("%s stop moving on %s %s%n",
                getFullName(),
                truck.getBrand(),
                truck.getModel());
    }

    @Override
    public void refillTransport(Truck truck) {
        System.out.printf("%s refill %s %s%n",
                getFullName(),
                truck.getBrand(),
                truck.getModel());
    }

    public String getCategoryClass() {
        return categoryClass;
    }

    public void setCategoryClass(String categoryClass) throws LicenseCategoryException {
        if (categoryClass == null) {
            throw new LicenseCategoryException("You must specify the category of rights: ", this);
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
