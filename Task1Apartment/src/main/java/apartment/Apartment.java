package apartment;

import java.util.ArrayList;
import java.util.List;

public class Apartment implements Square, Perimeter{
    List<Room> rooms = new ArrayList<Room>();


    public Apartment() {
    }

    public Apartment(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apartment apartment = (Apartment) o;

        return rooms != null ? rooms.equals(apartment.rooms) : apartment.rooms == null;
    }

    @Override
    public int hashCode() {
        return rooms != null ? rooms.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "rooms=" + rooms +
                '}';
    }

    public double getPerimeter() {
        double perimeter = 0;
        for(Room room : rooms ){
            List<Wall> walls = room.getWalls();
            for(Wall wall: walls){
                if (wall.isOutsideWall()) {
                    perimeter = perimeter + wall.getLength();
                }
            }
        }
        return perimeter;
    }

    public int getNumberOfWalls(){
        //Calculate all walls
        int numberOfWalls = 0;
        for(Room room : rooms){
            List<Wall> walls = room.getWalls();
            for(Wall wall : walls){
                numberOfWalls++;
            }
        }
        //Calculate inside walls
        int insideWalls = 0;
        for(Room room : rooms){
            List<Wall> walls = room.getWalls();
            for(Wall wall : walls){
                if(!wall.isOutsideWall()) {
                    insideWalls++;
                }
            }
        }
        return numberOfWalls = numberOfWalls - insideWalls/2;
    }

    public int getNumberOfWindows(){
        int numberOfWindows = 0;
            for(Room room : rooms){
            List<Window> windows = room.getWindows();
            for(Window window : windows) {
                numberOfWindows++;
            }
        }
        return numberOfWindows;
    }

    public int getNumberOfDoors() {
        int numberOfDoors = 0;
        for(Room room : rooms){
            List<Door> doors = room.getDoors();
            for(Door door : doors){
                numberOfDoors++;
            }
        }
        return numberOfDoors;
    }

    public double getSquare() {
        double apartmentSquare = 0;
        for(Room room : rooms) {
            apartmentSquare = apartmentSquare + room.getSquare();
        }
        return apartmentSquare;
    }
}
