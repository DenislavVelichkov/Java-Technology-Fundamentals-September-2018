package _08_Objects_And_Classes.MoreExercises.TeamWorkProjects_04;

public class Player {
    private String name;
    private String type;
    private String team;

    public Player(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

