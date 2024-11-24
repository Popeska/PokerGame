import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
    private List<Card> cards; // This should include both player cards and community cards

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public HandEvaluation evaluateHand() {
        // Implement hand evaluation logic here
        // For simplicity, let's just check for high card and pairs

        Map<String, Integer> rankCounts = new HashMap<>();
        boolean isFlush = isFlush();
        boolean isStraight = isStraight();

        for (Card card : cards) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
        }

        // Check for pairs, three of a kind, etc.
        int pairs = 0;
        int threeOfAKind = 0;
        int quads = 0;
        int fullHouse = 0;

        for (int count : rankCounts.values()) {
            if (count == 2) {
                pairs++;
                if(threeOfAKind > 0){
                    fullHouse++;
                }
            } else if(count == 3 && pairs > 0){
                fullHouse++;
            } else if (count == 3) {
                threeOfAKind++;
            } else if (count == 4){
                quads++;
            }
        }

        // Evaluate hand based on poker rules
        if (isFlush && isStraight) {
            return new HandEvaluation("Straight Flush", 1000);
        } else if(quads > 0){
            return new HandEvaluation("Four of a Kind", 900);
        } else if(fullHouse > 0){
            return new HandEvaluation("Full House", 700);
        } else if (isFlush) {
            return new HandEvaluation("Flush", 600);
        } else if (isStraight) {
            return new HandEvaluation("Straight", 500);
        } else if (threeOfAKind > 0) {
            return new HandEvaluation("Three of a Kind", 400);
        } else if (pairs > 1) {
            return new HandEvaluation("Two Pair", 300);
        } else if (pairs == 1) {
            return new HandEvaluation("One Pair", 200);
        } else {
            return new HandEvaluation("High Card", 1); // Default
        }
    }

    private boolean isFlush() {
        // Check if 5 cards have the same suit
        Map<String, Integer> suitCounts = new HashMap<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (Card card : cards) {
            suitCounts.put(card.getSuit(), suitCounts.getOrDefault(card.getSuit(), 0) + 1);
        }
        for(String suit : suits){
            int count = suitCounts.getOrDefault(suit, 0);
            if(count > 4){
                return true;
            }
        }
        return false;
    }

    private boolean isStraight() {
        // This is a simplified version; a full implementation would handle Ace high/low
        // Sort the cards by rank and check for consecutive values
        List<Integer> rankValues = new ArrayList<>();
        for (Card card : cards) {
            rankValues.add(card.getRankNumber());
        }

        Collections.sort(rankValues);

        int count = 0;
        // Check for consecutive values
        for (int i = 1; i < rankValues.size(); i++) {
            if (rankValues.get(i) != rankValues.get(i - 1) + 1) {
                count = 0;
            } else{
                count++;
            }
            if(count == 4){
                return true;
            }
        }
        return false;
    }

    public static int compareHands(Hand winnerHand, Hand challengerHand, List<Card> communityCards) {
        // Combine the winner's hand with community cards
        List<Card> winnerCompleteHand = new ArrayList<>(winnerHand.getCards());
        winnerCompleteHand.addAll(communityCards);
        Hand completeWinnerHand = new Hand(winnerCompleteHand);

        // Combine the challenger's hand with community cards
        List<Card> challengerCompleteHand = new ArrayList<>(challengerHand.getCards());
        challengerCompleteHand.addAll(communityCards);
        Hand completeChallengerHand = new Hand(challengerCompleteHand);

        // Evaluate both hands
        HandEvaluation winnerEvaluation = completeWinnerHand.evaluateHand();
        HandEvaluation challengerEvaluation = completeChallengerHand.evaluateHand();

        // Compare hand values first
        if (winnerEvaluation.getHandValue() != challengerEvaluation.getHandValue()) {
            return Integer.compare(winnerEvaluation.getHandValue(), challengerEvaluation.getHandValue());
        }

        // If hand values are the same, compare the high cards directly
        return compareHighCards(completeWinnerHand, completeChallengerHand);
    }

    private static int compareHighCards(Hand winnerHand, Hand challengerHand) {
        // Sort both hands' cards in descending order based on value
        List<Card> winnerCards = new ArrayList<>(winnerHand.getCards());
        List<Card> challengerCards = new ArrayList<>(challengerHand.getCards());

        winnerCards.sort(Comparator.comparingInt(Card::getRankNumber).reversed());
        challengerCards.sort(Comparator.comparingInt(Card::getRankNumber).reversed());

        // Compare cards one by one
        for (int i = 0; i < Math.min(winnerCards.size(), challengerCards.size()); i++) {
            int comparison = Integer.compare(winnerCards.get(i).getRankNumber(), challengerCards.get(i).getRankNumber());
            if (comparison != 0) {
                return comparison; // Return the comparison result if cards are different
            }
        }
        return 0; // All cards are equal
    }

    private List<Card> getCards() {
        return this.cards;
    }
}