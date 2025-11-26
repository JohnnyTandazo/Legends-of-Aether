// EnemyCreature.java
public class EnemyCreature {
    // Atributos Privados
    private String name;
    private EnemyType type; // Uso de Enum obligatorio (para getThreatLevel)
    private ElementType weakness; // La debilidad del enemigo (para la lógica elemental)
    private int attackPower;
    private int health;

    // Constructor
    public EnemyCreature(String name, EnemyType type, ElementType weakness, int attackPower) {
        this.name = name;
        this.type = type;
        this.weakness = weakness;
        this.attackPower = attackPower;
        this.health = 80; 
    }

    // GETTERS CLAVE
    public String getName() {
        return name;
    }
    
    public int getHealth() {
        return health;
    }
    
    public ElementType getWeakness() { // <-- Usado en el combate elemental
        return weakness;
    }
    
    public EnemyType getType() { 
        return type;
    }
    
    // Comportamiento: Atacar
    public void attack(PlayerCharacter target) {
        System.out.println(name + " (" + type.getThreatLevel() + ") ataca a " + target.getName());
        target.setHealth(target.getHealth() - attackPower);
        System.out.println(target.getName() + " recibió " + attackPower + " de daño. Vida restante: " + target.getHealth());
    }

    // Comportamiento: Recibir Daño (usa ElementType)
    public void receiveDamage(int baseDamage, ElementType incomingDamageType) {
        double multiplier = 1.0;
        
        String myWeaknessName = this.weakness.name(); 
        String incomingTypeName = incomingDamageType.name(); 

        // 1. Comprobación de Súper Efectivo (2.0x)
        if (incomingTypeName.equals(myWeaknessName)) { 
            multiplier = 2.0;
            System.out.println("¡Es Súper Efectivo! Daño crítico.");
        } 
        
        // 2. Comprobación de Resistencia (0.5x)
        else if (incomingTypeName.equals(this.weakness.getStrengthName())) { 
            multiplier = 0.5;
            System.out.println("No es muy efectivo. Daño reducido (Resistencia).");
        }

        int finalDamage = (int) (baseDamage * multiplier);
        this.health -= finalDamage;

        System.out.println(name + " recibió " + finalDamage + " de daño. Vida restante: " + this.health);
        
        // Mensaje de derrota
        if (this.health <= 0) {
            System.out.println("💀 ¡" + name + " ha sido derrotado! Fin del combate.");
        }
    }
}