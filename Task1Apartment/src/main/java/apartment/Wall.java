package apartment;

public class Wall extends BaseEntity {

    private double length;
    static double height = 2.6;
    private boolean outsideWall;

    public Wall() {
    }

    public Wall(int id, double length, boolean outsideWall) {
        this.setId(id);
        this.length = length;
        this.outsideWall = outsideWall;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        Wall.height = height;
    }

    public boolean isOutsideWall() {
        return outsideWall;
    }

    public void setOutsideWall(boolean outsideWall) {
        this.outsideWall = outsideWall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wall wall = (Wall) o;

        if (Double.compare(wall.length, length) != 0) return false;
        return outsideWall == wall.outsideWall;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (outsideWall ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "length=" + length +
                ", outsideWall=" + outsideWall +
                '}';
    }
}
