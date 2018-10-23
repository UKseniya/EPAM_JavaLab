package apartment;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Room roomOne = new Room();
        List<Wall> wallsRoomOne = new ArrayList<Wall>();
        Wall wallOne = new Wall(1, 5.0, true);
        Wall wallTwo = new Wall(2,2.5,true);
        Wall wallThree = new Wall(3, 5.0, false);
        Wall wallFour = new Wall(4, 2.5, true);
        wallsRoomOne.add(wallOne);
        wallsRoomOne.add(wallTwo);
        wallsRoomOne.add(wallThree);
        wallsRoomOne.add(wallFour);
        roomOne.setWalls(wallsRoomOne);
        List<Window> windowsRoomOne = new ArrayList<Window>();
        Window windowOne = new Window(1, 0.8, 1.2);
        windowsRoomOne.add(windowOne);
        roomOne.setWindows(windowsRoomOne);
        List<Door> doorsRoomOne = new ArrayList<Door>();
        Door doorOne = new Door(1, 1.8, 1.0);
        doorsRoomOne.add(doorOne);
        roomOne.setDoors(doorsRoomOne);

        Room roomTwo = new Room();
        List<Wall> wallsRoomTwo = new ArrayList<Wall>();
        Wall wallFive = new Wall(5, 3.0, true);
        Wall wallSix = new Wall(6, 3.0, true);
        Wall wallSeven = new Wall(7, 5.0, false);
        wallsRoomTwo.add(wallThree);
        wallsRoomTwo.add(wallFive);
        wallsRoomTwo.add(wallSix);
        wallsRoomTwo.add(wallSeven);
        roomTwo.setWalls(wallsRoomTwo);
        List<Window> windowsRoomTwo = new ArrayList<Window>();
        Window windowTwo = new Window(2, 0.8, 1.5);
        windowsRoomTwo.add(windowTwo);
        roomTwo.setWindows(windowsRoomTwo);
        List<Door> doorsRoomTwo = new ArrayList<Door>();
        Door doorTwo = new Door(2, 1.8, 1.2);
        doorsRoomTwo.add(doorTwo);
        roomTwo.setDoors(doorsRoomTwo);

        Room roomThree = new Room();
        List<Wall> wallsRoomThree = new ArrayList<Wall>();
        Wall wallEight = new Wall(8, 3.5, true);
        Wall wallNine = new Wall(9, 3.5, true);
        Wall wallTen = new Wall(10, 5.0, true);
        wallsRoomThree.add(wallSeven);
        wallsRoomThree.add(wallEight);
        wallsRoomThree.add(wallNine);
        wallsRoomThree.add(wallTen);
        roomThree.setWalls(wallsRoomThree);
        List<Window> windowsRoomThree = new ArrayList<Window>();
        Window windowThree = new Window(3, 0.8, 1.2);
        windowsRoomThree.add(windowThree);
        roomThree.setWindows(windowsRoomThree);
        List<Door> doorsRoomThree = new ArrayList<Door>();
        Door doorThree = new Door(3, 1.8, 1.0);
        doorsRoomThree.add(doorThree);
        roomThree.setDoors(doorsRoomThree);

        Apartment apartment = new Apartment();
        List<Room> rooms = new ArrayList<Room>();
        rooms.add(roomOne);
        rooms.add(roomTwo);
        rooms.add(roomThree);
        apartment.setRooms(rooms);

        System.out.println("Number of Rooms = " + rooms.size());

        System.out.println("Number of Walls = " + apartment.getNumberOfWalls());

        System.out.println("Number of Windows = " + apartment.getNumberOfWindows());

        System.out.println("Number of Doors = " + apartment.getNumberOfDoors());

        System.out.println("Apartment Square = " + apartment.getSquare());

        System.out.println("Apartment Perimeter = " + apartment.getPerimeter());

        }

    }
