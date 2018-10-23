package apartment;

import java.util.List;

public class Room extends BaseEntity implements Square {
    private List<Wall> walls;
    private List<Window> windows;
    private List<Door> doors;

    public Room() {
    }

    public Room(int id, List<Wall> walls, List<Window> windows, List<Door> doors) {
        this.setId(id);
        this.walls = walls;
        this.windows = windows;
        this.doors = doors;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public double getSquare() {
        return walls.get(0).getLength() * walls.get(1).getLength();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (walls != null ? !walls.equals(room.walls) : room.walls != null) return false;
        if (windows != null ? !windows.equals(room.windows) : room.windows != null) return false;
        return doors != null ? doors.equals(room.doors) : room.doors == null;
    }

    @Override
    public int hashCode() {
        int result = walls != null ? walls.hashCode() : 0;
        result = 31 * result + (windows != null ? windows.hashCode() : 0);
        result = 31 * result + (doors != null ? doors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "walls=" + walls +
                ", windows=" + windows +
                ", doors=" + doors +
                '}';
    }
}

