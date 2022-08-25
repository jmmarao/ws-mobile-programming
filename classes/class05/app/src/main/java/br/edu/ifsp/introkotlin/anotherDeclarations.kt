package br.edu.ifsp.introkotlin

fun main() {
    var name: String = "Moon"
    var lastName = "MCU"

    // Values require declare the attribute type
    val midName: String
    midName = "Knight"

    val height: Float = 1.71f
    val weight: Double = 80.toDouble() //80.0

    var age: Int = 29

    println("Nome: $name $midName $lastName, Age: $age\n   Height (m): $height, Weight (kg): $weight")
}