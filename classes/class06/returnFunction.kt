package ads.pdm.myapplication

enum class OperationType {
    ADD, MUL, DIV, SUB
}

fun div(number1: Int, number2: Int) = number1 / number2

fun operate(operation: OperationType) = when (operation) {
    OperationType.ADD -> { x, y -> x + y } // lambda
    OperationType.MUL -> fun(a, b): Int = a * b // incognito function
    OperationType.DIV -> ::div // classic
    OperationType.SUB -> { number1: Int, number2: Int -> number1 - number2 } // function variable
}

//    when (operation) {
//        OperationType.ADD -> return { x, y -> x + y } // lambda
//        OperationType.MUL -> return fun(a, b): Int = a * b // incognito function
//        OperationType.DIV -> return ::div // classic
//        OperationType.SUB -> return sub // function variable
//    }

fun Int.apply(i: Int, f: (Int, Int) -> Int) = f(this, i)

fun main() {
    println("ADD: " + 10.apply(2, operate(OperationType.ADD)))
    println("SUB: " + 10.apply(2, operate(OperationType.SUB)))
    println("MUL: " + 10.apply(2, operate(OperationType.MUL)))
    println("DIV: " + 10.apply(2, operate(OperationType.DIV)))
}