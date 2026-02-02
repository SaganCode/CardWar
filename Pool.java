import java.util.ArrayList;
import java.util.List;

public class Pool {
    ArrayList<Pair> cardsInPlay;
    ArrayList<Card> discardedCardsToTake;

    public Pool(List<Player> activePlayers) {
        cardsInPlay = new ArrayList<>();
        discardedCardsToTake = new ArrayList<>();

    }

    public void addCardToPool(Card card, Player player){
        Pair pair = new Pair(card, player, "fight");
        cardsInPlay.add(pair);
    }
}
