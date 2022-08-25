package br.edu.ifsp.introkotlin

fun multiple(number1: Int, number2: Int): Boolean {
    val number3: Int = number1 % number2

    if (number3 == 0) {
        return true
    }
    return false
}

fun Int.multipleModified(number2: Int): Boolean {
    return multiple(this, number2)
}

infix fun Int.multipleModifiedAgain(number2: Int): Boolean {
    return multiple(this, number2)
}

fun main() {
    println(multiple(10, 2))
    println(10.multipleModified( 2))
    println(10.multipleModifiedAgain( 2))
    println(10 multipleModifiedAgain 2)
}