/*
* In Java we cant defined anything outside a class / interface
*
* In Kotlin we can define anything in a file, top level function / classes / variables - Anything
*
* In Java to define a constants, we need to create a static class to define all the constants,
* or use ENUM or can define constants in interface also
*
* In kotlin we can define constants only top-level / companion object, cant
* define in methods / class.
* */
fun main() {
    val carOne = Car("blue", "toyota", 1990)
    val carTwo = Car("blue", "toyota", 1990)
    println(carOne == carTwo)
    println(carOne)

    var carTwoCopy = carTwo.copy()
    println(carTwoCopy)
    var carTwoCopyYearChanged = carTwo.copy(year = 2020) // get copy with change in value
    println(carTwoCopyYearChanged)
    // get a copy by changing the value, no problem if order of defining the
    // parameter changed with respect to primary constructor
    var carTwoCopyOrderChanged = carTwo.copy(model = "ford", color = "Red")
    println(carTwoCopyOrderChanged)

}

class TopLevelClass {
    companion object {
        const val FUNCTION_CONSTANT = 111
    }
}

fun topLevelFunction() {
    println("Top Level Function $topLevelVariable")
    topLevelVariable = 2021
    println("Top Level Constant $TOP_LEVEL_CONSTANT")
}

public var topLevelVariable: Int = 2020

public const val TOP_LEVEL_CONSTANT = 100
/*
* data class are defined to store only states, no functionality or purpose is defined
*
* It has inbuilt implementation for methods (equals(), hashCode(), copy(), toString())
* can override and write our own implementations also.
*
* Data Class Requirements:
* 1. primary constructor should have at-least one parameter
* 2. all primary constructor parameters should be either val / var, should be defined.
* cant have declaration in primary constructor and define with in the class
* Eg: data class Sample(val one : String, two : String) <= Error: two is not defined / in-valid
* 3. data class cant be inner classes / abstract / sealed
* 3. can define parameters with in the data class apart from primary constructor,
* but the inbuilt methods(equals()..) wont include those variables. have to override
* and use the variables and to provide the functionality
*
* */
data class Car(val color: String, val model: String, val year: Int) {

}
