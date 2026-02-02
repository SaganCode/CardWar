import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hand {
    Stack<Card> cardsInHand;
    List<Card> discardedCards;

    public Hand() {
        cardsInHand = new Stack<>();
        discardedCards = new ArrayList<>();
    }
    
    public Card playCard() {
        return cardsInHand.pop();
    }

    public void addToHand(Card card) {
        cardsInHand.add(card);
    }

    public void addToDiscard(Card card) {
        discardedCards.add(card);
    }
}
