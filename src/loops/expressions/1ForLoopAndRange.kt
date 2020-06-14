package loops.expressions

// Range is a type which is a interval with start and end value, can be used with ForLoop and
// with variables

fun main() {
    /*
    val intRange: IntRange = 1..10 // include start and End Value
    for (index in intRange)
        println(index)

    //can have range for char and string (both of them are comparable)
    val charRange = 'a'..'z'
    for (each in charRange)
        print("$each ")
    println('a' in charRange)
    println()
    val stringRange = "ABD".."XYZ"
    // for (each in stringRange) // string range doesn't have an iterator
    println("CCC" in stringRange)
    println("XYZ" in stringRange)
    // we use 'in' to find a value in a range

    // using 'in' in Range, type of value should be comparable with value in range
    // println('a' in intRange) // char cant be compared with Integer values in Range

    */
/*
Error:(22, 17) Kotlin: Type inference failed. The value of the type parameter T
     should be mentioned in input types (argument types, receiver type or expected type).
     Try to specify it explicitly.
*/

    //GET DOWN RANGE
    println("Checking Down range")
    val backRange = 5.downTo(1)
    val back = 5 downTo 1 // not correct way to create down range,
    val reversed = back.reversed()
    for (value in back)
        print("$value ")
    println()
    // below faculties on range can be applied only on char and Int, cant be on Strings

    // "step(), downTo(), reversed(), until" are used with Ranges

    // step, until and downTo can be used as function on a range, or can be used as keyword on
    // value eg: 10 downTo 1,
    // reversed() is used on range value

    for (each in (1..10).reversed().step(3))
        print("$each ")

    println()
    // IntRange
    val avoidLast = -10 until 10 //prints from -10 to 9
    val rangeDownTo = 0 downTo -10 step 2
    val stepRange = 100..150 step 5
    val stepRangeReversed = (200..250).reversed().step(10)
    val sameStepAbove = 250 downTo 200 step 10
    println("Step range Reversed :")
    for (each in stepRangeReversed)
        print("$each ")

    println()
    println("Avoiding end value in Range")
    for (each in avoidLast)
        print("$each ")

    println("Negative Range - count is ${rangeDownTo.count()}")
    for (each in rangeDownTo)
        print("$each ")

    val someString = "December"
    val createStringRange = 0..someString.length
    val stringRangeReverse = createStringRange.reversed()

    // Ranges on Array
    val seasons = arrayOf("Spring", "Summer", "Winter", "Fall")
    println()
    println("Printing Seasons")
    for (each in seasons)
        println(each)

    val checkIsSeason = "autumn" in seasons
    println("is Autumn is in Seasons list : $checkIsSeason")
    val notInSeasonStatus = "autumn" !in seasons
    println("is Autumn is not in Seasons list : $notInSeasonStatus")

    val rangeOfFifty = 0..50
    val someValue = -10
    val checkInRange = someValue in rangeOfFifty
    val checkNotInRange = someValue !in rangeOfFifty
    println("is Some value is in Range of Fifty : $checkInRange")
    println("is Some value is Not in Range of Fifty : $checkNotInRange")

    val myName = "BASKAR K S"
    val charInMyName = 'S'
    println("is char '$charInMyName' is present in my Name \"$myName\" : ${charInMyName in myName}")

    println()
    println("Arrays Extension Function")
    println("Index of Arrays")
    for (idx in seasons.indices)
        println("index is $idx and its value is ${seasons[idx]}")

    println()
    println("Access Arrays without loop and without Index")
    seasons.forEach { it -> println("Item in Array : $it") }

    println()
    println("Access Arrays without Loop and With Index")
    seasons.forEachIndexed { index, s -> println("index is $index and its value is $s") }


    println()
    println("Naming Loops and Checking Break")
    outerLoop@ for(i in 1..3) {
        println("i=$i")
        innerLoop@ for (j in 1..4) {
            println("j=$j")
                for (k in 5..10) {
                    println("k=$k")
                    if (k == 7)
                        break@innerLoop // when k reaches 7 break the inner-loop
                                                          // and want control go to outer-loop
                                                        //break@loopName - break mentioned loop name
            }
        }
    }

    println()
    println("Checking Continue")
    outerLoop@ for(i in 1..3) {
        println("i=$i")
        innerLoop@ for (j in 1..4) {
            println("j=$j")
            for (k in 5..10) {
                println("k=$k")
                if (k == 7)
                    continue@outerLoop // when k reaches 7 continue control to outer-loop
                                            //continue@loopName - continue mentioned loop name
            }
        }
    }
}

