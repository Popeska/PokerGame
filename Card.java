public class Card {
    private String suit; // e.g., "Hearts", "Diamonds"
    private String rank; // e.g., "2", "3", ..., "10", "Jack", "Queen", "King", "Ace"
    private int rankNumber; // e.g., 1, 2, 3 ..., 10, 11, 12(Queen), 13(King), 14(Ace)

    public Card(String suit, String rank, int rankNumber) {
        this.suit = suit;
        this.rank = rank;
        this.rankNumber = rankNumber;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
    public int getRankNumber(){
        return rankNumber;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}