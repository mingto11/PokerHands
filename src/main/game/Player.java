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
        return pokers.get(pokers.size()-rank).getValue();
    }

    public int getHighestPair(int rank) {
        int countPair = 0;
        for(int i = pokers.size()-1; i >= 1; i--){
            if(pokers.get(i).compareTo(pokers.get(i-1)) == 0){
                countPair++;
                if(countPair == rank){
                    return pokers.get(i).getValue();

                }
            }
        }
        return 0;
    }
}
