public class Car {
    private String brand;
    private LicensePlate licensePlate;
    private int chassisNumber;
    private static int counter = 0;

    public Car(String brand, LicensePlate licensePlate) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.chassisNumber = counter++;
    }

    public String getBrand() {
        return brand;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public int getChassisNumber() {
        return chassisNumber;
    }

    public String toString() {
        return "Car " + chassisNumber + ": (Brand: " + brand + ", License Plate: " + licensePlate + ")";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }
}



