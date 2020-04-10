package loops.expressions

// Range is a type which is a interval with start and end value, can be used with ForLoop and
// with variables

fun main() {
    val intRange = 1..10 // include start and End Value
    for (index in intRange)
        println(index)

    //can have range for char and string (both of them are comparable)
    val charRange = 'a'..'z'
    for (each in charRange)
        print("$each ")

    println()
    val stringRange = "ABD".."XYZ"
    // for (each in stringRange) // string range doesn't have an iterator
    println("CCC" in stringRange)
    println("XYZ" in stringRange)
    // we use 'in' to find a value in a range

    println('a' in intRange)

}

