package _08_Objects_And_Classes.Exercises.VehicleCatalogue_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Vehicle> cars = new ArrayList<>();
        List<Vehicle> trucks = new ArrayList<>();
        String line = sc.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            Vehicle vehicle = new Vehicle(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));

            if (vehicle.getType().equals("Truck")) {
                trucks.add(vehicle);
            } else {
                cars.add(vehicle);
            }

            line = sc.nextLine();
        }

        line = sc.nextLine();
        while (!line.equals("Close the Catalogue")) {
            String model = line;

            for (Vehicle truck : trucks) {
                if (truck.getModel().equals(model)) {
                    System.out.println(truck.toString());
                }
            }

            for (Vehicle car : cars) {
                if (car.getModel().equals(model)) {
                    System.out.println(car.toString());
                }
            }

            line = sc.nextLine();
        }

        double truckHpAvg = 0;
        double carsHpAvg = 0;
        double carHpSum = 0;
        double truckHpSum = 0;

        if (!cars.isEmpty()) {
            for (Vehicle car : cars) {
                carHpSum += car.getHorsepower();
            }

            carsHpAvg = carHpSum / cars.size();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", carsHpAvg);

        if (!trucks.isEmpty()) {
            for (Vehicle truck : trucks) {
                truckHpSum += truck.getHorsepower();
            }

            truckHpAvg = truckHpSum / trucks.size();
        }

        System.out.printf("Trucks have average horsepower of: %.2f.%n", truckHpAvg);
    }
}
