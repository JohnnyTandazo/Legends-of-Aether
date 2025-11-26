// Level.java
import java.util.List;

public class Level {
    private String name;
    private String levelDescription;
    private int levelNumber;
    private List<EnemyCreature> levelEnemies; 
    private CollectibleObject levelReward; 
    
    public Level(int levelNumber, String name, String description, List<EnemyCreature> enemies, CollectibleObject reward) {
        this.levelNumber = levelNumber;
        this.name = name;
        this.levelDescription = description;
        this.levelEnemies = enemies;
        this.levelReward = reward;
    }

    public int getLevelNumber() {
        return levelNumber;
    }
    
    public void startLevelNarrative() {
        System.out.println("\n=============================================");
        System.out.println("ZONA " + levelNumber + ": " + name.toUpperCase());
        System.out.println("=============================================");
        System.out.println(levelDescription);
    }

    public CollectibleObject getLevelReward() {
    return levelReward;
    }
    public List<EnemyCreature> getLevelEnemies() {
    return levelEnemies;
    }
}