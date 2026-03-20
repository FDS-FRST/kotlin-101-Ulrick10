import kotlin.system.measureTimeMillis

/**
 * Exercice 1 : Crée une liste immuable de 5 entiers.
 */
fun ex1CreateImmutableList(): List<Int> {
    return listOf(10, 20, 30, 40, 50)
}

/**
 * Exercice 2 : Crée une liste modifiable de 3 chaînes, puis ajoute un élément.
 */
fun ex2CreateMutableList(): MutableList<String> {
    val list = mutableListOf("pomme", "banane", "cerise")
    list.add("datte")
    return list
}

/**
 * Exercice 3 : Filtre les nombres pairs de 1 à 10.
 */
fun ex3FilterEvenNumbers(): List<Int> {
    val numbers = (1..10).toList()
    return numbers.filter { it % 2 == 0 }
}

/**
 * Exercice 4 : Filtre les âges >= 18 et les transforme en chaînes "Adult: age".
 */
fun ex4FilterAndMapAges(ages: List<Int>): List<String> {
    return ages.filter { it >= 18 }
        .map { "Adult: $it" }
}

/**
 * Exercice 5 : Aplatit une liste imbriquée.
 */
fun ex5FlattenList(): List<Int> {
    val nested = listOf(listOf(1, 2), listOf(3, 4), listOf(5))
    return nested.flatten()
}

/**
 * Exercice 6 : Extrait tous les mots d'une liste de phrases avec flatMap.
 */
fun ex6FlatMapWords(): List<String> {
    val phrases = listOf("Kotlin is fun", "I love lists")
    return phrases.flatMap { it.split(" ") }
}

/**
 * Exercice 7 : Traitement eager (séquence directe) sur une grande liste.
 * Retourne les 5 premiers nombres divisibles par 3, élevés au carré.
 * Affiche le temps d'exécution.
 */
fun ex7EagerProcessing(): List<Int> {
    val numbers = (1..1_000_000).toList()
    val time = measureTimeMillis {
        val result = numbers.filter { it % 3 == 0 }
            .map { it * it }
            .take(5)
        println("Résultat eager : $result")
    }
    println("Temps eager : $time ms")
    // Pour retourner le résultat, on recalcule (ou on stocke la valeur dans une variable)
    return numbers.filter { it % 3 == 0 }
        .map { it * it }
        .take(5)
}

/**
 * Exercice 8 : Traitement lazy avec séquence.
 * Retourne les 5 premiers nombres divisibles par 3, élevés au carré.
 * Affiche le temps d'exécution.
 */
fun ex8LazyProcessing(): List<Int> {
    val numbers = (1..1_000_000).toList()
    val time = measureTimeMillis {
        val result = numbers.asSequence()
            .filter { it % 3 == 0 }
            .map { it * it }
            .take(5)
            .toList()
        println("Résultat lazy : $result")
    }
    println("Temps lazy : $time ms")
    // On recalcule pour retourner la valeur
    return numbers.asSequence()
        .filter { it % 3 == 0 }
        .map { it * it }
        .take(5)
        .toList()
}

/**
 * Exercice 9 : Filtre les noms commençant par 'A', les met en majuscule,
 * les trie alphabétiquement et retourne la liste.
 */
fun ex9FilterAndSortNames(names: List<String>): List<String> {
    return names.filter { it.startsWith('A', ignoreCase = true) }
        .map { it.uppercase() }
        .sorted()
}

/**
 * Fonction principale pour tester tous les exercices.
 */
fun main() {
    println("=== Exercice 1 ===")
    println(ex1CreateImmutableList())

    println("\n=== Exercice 2 ===")
    println(ex2CreateMutableList())

    println("\n=== Exercice 3 ===")
    println(ex3FilterEvenNumbers())

    println("\n=== Exercice 4 ===")
    val ages = listOf(15, 22, 17, 30, 12, 18)
    println(ex4FilterAndMapAges(ages))

    println("\n=== Exercice 5 ===")
    println(ex5FlattenList())

    println("\n=== Exercice 6 ===")
    println(ex6FlatMapWords())

    println("\n=== Exercice 7 ===")
    val result7 = ex7EagerProcessing()
    println("Valeur retournée par ex7 : $result7")

    println("\n=== Exercice 8 ===")
    val result8 = ex8LazyProcessing()
    println("Valeur retournée par ex8 : $result8")

    println("\n=== Exercice 9 ===")
    val names = listOf("Alice", "bob", "Aria", "charlie", "anna", "Bob")
    println(ex9FilterAndSortNames(names))
}