package objectkeyword

/*
"Object Expression" also meant as "Anonymous Objects"
we use this technique wherever we are in need of Anonymous class
*/
interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun passSomeInterface(si: SomeInterface) {
    println("In passSomeInterface() - ${si.mustImplement(123)}")
}

/*

//CASE - 1
fun main() {
    // passing Anonymous object implementation or object expression, this object instance
    // is not singleton, just single instance created and used and discarded

    val someLocal = 10
    var someString = "Hello"
    passSomeInterface(object: SomeInterface{
        override fun mustImplement(num: Int) =
                    "Returning from mustImplement() - ${num * 10} - $someLocal - $someString"
    })
    //object expression can access outside local variables outside
}
*/

/*
//CASE-2 -> Access / change local variables outside object expressions
fun main() {
    var someLocal = 10
    val someString = "Hello"
    println("In Main - $someLocal")
    passSomeInterface(object: SomeInterface{
        override fun mustImplement(num: Int): String {
            someLocal++
            return "Returning from mustImplement() - ${num * 10} - $someString"
        }
    })
    println("In Main - $someLocal")
}
*/

/*
//CASE-3 -> use a variable to hold object expression
fun main() {
    //below local variables used in object expression, should be defined above/before
    // object expression definition
    var someLocal = 10
    val someString = "Hello"
    val implementationInterface = object: SomeInterface{
        override fun mustImplement(num: Int): String {
            someLocal++
            return "Returning from mustImplement() - ${num * 10} - $someString"
        }
    }
    println("In Main - $someLocal")
    passSomeInterface(implementationInterface)
    println("In Main - $someLocal")
}
*/

//CASE-4 -> checking implement multiple interface
interface AdditionalInterface {
    fun checkAdditional(value: Int):String
}

fun main() {
    //below local variables used in object expression, should be defined above/before
    // object expression definition
    var someLocal = 999
    val someString = "Hello"
    //check is <anonymous object : SomeInterface, AdditionalInterface>
    val check = object: SomeInterface, AdditionalInterface {
        override fun mustImplement(num: Int): String {
            println("mustImplement() - $someLocal")
            return "mustImplement - $num"
        }

        override fun checkAdditional(value: Int): String {
            println("checkAdditional() - $someString")
            return "checkAdditional - $value"
        }
    }
    println(check.checkAdditional(11))
    println(check.mustImplement(12))
}
