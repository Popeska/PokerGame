public class HandEvaluation {
    private String handName;
    private int handValue;
    public HandEvaluation(String handName, int handValue){
        this.handName = handName;
        this.handValue = handValue;
    }

    public String getHandName() {
        return handName;
    }

    public int getHandValue() {
        return handValue;
    }

    @Override
    public String toString() {
        return handName + " (Value: " + handValue + ")";
    }
}
