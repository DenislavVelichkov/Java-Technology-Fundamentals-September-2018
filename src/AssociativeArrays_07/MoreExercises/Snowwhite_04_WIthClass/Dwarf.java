package AssociativeArrays_07.MoreExercises.Snowwhite_04_WIthClass;

public class Dwarf {
    private String name;
    private String color;
    private int physics;

    public Dwarf(String name, String color, int physics) {
        this.name = name;
        this.color = color;
        this.physics = physics;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = Math.max(physics, this.getPhysics());
    }
}
