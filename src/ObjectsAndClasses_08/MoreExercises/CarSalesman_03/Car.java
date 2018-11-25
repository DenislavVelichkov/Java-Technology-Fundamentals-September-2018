package ObjectsAndClasses_08.MoreExercises.CarSalesman_03;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private List<Engine> engine = new ArrayList<>();
    private String weight = "n/a";
    private String color = "n/a";

    public Car(String model) {
        this.model = model;

    }

    public void setEngine(String model, List<Engine> enginesDataBase) {
        for (Engine engine : enginesDataBase) {
            if (model.equals(engine.getModel())) {
                this.engine.add(engine);
                break;
            }
        }
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Engine> getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "  Weight: " + weight + "\n" +
                "  Color: " + color + "\n";
    }
}
