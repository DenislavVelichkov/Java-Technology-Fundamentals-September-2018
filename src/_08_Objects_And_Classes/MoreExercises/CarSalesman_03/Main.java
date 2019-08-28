package _08_Objects_And_Classes.MoreExercises.CarSalesman_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String text = reader.readLine();
        List<Engine> engineDataBase = new ArrayList<>();
        /*Map<String, List<Engine>> cars = new LinkedHashMap<>();*/

        while (n-- > 0) {
            String[] line = text.split(" ");
            String model = line[0];
            String power = line[1];
            Engine engine = new Engine(model, power);

            if (line.length == 3) {
                if (Character.isDigit(line[2].charAt(0))) {
                    String displacement = line[2];
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = line[2];
                    engine.setEfficiency(efficiency);
                }

            } else if (line.length == 4) {
                String displacement = line[2];
                String efficiency = line[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }

            engineDataBase.add(engine);
            text = reader.readLine();
        }

        int m = Integer.parseInt(text);

        while (m-- > 0) {
            text = reader.readLine();
            String[] line = text.split(" ");
            String model = line[0];
            Car car = new Car(model);
            car.setEngine(line[1], engineDataBase);

            if (line.length == 3) {
                if (Character.isDigit(line[2].charAt(0))) {
                    String weight = line[2];
                    car.setWeight(weight);
                } else {
                    String color = line[2];
                    car.setColor(color);
                }

            } else if (line.length == 4) {
                String weight = line[2];
                String color = line[3];
                car.setWeight(weight);
                car.setColor(color);
            }
            /*cars.putIfAbsent(model, new ArrayList<>());
            cars.get(model).add(car.getEngine().get(0));*/
            out.printf("%s:%n", model);
            out.println(car.getEngine().toString()
                      .replaceAll("[\\[\\]]", ""));
            out.print(car.toString());


        }

    }
}
