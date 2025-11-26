// EnemyType.java
public enum EnemyType {
    ELEMENTAL("Media", "Ataca a distancia con elementos y tiene resistencia elemental."),
    BESTIA("Baja", "Carga y ataca de cerca sin estrategia, se distrae fácil.");

    private final String threatLevel;
    private final String behaviorDescription;

    // Constructor para inicializar los campos
    EnemyType(String threatLevel, String behaviorDescription) {
        this.threatLevel = threatLevel;
        this.behaviorDescription = behaviorDescription;
    }

    // Métodos públicos (Getters)
    public String getThreatLevel() {
        return threatLevel;
    }

    public String getBehaviorDescription() {
        return behaviorDescription;
    }
}