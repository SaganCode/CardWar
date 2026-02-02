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
        shuffle();
    }

    public void shuffle() {
        List<Card> cardList = Arrays.asList(cards);
        java.util.Collections.shuffle(cardList);
        java.util.Collections.shuffle(cardList);
        java.util.Collections.shuffle(cardList);
        cardList.toArray(cards);
    }

    public void cutTheDeck() {
        Random rng = new Random(System.currentTimeMillis());
        int x = rng.nextInt(14)+19;
        Card[] array1 = new Card[x];
        Card[] array2 = new Card[cards.length-x];

        System.arraycopy(cards, 0, array1, 0, array1.length);
        System.arraycopy(cards, x, array2, 0, cards.length - x);
        System.arraycopy(array2, 0, cards, 0, array2.length);
        System.arraycopy(array1, 0, cards, array2.length, array1.length);
    }
    
}