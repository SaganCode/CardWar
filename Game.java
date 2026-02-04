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
    GameWinner winner;
    Pool pool;

    public void gameStart() {
        winner = new GameWinner();
        player1 = new Player("Marcin", 1);
        player2 = new Player("Werka", 2);
        player3 = new Player("NULL", 3);
        player4 = new Player("NULL", 4);
        players = new Player[] { player1, player2, player3, player4 };
        int playerCountTempHandling = 2;

        settingPlayersActivity(playerCountTempHandling);
        dealCardsToActivePlayers();
        pool = new Pool(activePlayers);

        // while (!winner.checkIfWon()) {
        roundPlay(activePlayers);
        // }

    }

    public void roundPlay(List<Player> activePlayers) {
        for (Player playing : activePlayers) {
            pool.addCardToPool(playing.hand.playCard(), playing, "fight");
        }

        showCardsInPlay();
        WinnerHandler check = pool.fight();
        int roundWinnerId = check.id;
        if (roundWinnerId != -99) {
            for (Player roundWinner : activePlayers) {
                if (roundWinnerId == roundWinner.id) {
                    for (Pair pair : pool.cardsInPlay) {
                        roundWinner.hand.discardedCards.add(pair.card);
                    }
                    pool.cardsInPlay.clear();
                }
            }
            showNumberOfCardsOverall();
        } else {
            pool.war(); // TODO
        }
    }

    public void showCardsInPlay() {
        for (Pair pair : pool.cardsInPlay) {
            System.out.println(pair.card.rank + " of " + pair.card.suit + " p: " +
                    pair.player.id + " function: " + pair.function);
        }
    }

    public void showNumberOfCardsOverall() {
        for (Player player : activePlayers) {
            System.out.println(player.name + " has "
                    + (player.hand.cardsInHand.size() + player.hand.discardedCards.size()) + " cards.");
        }
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
