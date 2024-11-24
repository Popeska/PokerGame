import java.util.ArrayList;
import java.util.List;

public class TempGame {
    private Deck deck;
    private List<Player> players;
    private List<Card> communityCards;

    public TempGame() {
        deck = new Deck();
        players = new ArrayList<>();
        communityCards = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        // Example: Deal 2 cards to each player (Texas Hold'em style)
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.addCard(deck.dealCard());
            }
        }
    }

    public void showHands() {
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand: " + player.getHand());
        }
    }

    // Additional methods for betting, determining the winner, etc.

    public static void main(String[] args) {
        TempGame pokerGame = new TempGame();
        pokerGame.addPlayer(new Player("Alice", 100));
        pokerGame.addPlayer(new Player("Bob", 100));
        pokerGame.addPlayer(new Player("Paul", 100));
        pokerGame.addPlayer(new Player("Christian", 100));
        pokerGame.addPlayer(new Player("Cole", 100));
        pokerGame.addPlayer(new Player("Ben", 100));

        pokerGame.preFlop();
        pokerGame.showHands();

        pokerGame.flop();
        //pokerGame.printCards();

        pokerGame.turn();
        //pokerGame.printCards();

        pokerGame.river();
        System.out.println();
        pokerGame.printCards();

        pokerGame.showdown();
        //while(true);
    }

    public void preFlop() {
        startGame(); // Deal hole cards
        // Handle betting logic here
    }

    public void flop() {
        // Deal three community cards
        for (int i = 0; i < 3; i++) {
            communityCards.add(deck.dealCard());
        }
        // Handle betting logic here
    }

    public void turn() {
        // Deal the fourth community card
        communityCards.add(deck.dealCard());
        // Handle betting logic here
    }

    public void river() {
        // Deal the fifth community card
        communityCards.add(deck.dealCard());
        // Handle final betting logic here
    }

    public void showdown() {
        // Evaluate hands and determine the winner
        Player winner = null;
        String bestHand = "";
        int bestValue = 0;

        for (Player player : players) {
            // Combine player's hand with community cards
            List<Card> combinedCards = new ArrayList<>(player.getHand());
            combinedCards.addAll(communityCards); // Add community cards

            Hand hand = new Hand(combinedCards); // Create a new Hand object with combined cards
            HandEvaluation handEval = hand.evaluateHand(); // Evaluate the hand

            if (winner == null || handEval.getHandValue() > bestValue) {
                winner = player;
                bestHand = handEval.getHandName();
                bestValue = handEval.getHandValue();
            } else if(handEval.getHandValue() == bestValue){
                int compare = Hand.compareHands(new Hand(winner.getHand()), new Hand(player.getHand()), communityCards);
                if(compare < 0){
                    System.out.println(winner.getName() + " kicked by " + player.getName());
                    winner = player;
                    bestHand = handEval.getHandName();
                    bestValue = handEval.getHandValue();
                }
            }
        }

        System.out.println("The winner is " + winner.getName() + " with a " + bestHand);
    }

    public void printCards(){
        for(Card c : communityCards){
            System.out.println(c);
        }
        System.out.println();
    }
}

