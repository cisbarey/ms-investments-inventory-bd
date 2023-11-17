package mx.com.actinver.ms.enums;

public enum RiskValue {
    CONSERVATIVE("Conservador"),
    MODERATE("Moderado"),
    AGGRESSIVE("Agresivo");

    private String risk;

    private RiskValue(String risk){
        this.risk = risk;
    }

    public String getRisk() {
        return risk;
    }

    @Override
    public String toString() {
        return risk;
    }
}
