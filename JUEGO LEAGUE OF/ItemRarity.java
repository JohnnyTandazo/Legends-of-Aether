// ItemRarity.java
public enum ItemRarity {
    COMUN(70, "Baja utilidad, fácil de encontrar.", 10), 
    RARO(20, "Mejora atributos menores, moderada dificultad.", 50),
    LEGENDARIO(5, "Otorga una habilidad única, extremadamente difícil.", 200);

    private final int dropChance;
    private final String description;
    private final int value;

    ItemRarity(int dropChance, String description, int value) {
        this.dropChance = dropChance;
        this.description = description;
        this.value = value;
    }

    public int getDropChance() {
        return dropChance;
    }

    public String getDescription() {
        return description;
    }
    
    public int getValue() {
        return value;
    }
}