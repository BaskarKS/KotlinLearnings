package loops.expressions

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.math.BigDecimal

// kotlin doesn't distinguish checked and unchecked exceptions, no need to declare a
// function to 'throw' exception

// 1. using try - catch as expression
// 2. use try{} without catch block
// 3. better way to handle try catch using elvis operator ?:
/*
//CASE-1 : return values from try - catch, using try-catch as expressions

fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
    catch (e: NumberFormatException) {
        0
    }
    finally {
        println("In Finally")
        1 // finally will never return a value/anything, it just avoids it. Because Always
           // finally gets executed there's no possibility that it can return a value, if it
           // returns only that value will get returned always
    }
}
*/

/*
//CASE-2 : without catch block
fun getNumber(str: String): Int {
    return try {
        Integer.parseInt(str)
    }
    finally {
        println("In Finally")
    }
}
*/

//CASE-3: Using Elvis to Handle exception
fun getNumber(str: String): Int? {
    return try {
        Integer.parseInt(str)
    }
    catch (e: NumberFormatException) {
        null
    }
    finally {
        println("In Finally")
    }
}

fun main() {
    println(getNumber("22"))
//    println(getNumber("22.5")?: throw IllegalArgumentException("Not a valid input")) // not
    // a better way to handle a exception
    println(getNumber("22.5")?: "Not a valid input to Parse into Integer") // better way
    // to handle a exception

    //makeCalculation(BigDecimal(11.5))
}

// when a function never return anything / always throws exception will return 'Nothing'
fun makeCalculation(someInput: BigDecimal):Nothing {
    println("Unimplemented method called")
    throw IllegalAccessException("Method not implemented yet, doesn't return anything")
}
