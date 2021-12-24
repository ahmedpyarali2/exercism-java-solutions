public enum BlackjackDecisions {
    STAND("S"),
    HIT("H"),
    SPLIT("P"),
    WIN("W");

    private String decision;

    BlackjackDecisions(String s) {
        this.decision = s;
    }

    public String getDecision() {
        return decision;
    }
}
