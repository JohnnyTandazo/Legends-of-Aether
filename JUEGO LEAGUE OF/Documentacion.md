# Diseño y Aplicación de Principios de POO: Legends of Aether

## Integrantes
* Axel Samuel Molineros Mina
* Jeremy Josue Novoa Rodrigez
* Johnny Argely Tandazo Rojas

---

## Introducción y Objetivo del Sistema

El proyecto **Legends of Aether** modela el núcleo lógico de un videojuego utilizando Java, enfocándose rigurosamente en la aplicación de los principios de **Abstracción**, **Encapsulamiento** y **Relación de Clases**.

El código fuente incluye **10 *scripts***, los cuales cumplen con los requisitos de las cuatro clases principales y las tres enumeraciones obligatorias.

---

## 1. Abstracción y Definición de Clases

La abstracción se aplicó para representar las entidades centrándonos únicamente en la información y los comportamientos esenciales para la simulación de juego:

* **`PlayerCharacter` (Personaje Jugador):** Se abstrajo a atributos funcionales (**`health`**, **`mana`**, **`level`**) y comportamientos como **`castSpell`** (atacar) y **`levelUp`** (subir de nivel).
* **`EnemyCreature` (Criatura Enemiga):** Se reduce a su esencia de combate: su amenaza (**`EnemyType`**), debilidad (**`weakness`**) y el comportamiento **`receiveDamage`**.
* **`CollectibleObject` (Objeto Recolectable):** Se abstrae a su valor funcional (**`healthEffect`**, **`manaEffect`**) y su rareza, permitiendo la función **`useItem`**.
* **`Level` (Nivel o Zona):** Se modela a través de una descripción narrativa y su contenido lógico (**`levelEnemies`**, **`levelReward`**).

---

## 2. Implementación de Encapsulamiento

El encapsulamiento es riguroso en todo el sistema para proteger la integridad de los datos, cumpliendo con el requisito de atributos privados y métodos públicos de acceso:

* **Atributos Privados:** Todos los campos clave (**`health`**, **`mana`**, **`name`**, etc.) son declarados como **`private`**.
* **Acceso Controlado:** Usamos métodos **`public`** (**`getters`** y **`setters`**) para interactuar con los datos.
* **Control de Estado:** Los métodos **`setHealth()`** y **`setMana()`** incluyen una lógica de validación interna para asegurar que los valores nunca excedan el máximo ni caigan por debajo de cero.

---

## 3. Uso de Enumeraciones Avanzadas (Enums)

El sistema incluye las tres Enums obligatorias, cada una con campos adicionales privados y métodos públicos para consultarlos, demostrando el uso avanzado de Enums:

* **`CharacterType`:** Contiene el rol de combate y una descripción narrativa, accesibles vía **`getCombatRole()`**.
* **`EnemyType`:** Define el nivel de amenaza y el comportamiento (**`getThreatLevel()`**) de la criatura.
* **`ItemRarity`:** Contiene la probabilidad de obtención y la descripción del valor del objeto.
* **Uso Creativo (`ElementType`):** Se agregó esta Enum extra para modelar la lógica de **fortalezas y debilidades** del combate elemental.

---

## 4. Integración y Relación de Clases

La simulación demuestra la integración de las clases en las siguientes relaciones obligatorias:

* **Combate (`PlayerCharacter` ⇌ `EnemyCreature`):**
    * La llamada **`heroe.castSpell()`** invoca el método **`target.receiveDamage()`**, pasando el tipo elemental como argumento.
    * `EnemyCreature` utiliza este tipo para calcular el daño final (x2, x0.5).

* **Recolección (`CollectibleObject` ⇌ `PlayerCharacter`):**
    * El objeto, al ser usado (**`reward.useItem(heroe)`**), interactúa directamente con los *setters* del héroe (**`heroe.setHealth()`**, **`heroe.setMana()`**) para modificar sus atributos.

* **Nivel y Progresión:** La simulación avanza a través de **cuatro niveles** (Zona 1 a 4), demostrando cómo el personaje (`PlayerCharacter`) gana experiencia y utiliza las entidades del `Level` para progresar.
