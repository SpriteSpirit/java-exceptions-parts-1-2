package part2.driver;

import part2.transport.Bus;

public class DriverD extends Driver<Bus> {
    private String categoryClass;

    public DriverD(String fullName, boolean hasLicense, float internship, Bus bus, String category) {
        super(fullName, hasLicense, internship, bus);
        try {
            setCategoryClass(category);
        } catch (LicenseCategoryException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void startMoving(Bus bus) throws LicenseCategoryException {
        if (!isHasLicense()) {
            throw new LicenseCategoryException("You must specify the category of rights: ", this);
        }
        System.out.printf("%s start moving on %s %s%n",
                getFullName(),
                transport.getBrand(),
                transport.getModel());
    }

    @Override
    public void stopMoving(Bus bus) {
        System.out.printf("%s stop moving on %s %s%n",
                getFullName(),
                transport.getBrand(),
                transport.getModel());
    }

    @Override
    public void refillTransport(Bus bus) {
        System.out.printf("%s refill %s %s%n",
                getFullName(),
                transport.getBrand(),
                transport.getModel());
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
