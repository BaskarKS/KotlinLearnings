package lambdas

import java.lang.StringBuilder

fun main() {
    // apply() works the same way as with() function but it always return the receiver object
    println("checking apply() : ${countTo100()}")
}

// we don't pass an instance like we do in "with", we use an instance and call "apply" on that
// apply {} is a lambda, the StringBuilder instance is passed as receiver object inside
// lambda, apply should always return the receiver type object which is StringBuilder
fun countTo100() = StringBuilder().apply {
                                        for (number in 1..99) {
                                            append(number)
                                            append(", ")
                                        }
                                        append(100)
                                  }.toString()
// if the function does is to just return a value, not need a block body can be converted into
// a expression body. here the apply block will always return the instance on which it is
// called which is stringBuilder object and hence countTo100() implemented as expression body