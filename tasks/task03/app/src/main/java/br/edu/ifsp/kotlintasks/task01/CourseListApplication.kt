package br.edu.ifsp.kotlintasks.task01

fun main() {
    val courseList: MutableList<String> = mutableListOf(
        "Mobile Devices Systems",
        "System Analysis and Development"
    )

    courseList.add("Internet Computer Technician")
    courseList.add("Aircraft Maintanence")
    courseList.add("Cell Technician")
    courseList.add("Management Processes")

    var counter: Int = 0
    for (i in 0..courseList.size - 1) {
        if (courseList[i].contains("System")) {
            println("#${counter} - ${courseList[i]}")
            counter++
        }
    }
}