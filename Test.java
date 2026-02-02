import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Deck deck = new Deck();

        for (Card card : deck.cards) {
            System.out.println(card.rank + " of " + card.suit);
        }

        System.out.println("-------CutTheDeck-------");
        deck.cutTheDeck();

        for (Card card : deck.cards) {
            System.out.println(card.rank + " of " + card.suit);
        }
    }
}
