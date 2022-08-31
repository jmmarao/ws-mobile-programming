package br.edu.ifsp.kotlintasks.task02

fun main() {
    val familyMap: MutableMap<String, String> = mutableMapOf(
        Pair("Dad", "Pedro"),
        Pair("Mom", "Marcela"),
        Pair("Son", "Jhon"),
        Pair("Youngest son", "Cadu"),
        Pair("Pet", "Paçoca")
    )

    familyMap.keys.forEach {
        println("${it}: ${familyMap[it]}")
    }
}