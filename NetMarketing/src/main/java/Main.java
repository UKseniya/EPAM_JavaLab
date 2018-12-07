import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IdGenerator id = new IdGenerator();
        Map<Integer, Employee> net = new HashMap<>();

        //Create a leader
        Employee leader = new Employee(id.getId(), 0, "Ivanov");
        net.put(leader.getId(), leader);

        //Create leader's (First Level) reports
        Employee firstLevelOne = new Employee(id.getId(), leader.getId(), "Petrov");
        leader.getReports().add(firstLevelOne);
        net.put(firstLevelOne.getId(), firstLevelOne);
        Employee firstLevelTwo = new Employee(id.getId(), leader.getId(), "Sidorov");
        leader.getReports().add(firstLevelTwo);
        net.put(firstLevelTwo.getId(), firstLevelTwo);
        Employee firstLevelThree = new Employee(id.getId(), leader.getId(), "Bridge");
        leader.getReports().add(firstLevelThree);
        net.put(firstLevelThree.getId(), firstLevelThree);

        //Create Second Level reports
        Employee secondLevelOne = new Employee(id.getId(), firstLevelOne.getId(), "Scott");
        firstLevelOne.getReports().add(secondLevelOne);
        net.put(secondLevelOne.getId(), secondLevelOne);
        Employee secondLevelTwo = new Employee(id.getId(), firstLevelOne.getId(), "Gale");
        firstLevelOne.getReports().add(secondLevelTwo);
        net.put(secondLevelOne.getId(), secondLevelOne);
        Employee secondLevelThree = new Employee(id.getId(), firstLevelTwo.getId(), "Brand");
        firstLevelTwo.getReports().add(secondLevelThree);
        net.put(secondLevelThree.getId(),secondLevelThree);
        Employee secondLevelFour = new Employee(id.getId(), firstLevelTwo.getId(), "Litt");
        firstLevelTwo.getReports().add(secondLevelFour);
        net.put(secondLevelFour.getId(), secondLevelFour);
        Employee secondLevelFive = new Employee(id.getId(), firstLevelThree.getId(), "Spector");
        firstLevelThree.getReports().add(secondLevelFive);
        net.put(secondLevelFive.getId(), secondLevelFive);
        Employee secondLevelSix = new Employee(id.getId(), firstLevelThree.getId(), "Puslon");
        firstLevelThree.getReports().add(secondLevelSix);
        net.put(secondLevelSix.getId(), secondLevelSix);
        Employee secondLevelSeven = new Employee(id.getId(), firstLevelThree.getId(), "Simpson");
        firstLevelThree.getReports().add(secondLevelSeven);
        net.put(secondLevelSeven.getId(), secondLevelSeven);

        //Create Third Level reports
        Employee thirdLevelOne = new Employee(id.getId(), secondLevelOne.getId(), "Bullock" );
        secondLevelOne.getReports().add(thirdLevelOne);
        net.put(thirdLevelOne.getId(), thirdLevelOne);
        Employee thirdLevelTwo = new Employee(id.getId(), secondLevelOne.getId(), "Stone" );
        secondLevelOne.getReports().add(thirdLevelTwo);
        net.put(thirdLevelTwo.getId(), thirdLevelTwo);
        Employee thirdLevelThree = new Employee(id.getId(), secondLevelTwo.getId(), "Warren" );
        secondLevelTwo.getReports().add(thirdLevelThree);
        net.put(thirdLevelThree.getId(), thirdLevelThree);
        Employee thirdLevelFour = new Employee(id.getId(), secondLevelThree.getId(), "Durov" );
        secondLevelThree.getReports().add(thirdLevelFour);
        net.put(thirdLevelFour.getId(), thirdLevelFour);
        Employee thirdLevelFive = new Employee(id.getId(), secondLevelThree.getId(), "Smirnov" );
        secondLevelThree.getReports().add(thirdLevelFive);
        net.put(thirdLevelFive.getId(), thirdLevelFive);
        Employee thirdLevelSix = new Employee(id.getId(), secondLevelFour.getId(), "Aldrich" );
        secondLevelFour.getReports().add(thirdLevelSix);
        net.put(thirdLevelSix.getId(), thirdLevelSix);
        Employee thirdLevelSeven = new Employee(id.getId(), secondLevelSix.getId(), "Pratt" );
        secondLevelSix.getReports().add(thirdLevelSeven);
        net.put(thirdLevelSeven.getId(), thirdLevelSeven);
        Employee thirdLevelEight = new Employee(id.getId(), secondLevelSix.getId(), "Wensky" );
        secondLevelSix.getReports().add(thirdLevelEight);
        net.put(thirdLevelEight.getId(), thirdLevelEight);
        Employee thirdLevelNine = new Employee(id.getId(), secondLevelSix.getId(), "Delon" );
        secondLevelSix.getReports().add(thirdLevelNine);
        net.put(thirdLevelNine.getId(), thirdLevelNine);

        System.out.println(leader);
        leader.printReports();

//        System.out.println(secondLevelFive);
//        secondLevelFive.printLeaders(net);
    }
}
