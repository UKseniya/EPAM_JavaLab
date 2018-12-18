import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Long date = new Date().getTime();

        int totalNumbersOnTicket = 5;
        int range = 30;
        int numberOfTicketsInGame = 3;
        try {
            validateGameParams(totalNumbersOnTicket, range, numberOfTicketsInGame);
            Game game = new Game(totalNumbersOnTicket, range, numberOfTicketsInGame);
            game.init();
            game.start();
            System.out.println(game);
            System.out.println(new Date().getTime() - date);
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
