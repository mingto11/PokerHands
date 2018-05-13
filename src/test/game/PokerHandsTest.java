package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandsTest {


    @Test
    public void testOneHighCardWithTwoCard(){
        Poker cardOne = new Poker("2D");
        Poker cardTwo = new Poker("5D");
        assertEquals(-3, cardOne.compareTo(cardTwo));

        cardOne = new Poker("10D");
        cardTwo = new Poker("1D");
        assertEquals(9, cardOne.compareTo(cardTwo));

        cardOne = new Poker("AD");
        cardTwo = new Poker("1D");
        assertEquals(13, cardOne.compareTo(cardTwo));

        cardOne = new Poker("1D");
        cardTwo = new Poker("1S");
        assertEquals(0, cardOne.compareTo(cardTwo));
    }


    @Test
    public void testHighCard_HigherCase_GivenOnlyOneHighCard(){
        Player playerOne = new Player("1D", "2D", "3D", "4D", "5D");
        Player playerTwo = new Player("6D", "7D", "8D", "9D", "10D");
        Game game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_TWO_WIN, game.findWinner());

        playerOne = new Player("5D", "2D", "AD", "4D", "7D");
        playerTwo = new Player("6D", "7D", "8D", "9D", "10D");
        game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_ONE_WIN, game.findWinner());
    }


    @Test
    public void testHighCard__DrawCase_GivenTwoHighestCardAreSame(){
        Player playerOne = new Player("10S");
        Player playerTwo = new Player("10D");
        Game game = new Game(playerOne, playerTwo, 1);

        assertEquals(GameConstant.Result.DRAW, game.findWinner());

        playerOne = new Player("3D", "2D", "10D", "4D", "5S");
        playerTwo = new Player("5H", "4S", "2S", "3C", "10S");
        game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.DRAW, game.findWinner());
    }


    @Test
    public void testHighCard__FirstHighestAreSameCase_GivenFirstHighestCardAreSame(){

        Player playerOne = new Player("3D", "5D", "10D", "4D", "9S");
        Player playerTwo = new Player("7H", "4S", "2S", "3C", "10S");
        Game game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_ONE_WIN, game.findWinner());
    }

    @Test
    public void testHighCard__FirstForthHighestAreSameCase_GivenForthHighestCardAreSame(){

        Player playerOne = new Player("8D", "6D", "10D", "7D", "9S");
        Player playerTwo = new Player("9H", "8S", "7S", "5C", "10S");
        Game game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_ONE_WIN, game.findWinner());
    }

    @Test
    public void testPair_OnePairCase_GivenEachPlayersHaveOnePair(){
        Player playerOne = new Player("8D", "6D", "10D", "10C", "9S");
        Player playerTwo = new Player("9H", "9S", "7S", "5C", "AS");
        Game game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_ONE_WIN, game.findWinner());
    }

    @Test
    public void testPair_TwoPairCase_GivenEachPlayersHaveTwoPair(){
        Player playerOne = new Player("6D", "6S", "10D", "10C", "AC");
        Player playerTwo = new Player("9H", "9S", "10S", "10C", "2S");
        Game game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_TWO_WIN, game.findWinner());

        playerOne = new Player("9D", "9C", "10D", "10H", "AC");
        playerTwo = new Player("9H", "9S", "10S", "10C", "2S");
        game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_ONE_WIN, game.findWinner());
    }

    @Test
    public void testPair_TwoPairCase_GivenOnePlayersHaveTwoPairAnotherHasOnePair(){
        Player playerOne = new Player("6D", "7D", "10D", "10C", "AC");
        Player playerTwo = new Player("9H", "9S", "10S", "10C", "2S");
        Game game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_TWO_WIN, game.findWinner());


        playerOne = new Player("6D", "6D", "10D", "10C", "AC");
        playerTwo = new Player("AH", "9S", "AS", "10C", "2S");
        game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_TWO_WIN, game.findWinner());
    }

    @Test
    public void testPair_TwoPairCase_GivenOnePlayersHaveTwoPairAnotherHasNoPair(){
        Player playerOne = new Player("6D", "7D", "KD", "10C", "AC");
        Player playerTwo = new Player("9H", "9S", "10S", "10C", "2S");
        Game game = new Game(playerOne, playerTwo);

        assertEquals(GameConstant.Result.PLAYER_TWO_WIN, game.findWinner());
    }

}
