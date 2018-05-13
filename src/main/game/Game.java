package game;

public class Game {
    private Player playerOne;
    private Player playerTwo;
    private int numberOfCards;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.numberOfCards = 5;
    }

    public Game(Player playerOne, Player playerTwo, int numberOfCards) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.numberOfCards = numberOfCards;
    }

    public String findWinner() {
        String result = determinePair();
        if (result.equals(GameConstant.Result.DRAW)) {
            result = determineHighestCards();
        }
        return result;
    }

    private String determinePair() {
        for (int i = 1; i <= (numberOfCards / 2); i++) {
            int playerOnePair = playerOne.getHighestPair(i);
            int playerTwoPair = playerTwo.getHighestPair(i);
            if (playerOnePair > playerTwoPair) {
                return GameConstant.Result.PLAYER_ONE_WIN;
            }
            if (playerOnePair < playerTwoPair) {
                return GameConstant.Result.PLAYER_TWO_WIN;
            }
        }
        return GameConstant.Result.DRAW;
    }

    private String determineHighestCards() {
        for (int i = 1; i <= numberOfCards; i++) {
            if (playerOne.getHighestCard(i) > playerTwo.getHighestCard(i)) {
                return GameConstant.Result.PLAYER_ONE_WIN;
            }
            if (playerOne.getHighestCard(i) < playerTwo.getHighestCard(i)) {
                return GameConstant.Result.PLAYER_TWO_WIN;
            }
        }
        return GameConstant.Result.DRAW;
    }
}
