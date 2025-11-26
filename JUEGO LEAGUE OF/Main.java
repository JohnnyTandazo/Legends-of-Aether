import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // ===============================================
        //  1. CONFIGURACIÓN INICIAL Y PREPARACIÓN
        // ===============================================
        
        // Variables fijas que simulan la personalización y las elecciones del usuario 
        String heroName = "MOISES EL HERMANO DE TWITCH ";
        CharacterType initialType = CharacterType.HECHICERO;
        int pathChoiceNivel1 = 2; // Simula: Elegir Combate (2)
        int pathChoiceNivel3 = 1; // Simula: Elegir Objeto (1)
        
        // --- INSTANCIACIÓN DEL PERSONAJE ---
        // ¡CAMBIO AQUÍ! La variable ahora es 'heroe'
        PlayerCharacter heroe = new PlayerCharacter(heroName, initialType);
        
        System.out.println("=============================================");
        System.out.println("  INICIANDO SIMULACIÓN DE LEGENDS OF AETHER");
        System.out.println("=============================================");
        System.out.println("Héroe creado: " + heroe.getName() + " como " + initialType.name());

        // LLAMADA PARA MOSTRAR ESTADÍSTICAS
        heroe.displayStats(); 

        // --- DEFINICIÓN DE RECURSOS ---
        Spell fireBlast = new Spell("Explosión de Fuego", 20, 10, ElementType.FUEGO);
        heroe.getKnownSpells().add(fireBlast); 
        
        CollectibleObject healthPotion = new CollectibleObject(
            "Poción de Vida Mayor", ItemRarity.RARO, "Restaura 50 de vida al instante.", 50, 0
        );
        CollectibleObject legendarySword = new CollectibleObject(
            "Espada Legendaria", ItemRarity.LEGENDARIO, "Objeto de victoria.", 0, 0
        );

        // --- DEFINICIÓN DE LOS 4 NIVELES ---

        // Nivel 1: Debilidad a Fuego
        EnemyCreature plantBeast = new EnemyCreature("Bestia de Raíces", EnemyType.BESTIA, ElementType.FUEGO, 8); 
        Level level1 = new Level(
            1, "Entrada al Bosque", "El camino se bifurca. Escucha el rugido de las bestias...", 
            Arrays.asList(plantBeast), healthPotion
        );

        // Nivel 2: Introduce Resistencia
        EnemyCreature windElemental = new EnemyCreature("Elemental del Aire", EnemyType.ELEMENTAL, ElementType.NATURALEZA, 12); 
        Level level2 = new Level(
            2, "Río Profundo", "La niebla cubre el río. Las criaturas elementales son hostiles.", 
            Arrays.asList(windElemental), healthPotion
        );
        
        // Nivel 3: Recolección
        EnemyCreature fireWyrm = new EnemyCreature("Gusano de Fuego", EnemyType.BESTIA, ElementType.HIELO, 20); 
        Level level3 = new Level(
            3, "Cuevas Ardientes", "El calor es insoportable. Este lugar está lleno de bestias de fuego.", 
            Arrays.asList(fireWyrm), healthPotion
        );

        // Nivel 4 (Jefe Final)
        EnemyCreature finalBoss = new EnemyCreature("JEFE FINAL: El Dragón", EnemyType.ELEMENTAL, ElementType.HIELO, 50);
        Level level4 = new Level(
            4, "Cima de la Montaña", "Has llegado a la cima. El aire es denso y el Dragón te espera.", 
            Arrays.asList(finalBoss), legendarySword
        );
        
        // ===============================================
        //  2. SIMULACIÓN DE PROGRESIÓN NARRATIVA
        // ===============================================
        
        // --- Nivel 1: Simulación de Combate Súper Efectivo ---
        level1.startLevelNarrative();
        System.out.println("[SIMULACIÓN]: Opciones: 1. Objeto / 2. Combate.");
        
        if (pathChoiceNivel1 == 2) {
            System.out.println("[RUTA ELEGIDA]: **Seguir el rastro de huellas.** (Demuestra Relación de Combate)");
            
            EnemyCreature target = level1.getLevelEnemies().get(0);
            
            // Uso de heroe.getName() y heroe.castSpell()
            System.out.println(">>> ¡ENEMIGO ENCONTRADO! Vas a combatir contra: " + target.getName() + 
                               " (" + target.getType().getThreatLevel() + ")");
            
            heroe.castSpell(fireBlast, target); 
            
            if (target.getHealth() > 0) { 
                target.attack(heroe); // El enemigo ataca al objeto 'heroe'
            }
        }
        heroe.gainExperience(100); 
        System.out.println("\n--- PROGRESIÓN: El héroe encontró el camino al siguiente nivel. ---");

        // --- Nivel 2: Simulación de Resistencia y Subida de Nivel ---
        level2.startLevelNarrative();
        heroe.gainExperience(50); // Causa subida a Nivel 2
        
        System.out.println("\n--- COMBATE CONTRA ELEMENTAL DEL AIRE (Demuestra Resistencia) ---");
        EnemyCreature elementalTarget = level2.getLevelEnemies().get(0);
        System.out.println(">>> ENEMIGO: " + elementalTarget.getName() + " (Débil a " + elementalTarget.getWeakness().name() + ")");
        heroe.castSpell(fireBlast, elementalTarget);
        
        System.out.println("\n--- PROGRESIÓN: El héroe está más fuerte. Nivel: " + heroe.getLevel() + " ---");

        // --- Nivel 3: Simulación de Recolección de Objeto ---
        level3.startLevelNarrative();
        System.out.println("[SIMULACIÓN]: Opciones: 1. Objeto / 2. Combate.");
        
        if (pathChoiceNivel3 == 1) {
            System.out.println("[RUTA ELEGIDA]: **Investigar el cofre.** (Demuestra Recolección)");
            
            CollectibleObject reward = level3.getLevelReward();
            System.out.println(">>> ¡RECOMPENSA ENCONTRADA! Es un objeto de Rareza: " + reward.getRarity().name());
            
            heroe.collectItem(reward);
            reward.useItem(heroe); // El objeto afecta al objeto 'heroe'
        }
        heroe.gainExperience(100); 

        // --- Nivel 4: Jefe Final y Relación Final ---
        System.out.println("\n*** SIMULACIÓN DE AVANCE DE ZONA ***");
        level4.startLevelNarrative();
        
        System.out.println("\n--- COMBATE FINAL CONTRA EL DRAGÓN ---");
        EnemyCreature finalTarget = level4.getLevelEnemies().get(0);
        System.out.println(">>> ENEMIGO: " + finalTarget.getName() + " (Amenaza: " + finalTarget.getType().getThreatLevel() + ")");
        heroe.castSpell(fireBlast, finalTarget); 
        
        System.out.println("\n--- FIN DE LA SIMULACIÓN ---");
    }

}
