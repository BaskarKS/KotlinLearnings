import java.lang.RuntimeException

fun main(args: Array<String>) {
    var value = 123 // only for Int no need to explicitly define the type of variable
    var charValue: Char = 'a'
    var byteValue: Byte = 10
    var longValue: Long = 111
    var floatValue: Float = 1.1f

    //byteValue = value // automatic wideing of numbers is not possible in kotlin

    // apart from int and double, explicitly need to mention the value type or variable type

    byteValue = value.toByte() // need to call explicit methods to change value of desired type

    val newValue = 5
    //even value 5 fits in byte itself, in kotlin by default every integer value is considered
    // as Int and the value is widened to store in Int variable type

    println(value is Int)
    println(newValue is Int)

    // Double is the default datatype of floating values
    var defaultFloat = 10.5
    println(defaultFloat is Double)
    println(defaultFloat.to(Float))

    //to create Float variable 1 way - have to mention value with f suffix
    var floatTypeOne = 10.5f
    println(floatTypeOne is Float)

    //Char data type
    //can be created 2 ways
    //1
    var charTypeOne: Char = 'a'
    var charTypeTwo = 'b'
    println("is charTypeOne is character ${charTypeOne is Char}")
    println("is charTypeTwo is character ${charTypeTwo is Char}")

    var charInInt = 65
    println("is charInInt is Int ${charInInt is Int}")
    var charTypeThree = charInInt.toChar()
    println("is charTypeThree is character ${charTypeThree is Char}")

    var boolTypeOne = true
    var boolTypeTwo: Boolean = false
    println("is boolTypeOne is boolean ${boolTypeOne is Boolean}")

    // if methods parameters / return value is primitive boolean in Java method,
    // from kotlin we can still call those methods by passing Boolean class value from
    // kotlin, it works because of java has boxing and unboxing feature

    // Three Important classes
    // 1. Any - Base class of all classes like Object class in Java, has implementation of
    // equals(), HashCode(), toString() methods

    // 2. Unit class - Its used as return of methods in kotlin like void in java, void
    // doesn't return anything, but Unit is a singleton class return an instance of
    // unit instance on return. if a function doesn't return any meaningful value
    // and No return type is mentioned in function definition, Unit is returned
    // by default

    //3. Nothing class - its used to mention the kotlin compiler that the function
    // will never return, like if the function contains infinite loop and will never return
    // or always throws exception, such functions are defined to compiler using nothing class

}

fun neverReturnTypeOne() : Nothing{
    while(true) {
        // infinite loop
    }
}

fun neverReturnTypeTwo() : Nothing{
    // this function will always throw exception
    throw IllegalAccessException()
}

fun signalError():Nothing {
    throw RuntimeException()
}

fun someOperation() {
    val map = HashMap<Int, String>()
    map[10] = "Hai"
    val value = map[20] ?: signalError()
    signalError()
    val  x = 10 // we get warning that this line of code is unreachable
}