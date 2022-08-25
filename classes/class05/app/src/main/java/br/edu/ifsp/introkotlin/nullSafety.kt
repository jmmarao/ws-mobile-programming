package br.edu.ifsp.introkotlin

fun main() {
    var name: String
    // name = null

    var lastName: String?
    lastName = null

    var testName = lastName?: "Last Name Test"

    println(lastName?.length)
    println("-----------------------")

    val numberToString: String = 10.toString()
    val numberToDouble: Double = numberToString.toDouble()
    val numberToFloat: Float = numberToDouble.toFloat()
    val numberToInteger: Int = numberToFloat.toInt()
    println(numberToInteger)
    println("-----------------------")

    val any: Any = "Any is a Java Object"
    val string: String = any as String

    if (any is String) {
        println(any.count())
    }
}