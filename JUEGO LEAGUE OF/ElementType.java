// ElementType.java
public enum ElementType {
    // Definición usando Strings para evitar errores de compilación por referencia cruzada.
    // Orden de argumentos: (Nombre_del_Elemento_Fuerte, Nombre_del_Elemento_Débil, Descripción)
    FUEGO("HIELO", "NATURALEZA", "Daño basado en calor intenso."),
    HIELO("NATURALEZA", "FUEGO", "Daño que ralentiza y congela."),
    NATURALEZA("FUEGO", "HIELO", "Daño orgánico que drena vida.");
    
    private final String strengthName;
    private final String weaknessName;
    private final String description;

    ElementType(String strengthName, String weaknessName, String description) {
        this.strengthName = strengthName;
        this.weaknessName = weaknessName;
        this.description = description;
    }

    public String getWeaknessName() {
        return weaknessName;
    }

    public String getStrengthName() {
        return strengthName;
    }
    
    public String getDescription() {
        return description;
    }
    
    // Método auxiliar para el combate
    public boolean isEffectiveAgainst(ElementType targetType) {
        return this.strengthName.equals(targetType.name()); 
    }
}