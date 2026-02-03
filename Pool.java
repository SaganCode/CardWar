import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

public class Pool {
    ArrayList<Pair> cardsInPlay;
    ArrayList<Card> discardedCardsToTake;
    HashMap<Integer, Integer> playerValue;

    public Pool(List<Player> activePlayers) {
        cardsInPlay = new ArrayList<>();
        discardedCardsToTake = new ArrayList<>();

    }

    public void addCardToPool(Card card, Player player, String cardFunction) {
        Pair pair = new Pair(card, player, cardFunction);
        cardsInPlay.add(pair);
    }

    public void addToDiscarded(Card card) {
        discardedCardsToTake.add(card);
    }

    public WinnerHandler fight() {
        playerValue = new HashMap<>();
        for (Pair pair : cardsInPlay) {
            playerValue.put(pair.player.id, cardEvaluation(pair.card.rank));
        }
        return winnerOfTheFight(Collections.max(playerValue.values()));
    }

    public WinnerHandler winnerOfTheFight(int valueMax) {
        List<Integer> warParticipants = new ArrayList<>();
        WinnerHandler winnerPair;
        for(int key : playerValue.keySet()){
            if(playerValue.get(key) == valueMax) {
                warParticipants.add(key);

            }
        }
        if(warParticipants.size() == 1){
            for(int key : playerValue.keySet()) {
                if(playerValue.get(key) == valueMax){
                    winnerPair = new WinnerHandler(key, warParticipants);
                    return winnerPair;
                }
            }
        } 
        winnerPair = new WinnerHandler(-99, warParticipants);
        return winnerPair;
    }

    public void war(){  //TODO
        System.out.println("WAR");
    }

    public int cardEvaluation(String rank) {
        if(rank.equals("Jack")){
            return 11;
        } else if(rank.equals("Queen")){
            return 12;
        } else if(rank.equals("King")) {
            return 13;
        } else if(rank.equals("Ace")) {
            return 14;
        } else {
            return Integer.parseInt(rank);
        }
    }
}
