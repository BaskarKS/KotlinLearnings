package loops.expressions

/*
In kotlin, If&Else can evaluate to a value. Kotlin doesn't have ternary operator
*/
fun main() {
    val condition = 30 > 50
    //CASE-1
    val num = if (condition) 50 else 593
    // can use if/else normal conditional check or can use as a expression and return a value,
    // last statement in block should return a value if we use a block and want if/else as expression
    println(num)

    //CASE-2
    println()
    if (condition)
        println("Condition is True")
    else
        println("Condition is False")

    //CASE-3
    println()
    val num2 = if (condition) {
        println("if Block, condition is True")
        100
    }
    else {
        println("Else Block, condition is False")
        0
    }
    println("Checking If/Else Blocks - $num2")

/*
    //CASE-4
    val num4 = if (condition) {
        println("Should have else block, when 'if' is used as expression to return value")
        println("Because, when 'if' fails there will be no value to assign. Should have Else block")
    }
    println(num4)
*/

    //CASE-5
    println()
    println(if (condition) {
                    println("in 'If block - Expression")
                    50
                }
                else {
                    println("In Else Block - Expression")
                    550
                })

    //CASE-6
    println()
    println()
    println("Some  value ${if (condition) {
        println("in 'If block - Expression")
        555
    }
    else {
        println("In Else Block - Expression")
        999
    }}")


    //CASE-7 - 'if' expression return Unit value
    println()
    println()
    val getUnit = if (condition)
                                println("in If Expression")
                            else
                                println("in else Expression")
    println(getUnit)
    println(getUnit is Unit)
}