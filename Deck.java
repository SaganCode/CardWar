import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    Card[] cards;

    public Deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        cards = new Card[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                cards[index++] = new Card(rank, suit);
            }
        }
        List<Card> cardList = Arrays.asList(cards);
        java.util.Collections.shuffle(cardList);
        java.util.Collections.shuffle(cardList);
        java.util.Collections.shuffle(cardList);
        cardList.toArray(cards);
    }

    public void CutTheDeck() {
        
    }
    
}