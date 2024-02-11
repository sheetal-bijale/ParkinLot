public class Car {

    String carNumber;
    //TODO We can have enum here if we have fix number of allowed colours
    String colour;

    public Car() {
    }

    public Car(String carNumber, String colour) {
        this.carNumber = carNumber;
        this.colour = colour;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
