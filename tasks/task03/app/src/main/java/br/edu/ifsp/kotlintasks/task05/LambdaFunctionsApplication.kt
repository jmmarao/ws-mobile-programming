package br.edu.ifsp.kotlintasks.task05

fun processIntegers(number1: Int, func: (Int) -> Int): Int {
    return func(number1)
}

fun processIntegers(number1: Int, number2: Int, func: (Int, Int) -> Int): Int {
    return func(number1, number2)
}

fun sum(number1: Int, number2: Int): Int {
    return number1 + number2
}

fun multiply(number1: Int, number2: Int): Int {
    return number1 * number2
}

fun squareRoot(number: Int): Int {
    for (n in 1..number) {
        if (n * n == number) {
            return n
        }
    }
    return -1
}

fun main() {
    println("Calling normal functions")
    println("Sum: ${sum(10, 20)}")
    println("Multiply: ${multiply(10, 20)}")
    println("Square root: ${squareRoot(16)}")
    println("-----------------------")

    println("Calling lambda functions")
    println("Sum: ${processIntegers(10, 20, ::sum)}")
    println("Multiply: ${processIntegers(10, 20, ::multiply)}")
    println("Square root: ${processIntegers(16, ::squareRoot)}")
}