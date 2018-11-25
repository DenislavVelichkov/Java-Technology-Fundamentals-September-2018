package ObjectsAndClasses_08.Exercises.VehicleCatalogue_06;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle(String type, String model, String color, int horsepower) {
        this.setType(type);
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    private void setType(String type) {
        type = type.replace(type.charAt(0), Character.toUpperCase(type.charAt(0)));

        this.type = type;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    /*Type: {typeOfVehicle}
    Model: {modelOfVehicle}
    Color: {colorOfVehicle}
    Horsepower: {horsepowerOfVehicle}

    */
    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                "Model: %s%n" +
                "Color: %s%n" +
                "Horsepower: %d", this.getType(), this.getModel(), this.getColor(), this.getHorsepower());
    }
}
