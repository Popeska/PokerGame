import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int chips;

    public Player(String name, int chips) {
        this.name = name;
        this.chips = chips;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getChips() {
        return chips;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void resetHand() {
        hand.clear();
    }

    public void bet(int amount) {
        chips -= amount;
    }

    public void win(int amount) {
        chips += amount;
    }
}