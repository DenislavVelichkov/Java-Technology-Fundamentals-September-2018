package ObjectsAndClasses_08.MoreExercises.RawData_02;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        Map<String, List<Car>> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = line.split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tirePressure1 = Double.parseDouble(tokens[5]);
            int tireAge1 = Integer.parseInt(tokens[6]);
            double tirePressure2 = Double.parseDouble(tokens[7]);
            int tireAge2 = Integer.parseInt(tokens[8]);
            double tirePressure3 = Double.parseDouble(tokens[9]);
            int tireAge3 = Integer.parseInt(tokens[10]);
            double tirePressure4 = Double.parseDouble(tokens[11]);
            int tireAge4 = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Tire tire1 = new Tire(tirePressure1, tireAge1);
            Tire tire2 = new Tire(tirePressure2, tireAge2);
            Tire tire3 = new Tire(tirePressure3, tireAge3);
            Tire tire4 = new Tire(tirePressure4, tireAge4);

            if (cargoType.equals("fragile")) {
                cars.putIfAbsent(cargoType, new ArrayList<>());
                cars.get(cargoType).add(new Car
                        (model, engine, cargo, tire1, tire2, tire3, tire4));
            } else {
                cars.putIfAbsent(cargoType, new ArrayList<>());
                cars.get(cargoType).add(new Car
                        (model, engine, cargo, tire1, tire2, tire3, tire4));
            }

            line = sc.nextLine();
        }

        switch (line) {
            case "fragile":
                for (List<Car> value : cars.values()) {
                    value.forEach(car -> car.getTires()
                        .stream()
                        .filter(tire ->
                                tire.getPressure() < 1.0
                                    && cars.containsKey("fragile"))
                        .findFirst()
                        .ifPresent(tire ->
                            System.out.printf("%s%n", car.getModel())));

                }
                break;
            case "flamable":
                for (List<Car> value : cars.values()) {
                    value.forEach(car -> car.getEngine()
                        .stream()
                        .filter(engine ->
                                engine.getPower() > 250
                                        && cars.containsKey("flamable"))
                        .findFirst()
                        .ifPresent(engine ->
                            System.out.printf("%s%n", car.getModel())));
                }
                break;
        }
    }
}
