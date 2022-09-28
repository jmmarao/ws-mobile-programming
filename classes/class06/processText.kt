package ads.pdm.myapplication

fun processText(
    string1: String, string2: String,
    process: (String, String) -> String
): String = process(string1, string2)

fun concat(str1: String, str2: String): String = "$str1$str2"

//fun concat(str1: String, str2: String): String {
//    // return "${str1 + str2}"
//    return "$str1$str2"
//}

fun inverse(str1: String, str2: String) = "${str2.reversed()}${str1.reversed()}"

fun main() {
    println(processText("Hello, ", "World", ::concat))
    println(processText("Hello, ", "World", ::inverse))
    println(
        processText(
            "Hello, ",
            "World",
            { a, b -> "${a.uppercase()}${b.uppercase()}" })
    )
    println(
        processText(
            "Hello, ",
            "World",
            fun(a: String, b: String): String { return "${a.lowercase()}${b.lowercase()}" })
    )

    // if last parameters is a function you can use lambda expression directely
    // val lambdaExpression = { a: String, b: String -> "${a.uppercase()}${b.uppercase()}" }
    // println(processText("Hello, ",,,,,,,,,,,,,,,,,,,,,,,,"World", lambdaExpression))

    println(processText("Hello, ","World", { a: String, b: String -> "${a.uppercase()}${b.uppercase()}" }))
}