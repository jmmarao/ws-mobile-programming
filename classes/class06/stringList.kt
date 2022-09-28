package ads.pdm.myapplication

fun <T, R> List<T>.forEahType(function: (T) -> R): List<R> {
    val list: MutableList<R> = mutableListOf()

    for (item in this) {
        list.add(function(item))
    }
    return list.toList()
}

fun List<String>.forEachString(function: (String) -> String): List<String> {
    val stringList: MutableList<String> = mutableListOf()

    for (str in this) {
        stringList.add(function(str))
    }
    return stringList.toList()
}

fun firstLetter(word: String): String {
    return word.first().toString()
}

fun main() {
    val names: List<String> = listOf("Thor", "Scarlet Witch", "Black Panther")
    val letters: List<String> = names.forEahType(::firstLetter)
    val upperList = names.forEachString { it.uppercase() }

    letters.forEach(::println)
    upperList.forEach { println(it) }

    val numbers = listOf(1, 2, 3, 4, 5)
    val negativeNumbers = numbers.forEahType { it * -1 }
    negativeNumbers.forEach { println(it) }

    val floatList: List<Float> = numbers.forEahType { it.toFloat() }
    floatList.forEach { println(it) }
}