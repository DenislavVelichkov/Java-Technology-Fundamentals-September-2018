package AssociativeArrays_07.MoreExercises.Judge_02;

public class User {
    private String name;
    private Integer points;
    private Integer totalPoints = 0;

    public User(String name, Integer points) {
        this.name = name;
        this.points = points;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }
}
