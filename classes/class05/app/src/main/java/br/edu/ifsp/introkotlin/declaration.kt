package br.edu.ifsp.introkotlin

fun main() {
    // To declare constant (val from value) or variable (var from variable)
    var phrase: String = "Hello world!"
    val phraseConst: String = "Test Dev"

    println(phrase)

    phrase = "World Hello!"
    // phraseConst = "Testing" - error because values can't be modified

    // String templates
    println("$phrase")
    println("${phrase.uppercase()}")
    println("String characters: ${phrase.count()}")
    println("String characters: ${phrase.length}")
}