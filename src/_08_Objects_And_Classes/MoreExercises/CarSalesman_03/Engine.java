package _08_Objects_And_Classes.MoreExercises.CarSalesman_03;

public class Engine {

    private String model;
    private String power;
    private String displacement = "n/a";
    private String efficiency = "n/a";

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public String getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return String.format("  %s:%n    Power: %s%n    Displacement: %s%n" +
                        "    Efficiency: %s",
        getModel(),getPower(),getDisplacement(),getEfficiency());
    }
}
