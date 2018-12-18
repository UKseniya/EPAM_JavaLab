import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Ticket> tickets = new ArrayList<>();
    private List<Integer> receivedNumbers = new ArrayList<>();
    private int totalNumbers;
    private int range;
    private int playingTickets;


    public Game(int totalNumbers, int range, int playingTickets) {
        this.totalNumbers = totalNumbers;
        this.range = range;
        this.playingTickets = playingTickets;
    }

    public void init() {
        for (int i = 0; i < playingTickets; i++) {
            tickets.add(new Ticket(totalNumbers, range));
        }
    }

    public void start() {
        boolean allNumbersChecked = false;
        while (!allNumbersChecked) {
            Integer number = new Random().nextInt(range) + 1;
            if (!receivedNumbers.contains(number)) {
                receivedNumbers.add(number);
                for (Ticket ticket : tickets) {
                    ticket.checkNumber(number);
                    if (ticket.getMatchedNumbers() == ticket.getNumbersCount()) {
                        allNumbersChecked = true;
                    }
                }
            }
        }
      /*  for(Ticket t:tickets){
            System.out.println(t);
        }*/
    }

    public List<Ticket> getWinners() {
        int max = 0;
        List<Ticket> winners = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getMatchedNumbers() > max) {
                max = ticket.getMatchedNumbers();
            }
        }
        for (Ticket ticket : tickets) {
            if (ticket.getMatchedNumbers() == max) {
                winners.add(ticket);
            }
        }
        return winners;
    }

    @Override
    public String toString() {
        return "Number of tickets sold: " + tickets.size() + "\n" +
                "Numbers received " + receivedNumbers.size() + ": " + receivedNumbers + "\n" +
                "Winners " + getWinners().size() + ": " + getWinners();
    }
}
