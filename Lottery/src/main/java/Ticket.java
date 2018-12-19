import java.util.*;

public class Ticket {
    private int id;
    private Map<Integer, Boolean> numbers = new HashMap<>();
    int matchedNumbers;


    public Ticket(int totalNumbers, int range) {
        id = IdGenerator.getId();
        fillTicket(totalNumbers, range);
    }

    private void fillTicket(int totalNumbers, int range) {
        List<Integer> availableNumbers = new ArrayList<>(range);
        for (int i = 1; i <= range ; i++) {
            availableNumbers.add(i);
        }

        for (int i = 0; i < totalNumbers; i++) {
            Integer index = new Random().nextInt(availableNumbers.size());
            Integer number = availableNumbers.get(index);
            availableNumbers.remove(number);
            numbers.put(number, false);
        }
    }

//    private void fillTicket(int totalNumbers, int range) {
//        for (int i = 0; i < totalNumbers; i++) {
//            Integer number = new Random().nextInt(range) + 1;
//            if (!numbers.containsKey(number)){
//                numbers.put(number, false);
//            } else {
//                i--;
//            }
//        }
//    }

    public void checkNumber(Integer number) {
        if (numbers.containsKey(number)) {
            numbers.put(number, true);
            matchedNumbers++;
        }
    }

    public int getMatchedNumbers() {
        return matchedNumbers;
        //return (int) numbers.values().stream().filter(e -> e).count();
    }

    public int getNumbersCount() {
        return numbers.size();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", numbers=" + numbers +
                '}';
    }
}
