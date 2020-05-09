package academy.learnprogramming.anothermodule

import checking.packages.academy.learnprogamming.anotherpackage.topLevel // importing top level function from another module
import list // i/[mporting type Alias from another module
import Department.HR // importing only HR enum value from another module
import function.basics.upperCaseFirstAndLastChar
//import function.basics.upperCaseFirstAndLastCharSimple // cannot access its internal

fun main() {
    println(topLevel("\"From Another Module\""))
    val listOfString = ArrayList<String>()
    listOfString.add("Baskar")
    listOfString.add("Geetha")
    listOfString.add("Jashi")
    //importing typealias
    printList(listOfString)

    //importing Enum
    println(HR.getDeptInfo())

    //importing Extension function
    val makeFirstLastCaps = "america"
    println(makeFirstLastCaps.upperCaseFirstAndLastChar())
}

fun printList(data: list) {
    for (each in data) {
        println(each)
    }
}