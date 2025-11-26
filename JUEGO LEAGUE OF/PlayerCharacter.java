// PlayerCharacter.java
import java.util.ArrayList;
import java.util.List;

public class PlayerCharacter {
    // Atributos Privados (Encapsulamiento)
    private String name;
    private CharacterType type;
    private int level;
    private int experience;
    private int health;
    private int maxHealth;
    private int mana;
    private int maxMana; // Necesario para setMana
    private int attackPower;
    
    // Relación con otras clases
    private List<Spell> knownSpells;
    private List<CollectibleObject> inventory; 

    public PlayerCharacter(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.experience = 0;
        this.maxHealth = 100;
        this.health = 100;
        this.maxMana = 50; // Inicialización de maxMana
        this.mana = 50;
        this.attackPower = 10;
        this.knownSpells = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    // ============================================
    // Getters y Setters (Implementación de Encapsulamiento)
    // ============================================
    
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMana() { return mana; } // 
    public int getLevel() { return level; }
    public int getAttackPower() { return attackPower; }
    public List<Spell> getKnownSpells() { return knownSpells; }
    
    // Setter de Vida (Controlado)
    public void setHealth(int health) {
        this.health = Math.max(0, health);
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
    
    // Setter de Maná (Controlado) 
    public void setMana(int mana) {
        this.mana = Math.max(0, mana);
        if (this.mana > this.maxMana) {
            this.mana = this.maxMana;
        }
    }
    
    // ============================================
    // Comportamientos y Lógica del Juego (Abstracción)
    // ============================================
    
    public void gainExperience(int amount) {
        this.experience += amount;
        if (this.experience >= this.level * 100) {
            levelUp();
        }
    }
    
    private void levelUp() {
        this.level++;
        this.experience = 0;
        this.maxHealth += 20;
        this.maxMana += 10;
        this.attackPower += 5;
        this.health = this.maxHealth;
        this.mana = this.maxMana;
        System.out.println("🎉 ¡" + name + " subió al Nivel " + level + "!");
    }

    public void collectItem(CollectibleObject item) {
        this.inventory.add(item);
        System.out.println(name + " recogió: " + item.getItemName());
    }

    // Función: Atacar (Relación con Spell y EnemyCreature)
    public void castSpell(Spell spell, EnemyCreature target) {
        if (this.mana < spell.getManaCost()) {
            System.out.println(name + " no tiene suficiente maná para usar " + spell.getName() + ".");
            return;
        }

        this.mana -= spell.getManaCost();
        int baseDamage = spell.getDamage() + this.attackPower;
        
        System.out.println("\n" + name + " usa " + spell.getName() + " (Costo: " + spell.getManaCost() + " Maná).");
        target.receiveDamage(baseDamage, spell.getType());
    }
    // Comportamiento: Mostrar estadísticas iniciales
    public void displayStats() {
    System.out.println("--- ESTADÍSTICAS INICIALES ---");
    System.out.println("Clase: " + this.type.name());
    System.out.println("Nivel: " + this.level);
    System.out.println("Vida (HP): " + this.health + "/" + this.maxHealth);
    System.out.println("Maná (MP): " + this.mana + "/" + this.maxMana);
    System.out.println("Ataque Base: " + this.attackPower);
    System.out.println("------------------------------");
}
}