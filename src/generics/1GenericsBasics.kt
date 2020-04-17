package generics

import java.math.BigDecimal

/*
We use generics to give compiler a hint about the type of objects we deal with. It helps
compiler to do more error checks at compile time.

Generics avoid to make typecasting often, make code cleaner and catch errors at compile time
itself.

Generics used as parameters and return values of functions, declarations, collections.

Generics can also be used in return type of functions, can be used to
declare generic classes and interfaces

*/

fun main() {
/*
* in Kotlin we have to specify the type of collection compulsorily
in declaration we have to specify the type compulsorily
in definition we have to give values, compiler will determine the type from values
* */
    // val list: MutableList // its error, have to specify the type
    val list: MutableList<String>
    list = mutableListOf("Hello")
    //or
    val listWithValue = mutableListOf("Check") // compiler will infer from the value
    listWithValue.add("more")
    //with functions
    printString(listWithValue) // no issues because function expects a string list.

    val bdList = mutableListOf<BigDecimal>(BigDecimal(10.5), BigDecimal(11.1))
    //printString(bdList) // error, because the function expect/accept a string list
    printCollection(bdList) // this function accepts any type

    println("Checking extension function in Generic format")
    bdList.printValues()
    println()
    list.printValues()
    println()
    listWithValue.printValues()
}

fun printString(collection: List<String>) {
    for (item in collection)
        println(item)
}

//generic function
fun<T> printCollection(collection: List<T>) {
    for (each in collection)
        println(each)
} // T is type

// writing a generic function for List as extension function

fun<T> List<T>.printValues() { // this method can be called in any list, its extension function
    for (item in this)
        println(item)
}