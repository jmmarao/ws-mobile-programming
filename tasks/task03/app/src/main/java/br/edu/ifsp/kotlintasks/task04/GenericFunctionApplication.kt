package br.edu.ifsp.kotlintasks.task04

fun sum(number1: Int, number2: Int) = number1 + number2

fun concat(string1: String, string2: String): String = "${string1}${string2}"

fun xpto(number1: Int, number2: Int, operation: (Int, Int) -> Int): Int = operation(number1, number2)

fun xpto(string1: String, string2: String, operation: (String, String) -> String): String = operation(string1, string2)

fun main() {
    println(xpto(2, 3, ::sum))
    println(xpto("Jo", "ão", ::concat))
}