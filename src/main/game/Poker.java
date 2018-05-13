package game;

import java.util.HashMap;
import java.util.Map;

public class Poker implements Comparable<Poker> {
    private int value;

    public Poker(String card) {
        this.value = convertCardTozValue(card);
    }

    private int convertCardTozValue(String card) {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("J", 11);
        valueMap.put("Q", 12);
        valueMap.put("K", 13);
        valueMap.put("A", 14);
        String cardValue = card.substring(0, card.length() - 1);
        if(valueMap.containsKey(cardValue)){
            return valueMap.get(cardValue);
        }
        return Integer.valueOf(cardValue);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Poker anotherCard){
        return this.value - anotherCard.getValue();
    }

    @Override
    public boolean equals(Object anotherCard){
       Poker card = (Poker) anotherCard;
       return this.value == card.getValue();
    }
}
