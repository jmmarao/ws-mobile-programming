package br.edu.ifsp.kotlintasks.task03

fun sum(number1: Int, number2: Int) = number1 + number2

fun concat(string1: String, string2: String): String = "${string1}${string2}"

fun foo(number1: Int, number2: Int, operation: (Int, Int) -> Int): Int = operation(number1, number2)

fun bar(string1: String, string2: String, operation: (String, String) -> String): String =
    operation(string1, string2)

fun main() {
    println(foo(10, 19, ::sum))
    println(bar("Jo", "nes", ::concat))
}

