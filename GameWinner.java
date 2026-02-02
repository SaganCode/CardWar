public class GameWinner {
    Player winner;
    private boolean wonTheGame;

    public GameWinner() {
        winner = new Player("YetToBeDecided", -10);
        wonTheGame = false;
    }

    public void setWinner(Player player){
        this.wonTheGame = true;
        this.winner = player;
    }

    public boolean checkIfWon(){
        return this.wonTheGame;
    }
}
