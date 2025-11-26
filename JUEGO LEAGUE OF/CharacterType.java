// CharacterType.java
public enum CharacterType {
    HECHICERO("Mago de control de masas", "Experto en magia elemental, débil en defensa."),
    GUERRERO("Tanque y daño físico", "Fuerte en combate cuerpo a cuerpo, inicia el combate.");

    private final String combatRole;
    private final String narrativeDescription;

    CharacterType(String combatRole, String narrativeDescription) {
        this.combatRole = combatRole;
        this.narrativeDescription = narrativeDescription;
    }

    public String getCombatRole() {
        return combatRole;
    }

    public String getNarrativeDescription() {
        return narrativeDescription;
    }
}