package _08_Objects_And_Classes.Lab;

import java.util.Random;

class Dice {
    int sides;

    public Dice(int sides) throws Exception {
        if (sides <= 0 || sides % 2 == 1) {
            throw new IllegalArgumentException("Dice must have atleast one side");
        }
        this.sides = sides;
    }

    public int roll() {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(this.sides);
        int result = randomNumber + 1;
        return result;
    }
    public static void main(String[] args) throws Exception {

        Dice dice = new Dice(6);
        System.out.println("We are now rolling...");
        System.out.println(dice.roll());
        System.out.println(dice.roll());
        System.out.println(dice.roll());
        System.out.println(dice.roll());
        System.out.println(dice.roll());
        System.out.println(dice.roll());

    }
}
