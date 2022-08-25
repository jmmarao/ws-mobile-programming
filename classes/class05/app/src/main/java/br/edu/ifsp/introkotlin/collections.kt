package br.edu.ifsp.introkotlin

fun main() {
    // List and MutableList
    // var family = listOf("Hulk", "Thor", "Scarlet Witch", "She Hulk", "Moon Knight")
    var family: List<String> = listOf("Hulk", "Thor", "Scarlet Witch", "She Hulk", "Moon Knight")

    for (person in family) {
        println(person)
    }
    println("-----------------------")

    family = listOf("Iron Man", "Ant Man", "Black Panther")

    for (person in family) {
        println(person)
    }
    println("-----------------------")

    val integerList1: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (i in 0..9) {
        println(integerList1[i])
    }
    println("-----------------------")


    val integerList2: List<Int> = (1..10 step 2).toList()
    for (i in 0..integerList2.size - 1) {
        println(integerList2[i])
    }
    println("-----------------------")
    integerList2.forEach { println(it) }

    println("-----------------------")
    integerList2.forEachIndexed() { index, value -> println("$index - $value") }

    println("-----------------------")
    val courseList: MutableList<String> = mutableListOf(
        "Web Programming",
        "Computing Topics",
        "Mobile Programming"
    )
    courseList.add("Object Oriented Programming")
    courseList.add("Database")
    courseList.forEach { println(it) }
    println("-----------------------")

    val courseSet: MutableSet<String> = mutableSetOf("Spring Boot", "ReactJS")
    courseSet.add("Spring Boot")
    courseSet.add("Spring Boot")
    courseSet.add("ReactJS")
    courseSet.add("Network")
    courseSet.forEach { println(it) }
    println("-----------------------")

    val familyMap: MutableMap<String, String> = mutableMapOf(
        Pair("DAD", "Dad name"),
        Pair("MOM", "Mom name"),
        Pair("SON1", "Son1 name"),
        Pair("SON2", "Son2 name"),
    )

    // familyMap.put("Pet", "Pet name")
    familyMap["PET"] = "Pet name"

    familyMap.keys.forEach { println("$it - ${familyMap[it]}") }
}