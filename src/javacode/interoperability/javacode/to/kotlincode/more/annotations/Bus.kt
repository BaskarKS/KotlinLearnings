package javacode.interoperability.javacode.to.kotlincode.more.annotations

import java.io.IOException

/*
how to access function defined inside companion objects(we use object keyword
to create anonymous object instances

To use companion object functionalities in Java, use "@JvmStatic keyword"
Using @JvmStatic keyword will instruct compiler to generate 2 version of defined
functions, one is with in the companion object instance and a static version that
can be called in Java
*/
// USING @JvmStatic
class Bus(val color: String, val model: String, val year: Int) {
    companion object {
        val isBus: Boolean = true
        @JvmField val nameOfCompanion = "Bus Class Companion"
        const val intConstant = 2020

        fun busComp() = println("In Bus companion object")
        @JvmStatic fun busDirectAccess() = println("In Bus Companion, Access without Companion instance")
    }

    // nobody can restrict to pass this function param as null from Java code
    // kotlin compiler will add code that when this param receives a null value
    // java.lang.IllegalArgumentException is raised. doesn't wait till the param value
    // to be used for NullPointer exception
    fun printThePassedValue(text: String) {
        println("Don't expect the passed param as Null - $text")
    }

    fun doInputOutputOperation() {
        throw IOException()
    }

    @Throws(IOException::class)
    fun alertJavaCheckedException() {
        throw IOException()
    }
}


fun main() {
    Bus.Companion.busComp()
    Bus.busComp()

    defaultArgs("Baskar") // default value for num- 25 used when its not passed
    defaultArgs("Baskar", 99)
    // when this function is called from Java code, compiler expects both the
    // arguments, default value signature cant be used from Java code
}

//kotlin compiler will generate only one version of function signature which
// expects all arguments when called from java, to use the default value signature
// in Java use @JvmOverloads annotation
fun defaultArgs(str: String, num: Int = 25) {
    println("Passed String : $str and number is : $num")
}

@JvmOverloads fun usingDefaultArgsInJava(str: String, num: Int = 100, valid: Boolean = true) {
    println("using Default Arg method signature from Java " +
            " : $str and number is : $num and validity : $valid")
}
//Accessing SingleTonObj
object BusSingletonObj {
    fun doSomething() = println("In Bus -> doSomething of Singleton Obj")
    @JvmStatic fun accessDirect() =
        println("In Bus, Singleton method accessed without INSTANCE")
}