package mx.com.actinver.ms.enums;

public enum VolatilityLevel {
    LOW("Baja"),
    MEDIUM("Media"),
    HIGH("Alta");

    private final String level;

    private VolatilityLevel(String level){
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return level;
    }
}
