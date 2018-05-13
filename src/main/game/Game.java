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
        int result = determineByStraight();

        if (result == 0) {
            result = determineByThreeOfAKind();
        }

        if (result == 0) {
            result = determineByPairs();
        }

        if(result == 0){
            result = determineByHighestCards();
        }

        return determineWinnter(result);
    }

    private String determineWinnter(int result) {
        if(result == 0)
            return GameConstant.Result.DRAW;
        return result > 0 ? GameConstant.Result.PLAYER_ONE_WIN : GameConstant.Result.PLAYER_TWO_WIN;
    }

    private int determineByStraight() {
        return playerOne.getStraight() - playerTwo.getStraight();
    }

    private int determineByThreeOfAKind() {
        return playerOne.getHighestThreeOfAKind() - playerTwo.getHighestThreeOfAKind();
    }

    private int determineByPairs() {
        for (int i = 1; i <= (numberOfCards / 2); i++) {
            int playerOnePair = playerOne.getHighestPair(i);
            int playerTwoPair = playerTwo.getHighestPair(i);
            if (playerOnePair > playerTwoPair) {
                return 1;
            }
            if (playerOnePair < playerTwoPair) {
                return -1;
            }
        }
        return 0;
    }

    private int determineByHighestCards() {
        for (int i = 1; i <= numberOfCards; i++) {
            if (playerOne.getHighestCard(i) > playerTwo.getHighestCard(i)) {
                return 1;
            }
            if (playerOne.getHighestCard(i) < playerTwo.getHighestCard(i)) {
                return -1;
            }
        }
        return 0;
    }
}
