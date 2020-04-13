package lambdas

import java.lang.StringBuilder

fun main() {
    // Normal Function
    println(Receivers.Companion.countTo100())
    // using with function
    println(countTo100EnhanceOne())
    // using the receiver object of lambda, with will convert the passed instance into a
    // receiver object and pass it to the lambda
    println(countTo100EnhanceTwo())

    // referring member function  of the receiver object directly
    println("Type three : ${countTo100EnhanceThree()}")

    //more concise code
    println("Type Four : ${countTo100EnhanceFour()}")
    // more concise code , changed into expression
    println("Type Five : ${countTo100EnhanceFive()}")
}

class Receivers {
    companion object {
        fun countTo100():String {
            val numbers = StringBuilder()
            for (count in 1..99) {
                numbers.append(count)
                numbers.append(", ")
            }
            numbers.append(100)
            return numbers.toString()
        }
    }
}

fun countTo100EnhanceOne():String {
    // we use 'with' function which accepts an StringBuilder instance and a lambda
    // since the lambda is the last parameter of the 'with' function we can remove parenthesis
    // of 'with' function. With in lambda we don't need to refer the instance when we want to
    // invoke the instance member functions, can call the member functions and properties
    // directly
    val numbers = StringBuilder()
    return with(numbers) {
        for (i in 1..99) {
            numbers.append(i)
            numbers.append(", ")
        }
        numbers.append(100)
        return numbers.toString()
    }
}

fun countTo100EnhanceTwo():String {
    // "with" converts the instance passed into it as a receiver inside the lambda,
    // don't have to refer to the receiver object with the instance name, we can use 'this'
    // or we can directly refer the instance member function and properties
    val numbers = StringBuilder()
    return with(numbers) {
        for (i in 1..99) {
            this.append(i)
            this.append(", ")
        }
        this.append(100)
        this.toString()
    }
}


fun countTo100EnhanceThree():String {
    // "with" converts the instance passed into it as a receiver inside the lambda,
    // don't have to refer to the receiver object with the instance name, we can directly
    // refer the instance member function and properties
    val numbers = StringBuilder()
    return with(numbers) {
        for (i in 1..99) {
            append(i)
            append(", ")
        }
        append(100) // directly referring the member function of the receiver object which is String Builder Obj
        toString() // last statement is the return value
    }
}


    fun countTo100EnhanceFour():String {
        // more concise code
        return with(StringBuilder()) {
            for (i in 1..99) {
                append(i)
                append(", ")
            }
            append(100) // directly referring the member function of the receiver object which is String Builder Obj
            toString() // last statement is the return value
        }
    }


    fun countTo100EnhanceFive():String  =  with(StringBuilder()) {
            for (i in 1..99) {
                append(i)
                append(", ")
            }
            append(100) // directly referring the member function of the receiver object which is String Builder Obj
            toString() // last statement is the return value
    }
