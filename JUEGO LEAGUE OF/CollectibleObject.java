// CollectibleObject.java
public class CollectibleObject {
    private String itemName;
    private ItemRarity rarity;
    private String effectDescription;
    private int healthEffect;
    private int manaEffect;

    public CollectibleObject(String name, ItemRarity rarity, String effect, int healthEffect, int manaEffect) {
        this.itemName = name;
        this.rarity = rarity;
        this.effectDescription = effect;
        this.healthEffect = healthEffect;
        this.manaEffect = manaEffect;
    }

    public String getItemName() {
        return itemName;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    // Comportamiento de Uso (Relación con PlayerCharacter)
    public void useItem(PlayerCharacter character) {
        System.out.println("\n--- USANDO " + itemName + " (" + rarity.name() + ") ---");
        
        // Aplicar efectos usando los setters controlados del personaje
        if (healthEffect != 0) {
            int newHealth = character.getHealth() + healthEffect;
            character.setHealth(newHealth);
            System.out.println("Salud de " + character.getName() + " se ajustó en: " + healthEffect + ". Actual: " + character.getHealth());
        }
        
        if (manaEffect != 0) {
            int newMana = character.getMana() + manaEffect;
            character.setMana(newMana);
            System.out.println("Maná de " + character.getName() + " ajustado en: " + manaEffect + ". Actual: " + character.getMana());
        }
        
        System.out.println("Efecto: " + effectDescription);
    }
}