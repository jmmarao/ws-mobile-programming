package ads.pdm.myapplication

// fun multiple(number1: Int = 10, number2: Int) = number1 % number2 == 0

fun multiple(number1: Int = 10, number2: Int) = if (number1 % number2 == 0) true else false

fun Int.multipleModified(number2: Int): Boolean {
    return multiple(this, number2)
}

infix fun Int.multipleModifiedAgain(number2: Int): Boolean {
    return multiple(this, number2)
}

fun main() {
    println(multiple(10, 2))
    println(10.multipleModified(2))
    println(10.multipleModifiedAgain(2))
    println(10 multipleModifiedAgain 2)
}