import java.util.Arrays;
import java.util.List;

public class TestHandEvaluation {

    public static void main(String[] args) {
        testHighCard();
        testOnePair();
        testTwoPair();
        testThreeOfAKind();
        testStraight();
        testFlush();
        testFullHouse();
        testFourOfAKind();
        testStraightFlush();
    }

    public static void testHighCard() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "2", 2),
                new Card("Diamonds", "3", 3),
                new Card("Clubs", "5", 5),
                new Card("Spades", "9", 9),
                new Card("Hearts", "Jack", 11)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("High Card".equals(evaluation.getHandName()) && evaluation.getHandValue() == 1) {
            System.out.println("testHighCard: Passed");
        } else {
            System.out.println("testHighCard: Failed");
        }
        System.out.println("Expected: " + 1 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testOnePair() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "3", 3),
                new Card("Diamonds", "3", 3),
                new Card("Clubs", "5", 5),
                new Card("Spades", "9", 9),
                new Card("Hearts", "Jack", 11)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("One Pair".equals(evaluation.getHandName()) && evaluation.getHandValue() == 200) {
            System.out.println("testOnePair: Passed");
        } else {
            System.out.println("testOnePair: Failed");
        }
        System.out.println("Expected: " + 200 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testTwoPair() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "3", 3),
                new Card("Diamonds", "3", 3),
                new Card("Clubs", "5", 5),
                new Card("Spades", "5", 5),
                new Card("Hearts", "Jack", 11)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("Two Pair".equals(evaluation.getHandName()) && evaluation.getHandValue() == 300) {
            System.out.println("testTwoPair: Passed");
        } else {
            System.out.println("testTwoPair: Failed");
        }
        System.out.println("Expected: " + 300 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testThreeOfAKind() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "3", 3),
                new Card("Diamonds", "3", 3),
                new Card("Clubs", "3", 3),
                new Card("Spades", "5", 5),
                new Card("Hearts", "Jack", 11)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("Three of a Kind".equals(evaluation.getHandName()) && evaluation.getHandValue() == 400) {
            System.out.println("testThreeOfAKind: Passed");
        } else {
            System.out.println("testThreeOfAKind: Failed");
        }
        System.out.println("Expected: " + 400 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testStraight() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "10", 10),
                new Card("Diamonds", "Jack", 11),
                new Card("Clubs", "Queen", 12),
                new Card("Spades", "King", 13),
                new Card("Hearts", "Ace", 14)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("Straight".equals(evaluation.getHandName()) && evaluation.getHandValue() == 500) {
            System.out.println("testStraight: Passed");
        } else {
            System.out.println("testStraight: Failed");
        }
        System.out.println("Expected: " + 500 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testFlush() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "2", 2),
                new Card("Hearts", "5", 5),
                new Card("Hearts", "8", 8),
                new Card("Hearts", "10", 10),
                new Card("Hearts", "Jack", 11)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("Flush".equals(evaluation.getHandName()) && evaluation.getHandValue() == 600) {
            System.out.println("testFlush: Passed");
        } else {
            System.out.println("testFlush: Failed");
        }
        System.out.println("Expected: " + 600 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testFullHouse() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "3", 3),
                new Card("Diamonds", "3", 3),
                new Card("Clubs", "3", 3),
                new Card("Spades", "5", 5),
                new Card("Hearts", "5", 5)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("Full House".equals(evaluation.getHandName()) && evaluation.getHandValue() == 700) {
            System.out.println("testFullHouse: Passed");
        } else {
            System.out.println("testFullHouse: Failed");
        }
        System.out.println("Expected: " + 700 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testFourOfAKind() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "3", 3),
                new Card("Diamonds", "3", 3),
                new Card("Clubs", "3", 3),
                new Card("Spades", "3", 3),
                new Card("Hearts", "5", 5)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("Four of a Kind".equals(evaluation.getHandName()) && evaluation.getHandValue() == 900) {
            System.out.println("testFourOfAKind: Passed");
        } else {
            System.out.println("testFourOfAKind: Failed");
        }
        System.out.println("Expected: " + 900 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }

    public static void testStraightFlush() {
        List<Card> cards = Arrays.asList(
                new Card("Hearts", "10", 10),
                new Card("Hearts", "Jack", 11),
                new Card("Hearts", "Queen", 12),
                new Card("Hearts", "King", 13),
                new Card("Hearts", "Ace", 14)
        );
        Hand hand = new Hand(cards);
        HandEvaluation evaluation = hand.evaluateHand();

        if ("Straight Flush".equals(evaluation.getHandName()) && evaluation.getHandValue() == 1000) {
            System.out.println("testStraightFlush: Passed");
        } else {
            System.out.println("testStraightFlush: Failed");
        }
        System.out.println("Expected: " + 1000 + "     Actual: " + evaluation.getHandValue());
        System.out.println();
    }
}