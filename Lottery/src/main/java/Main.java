/* Lottery shall be stopped when all numbers of a ticket match the numbers got.
*
* Output:
* Number of tickets sold: 10
Numbers received 29: [6, 18, 11, 22, 28, 9, 8, 7, 2, 17, 15, 19, 23, 5, 25, 35,
29, 12, 33, 26, 36, 20, 21, 24, 34, 27, 4, 13, 30]
Winners 2: [Ticket{id=8, numbers={18=true, 2=true, 22=true, 11=true, 28=true, 30=true}},
Ticket{id=9, numbers={35=true, 36=true, 5=true, 6=true, 7=true, 30=true}}]*/

public class Main {
    private final static int TOTAL_NUMBERS_ON_TICKET = 6;
    private final static int RANGE = 36;
    private final static int NUMBERS_OF_TICKETS_IN_GAME = 10;

    public static void main(String[] args) {

        try {
            validateGameParams(TOTAL_NUMBERS_ON_TICKET, RANGE, NUMBERS_OF_TICKETS_IN_GAME);
            Game game = new Game(TOTAL_NUMBERS_ON_TICKET, RANGE, NUMBERS_OF_TICKETS_IN_GAME);
            game.init();
            game.start();
            System.out.println(game);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateGameParams(int totalNumbersOnTicket, int range, int numberOfTicketsInGame) {
        if (totalNumbersOnTicket <= 0) {
            throw new RuntimeException("Total numbers on ticket should be more than 0!");
        }
        if (range <= totalNumbersOnTicket) {
            throw new RuntimeException("Range should be bigger than total numbers on ticket!");
        }
        if (numberOfTicketsInGame <= 0) {
            throw new RuntimeException("Numbers of tickets should be more than 0!");
        }
    }
}
