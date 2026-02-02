public class Player {
    Hand hand;
    boolean playing;
    int id;
    String name;

    public Player(String name, int id) {
        this.name = name;
        this.playing = false;
        this.id = id;
        this.hand = new Hand();
    }

    public void setAtPlay() {
        playing = true;
    }

    public boolean isPlaying(){
        return playing;
    }
}
