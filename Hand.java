import java.util.ArrayList;
import java.util.Collections;
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
        if (cardsInHand.isEmpty()) {
            discardedCards = shuffle(discardedCards);
            Stack<Card> stack = new Stack<>();
            for (Card card : discardedCards) {
                stack.add(card);
            }
            cardsInHand = stack;
            discardedCards.clear();
        }
        if(cardsInHand.isEmpty() && discardedCards.isEmpty()){
            Card loser = new Card("LOSER", "HAHA");
            return loser;
        }
        return cardsInHand.pop();

    }

    public void addToHand(Card card) {
        cardsInHand.add(card);
    }

    public void addToDiscard(Card card) {
        discardedCards.add(card);
    }

    public List<Card> shuffle(List<Card> cardList) {
        Collections.shuffle(cardList);
        Collections.shuffle(cardList);
        Collections.shuffle(cardList);
        return cardList;
    }
}
