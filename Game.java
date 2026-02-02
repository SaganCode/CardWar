import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Game {
    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Player[] players;
    List<Player> activePlayers = new ArrayList<>();

    public void gameStart() {
        player1 = new Player("Marcin", 1);
        player2 = new Player("Werka", 2);
        player3 = new Player("NULL", 3);
        player4 = new Player("NULL", 4);
        players = new Player[] { player1, player2, player3, player4 };
        int playerCountTempHandling = 4;
        settingPlayersActivity(playerCountTempHandling);
        dealCardsToActivePlayers();
        System.out.println("p1 : " + player1.hand.cardsInHand.size());
        System.out.println("p2 : " + player2.hand.cardsInHand.size());
        System.out.println("p3 : " + player3.hand.cardsInHand.size());
        System.out.println("p4 : " + player4.hand.cardsInHand.size());
    }

    public void settingPlayersActivity(int numberOfPlayers) {
        player1.setAtPlay();
        player2.setAtPlay();
        if (numberOfPlayers >= 3) {
            player3.setAtPlay();
        }
        if (numberOfPlayers == 4) {
            player4.setAtPlay();
        }

        for (Player check : players) {
            if (check.isPlaying()) {
                activePlayers.add(check);
            }
        }
    }

    public void dealCardsToActivePlayers() {
        Deck deck = new Deck();
        Stack<Card> stack = new Stack<>();
        for (Card card : deck.cards) {
            stack.add(card);
        }
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                break;
            }
            for (Player check : activePlayers) {
                check.hand.addToHand(stack.pop());
            }
        }
    }
}
