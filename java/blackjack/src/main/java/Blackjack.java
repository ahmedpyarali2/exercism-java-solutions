import java.util.HashMap;
import java.util.Map;

public class Blackjack {

    private final Map<String, Integer> cardValue = new HashMap<>() {
        {
            put("ace", 11);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("ten", 10);
            put("jack", 10);
            put("queen", 10);
            put("king", 10);
        }
    };

    public int parseCard(String card) {
        return cardValue.getOrDefault(card, 0);
    }

    public boolean isBlackjack(String card1, String card2) {
        int cardValue1 = cardValue.getOrDefault(card1, 0);
        int cardValue2 = cardValue.getOrDefault(card2, 0);
        return cardValue1 + cardValue2 == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        String decision = BlackjackDecisions.SPLIT.getDecision();

        if (isBlackjack) {
            if (dealerScore != cardValue.get("ace") && dealerScore != cardValue.get("ten")) {
                decision = BlackjackDecisions.WIN.getDecision();
            } else {
                decision = BlackjackDecisions.STAND.getDecision();
            }
        }
        return decision;
    }

    public String smallHand(int handScore, int dealerScore) {
        String decision;

        if (handScore >= 17) {
            decision = BlackjackDecisions.STAND.getDecision();
        } else if (handScore <= 11) {
            decision = BlackjackDecisions.HIT.getDecision();
        } else {
            if (dealerScore >= 7) {
                decision = BlackjackDecisions.HIT.getDecision();
            } else {
                decision = BlackjackDecisions.STAND.getDecision();
            }
        }

        return decision;
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
