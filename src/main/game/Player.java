package game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Poker> pokers;

    public Player(String... cards) {
        pokers = Arrays.stream(cards).map(Poker::new).collect(Collectors.toList());
        pokers.sort(Poker::compareTo);
    }

    public int getHighestCard(int rank) {
        return pokers.get(pokers.size() - rank).getValue();
    }

    public int getHighestPair(int rank) {
        int countPair = 0;
        for (int i = pokers.size() - 1; i >= 1; i--) {
            if (isPair(pokers.get(i), pokers.get(i - 1))) {
                countPair++;
                if (countPair == rank) {
                    return pokers.get(i).getValue();

                }
            }
        }
        return 0;
    }

    public int getHighestThreeOfAKind() {
        for (int i = pokers.size() - 1; i > 1; i--) {
            if (isThreeOfAKind(pokers.get(i), pokers.get(i - 1), pokers.get(i - 2)))
                return pokers.get(i).getValue();
        }
        return 0;
    }

    public int getStraight() {
        for (int i = pokers.size() - 1; i >= 1; i--) {
            if (isNeighbour(pokers.get(i), pokers.get(i - 1))) {
                return 0;
            }
        }
        return pokers.get(pokers.size() - 1).getValue();
    }

    private boolean isNeighbour(Poker cardOne, Poker cardTwo) {
        return cardOne.getValue() - cardTwo.getValue() != 1;
    }

    private boolean isThreeOfAKind(Poker cardOne, Poker cardTwo, Poker cardThree) {
        return isPair(cardOne, cardTwo) && isPair(cardTwo, cardThree);
    }

    private boolean isPair(Poker cardOne, Poker cardTwo) {
        return cardOne.equals(cardTwo);
    }

}
