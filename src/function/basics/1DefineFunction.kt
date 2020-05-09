package function.basics

/*
* function defined as member of class is called methods or member functions
*
* fun function_name(parameters) : return-type {
* }
*
* default return type is Unit, if no return-type is mentioned, Unit is returned.
* */

fun main() {
    val arg1 = 10
    val arg2 = 20
    val label = "product result is : "
    println(labelMultiply(label, arg1, arg2))
    println(labelMultiplySimplified("simplified product : ", arg1, arg2))

    println()
    printPassed("Some data to Print")
    println("sum is : ${sum(11,12)}")

    val personObj = Person("baskar k s")
    println(personObj.inUppercase()) // in Upper case is member function

    println()
    println(labelMultiply(10 , 2)) // label is defined with default value
    println(labelMultiply(10 , 2, "Result is : "))

    //CASE-6
    // can call the function with parameters in any order using argument names(argTwo / label).
    // if one argument is out of order, other parameter names should be used compulsorily
    // this methodology is best, because of better documentation
    println(labelMultiply(argTwo = 10 , label = "Changed Order, Result is : ", argOne = 2))
    println(labelMultiply(2, argTwo = 10, label = "Original Order, Result is : "))
}

// with curly braces, this function has "block body"
fun labelMultiply(label:String, valOne: Int, valTwo: Int): String {
    return "$label(${valOne * valTwo})"
}

//CASE-1
//function contain single expression and return some value, simplified as
// without curly braces, this function has "expression body"
fun labelMultiplySimplified(label:String, valOne: Int, valTwo: Int): String  = "$label ${valOne * valTwo}"

//CASE-2
// function returns Unit, println() returns Unit - But println() is not expression
fun printPassed(sentence:String) = println(sentence)

//CASE-3
//no need to mention return type, compiler can infer it based on right side of expression
fun sum(arg1:Int, arg2:Int) = arg1 + arg2

//CASE-4
// all class member functions are 'public and final' by default
// we have to open it to override or extend it
class Person(private val fullName: String) {
    fun inUppercase() = fullName.toUpperCase() // this function has expression body,
                                                                                // its public and final by default
}

//CASE-5
// providing default values to function params,
// type should be compulsorily mentioned for value parameters
// (label is value parameter here - its  type is String)
fun labelMultiply(argOne: Int, argTwo: Int, label: String = "Product is : ") =
                                                                "$label ${argOne * argTwo}"