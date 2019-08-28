package _08_Objects_And_Classes.Lab.Dices;

import java.util.Random;

class Dice {
    int sides;

    public Dice(int sides) throws Exception {
        this.setSides(sides);
    }

    public int roll() {
        Random rnd = new Random();
        //nextInt means 0-9, we can't have a side with 0, so we add +1
        int randomNumber = rnd.nextInt(this.sides);
        int result = randomNumber + 1;
        return result;
    }
    // Set sides int the class and can't be manipulated
    private void setSides(int sides) {
        if (sides <= 0 || sides % 2 == 1) {
            throw new IllegalArgumentException("Dice must have atleast one side");
        }
        this.sides = sides;
    }
}
