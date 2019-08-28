package _08_Objects_And_Classes.MoreExercises.RawData_02;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private List<Tire> tires = new ArrayList<>();
    private List<Cargo> cargo = new ArrayList<>();
    private List<Engine> engine = new ArrayList<>();

    public List<Tire> getTires() {
        return tires;
    }

    public Car(String model,
               Engine engine,
               Cargo cargo,
               Tire tire1, Tire tire2, Tire tire3, Tire tire4) {

        this.model = model;
        this.tires.add(tire1);
        this.tires.add(tire2);
        this.tires.add(tire3);
        this.tires.add(tire4);
        this.cargo.add(cargo);
        this.engine.add(engine);
    }

    public String getModel() {
        return model;
    }

    public List<Engine> getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return String.format("%s%n", getModel());
    }
}
