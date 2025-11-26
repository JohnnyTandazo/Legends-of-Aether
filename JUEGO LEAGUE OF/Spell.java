// Spell.java
public class Spell {
    private String name;
    private int damage;
    private int manaCost;
    private ElementType type; // Tipo elemental del hechizo

    public Spell(String name, int damage, int manaCost, ElementType type) {
        this.name = name;
        this.damage = damage;
        this.manaCost = manaCost;
        this.type = type;
    }

    // GETTER CLAVE
    public ElementType getType() {  
        return type;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }
}