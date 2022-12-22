public class Difficulty {
    private int removing;
    private int points;
    private int removePoints;

    public Difficulty(int removing, int points, int removePoints) {
        this.removing = removing;
        this.points = points;
        this.removePoints = removePoints;
    }

    public int getRemoving() {
        return removing;
    }

    public int getPoints() {
        return points;
    }

    public int getRemovePoints() {
        return removePoints;
    }
}
