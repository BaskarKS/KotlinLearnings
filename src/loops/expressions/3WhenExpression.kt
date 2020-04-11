package loops.expressions

import java.math.BigDecimal


fun main() {
    // 'when' will be used in-place of switch case/ it has lot of features and flexibility

    //CASE-1 - 'when' used with constant value passed
 var num = 200
/* when(num) {
        100 -> println("selected 100")
        200 -> println("selected 200")
        300 -> println("selected 300")
        else -> println("none of the above matched") //else is optional here, can remove it
    }
    println("when used with value $num")
*/

/*
    //CASE-2 - 'when' used with multiple constant as cases
    num = 600
    when(num) {
        100, 600 -> println("selected 100 or 600")
        200 -> println("selected 200")
        300, 900 -> println("selected 300 or 900")
        else -> println("none of the above matched")
    }
    println("when used with value $num")
*/
/*
    //CASE-3 - can use ranges for a case, should use 'in' with ranges
    num = 450
    when(num) {
        in 100..600 -> println("selected 100 or 600")
        200 -> println("selected 200")
        300, 900 -> println("selected 300 or 900")
        else -> println("none of the above matched")
    }
    println("when used with value $num")
*/

/*
    //CASE-4 - can use expression for a case
    num = 450
    val someValue = 50
    when(num) {
        in 100..400 -> println("selected 100 or 600")
        400 + 50 -> println("selected ${num + 50}") // expression, not a hard constant
        200 -> println("selected 200")
        300, 900 -> println("selected 300 or 900")
        else -> println("none of the above matched")
    }
    println("when used with value $num")
 */

/*
    //CASE-5 - can do a way of smartCasting and perform a action
    val something:Any = 45
    when(something) {
        is String -> println("passed is String ${something.toUpperCase()}") // smart-cast
                                            // happened hence type specific operation can be performed inside
        is Int -> println("passed in Integer ${something * 10}")
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
    }
    println("passed parameter is  $something")
*/

/*
    //CASE-5 - 'when' used as expression
    val something:Any = "45"
    val typeValue = when(something) {
        is String -> {println("passed is String ${something.toUpperCase()}") // smart-cast
        // happened hence type specific operation can be performed inside
                              something as String
                               }
        is Int -> {
                        println("passed in Integer ${something * 10}")
                        something as Int
                    }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            something as BigDecimal
        }
        else -> println("No idea about the type") //else case is compulsory as 'when' is used as expression
    }
    println("passed parameter is  $typeValue")
*/

/*
    //CASE-5 - 'when' used as expression
    val something:Any = "45"
    val typeValue = when(something) {
        is String -> {println("passed is String ${something.toUpperCase()}") // smart-cast
            // happened hence type specific operation can be performed inside
            1
        }
        is Int -> {
            println("passed in Integer ${something * 10}")
            2
        }
        is BigDecimal -> {
            println(something.remainder(BigDecimal(10.5)))
            3
        }
        else -> {
            println("No idea about the type")
            999
        } //else case is compulsory as 'when' is used as expression
    }
    println("passed parameter is  $typeValue")
*/

/*
    //CASE-6 - enum passed in when expression
    val seasonOfYear = Seasons.SUMMER
    val str = when(seasonOfYear) {
        Seasons.SUMMER -> seasonOfYear.seasonInfo()
        Seasons.WINTER -> seasonOfYear.seasonInfo()
        Seasons.AUTUMN -> seasonOfYear.seasonInfo()
        Seasons.FALL -> seasonOfYear.seasonInfo() // we have mention all season in when
        // cases if we miss to mention a season, then we should implement 'else' case
    }
    println("selected season is $seasonOfYear and the info is '$str'")
*/

/*
    //CASE-7 - conditions in when cases
    val first = 10
    val second = 5
    when {
        first > second -> println("First Number $first is greater than second number $second")
        first < second -> println("First Number $first is smaller than second number $second")
        else -> println("Both the numbers are equal")
    }
*/
}

enum class Seasons (val info: String){
    SUMMER("Its very Hot"),
    WINTER("Its very Cold"),
    AUTUMN("Flowers are blooming"),
    FALL("Its getting cooler");
    fun seasonInfo(): String = info
}