package generics

import java.lang.StringBuilder
/*
Generics are basically a syntactical elements that helps compiler
and user for less error code. it helps compiler to know what type is expected and that
will help to catch errors.

when code run's in JVM, it doesn't have mentioned generic information, its removed
at compile time itself, this is called TYPE-ERASURE

At compile time we may have declared a ArrayList of BigDecimal, but at runtime
JVM will see it as just ArrayList, generics cant be used to do 'Type Checking'

*/
fun main() {
    val ints = listOf<Int>(1, 2, 3, 4)
    convertToInt(ints)
    val shorts = listOf<Short>(11, 12, 13)
    convertToInt(shorts)
    val floats = listOf<Float>(11.1f, 12.2f)
    convertToInt(floats)

    val strings = listOf<String>("a", "b", "c")
    // convertToInt(strings) //error: string doesn't descend or not a subclass of Number

    //StringBuilder satisfies the 2 upperBounds of CharSequence and Appendable
    val builder1 = StringBuilder("stringOne")
    val builder2 = StringBuilder("stringTwo")
    append(builder1, builder2)

    //Conclusion 2 : Checking TYPE-CHECKING
    println("Checking Type-Checking")
    //evaluated at compile time itself, compiler is aware that 'string' is List<String>
    if (strings is List<String>) // is equivalent to instanceOf
        println("is used to check instanceOf, this is evaluated by compiler not at runtime")

    val listAnyType = listOf<Any>("Hello", "Hai", 10)
//    if (listAnyType is List<String>) // now compiler cant determine, and cant be done at runtime also because type is erased
//        println("is used to check instanceOf, this is not evaluated by compiler and also not at runtime. due to type erasure")

    // to check listAnyType is at-least a 'list' type without using generics
    // using "Star Projection Syntax"
    if (listAnyType is List<*>)
        println("listAnyType is a List type")


        if (listAnyType is List<*>) {
            val strList = listAnyType as List<String>
            println("TypeCasted generic to String type : ${strList[0].toUpperCase()}")
        }

    val listIntAny = listOf(1, 2, 3)
    if (listIntAny is List<*>) { //compiler just assumes listIntAny is some List
        // possible to typecast to specific type, but can lead to ClassCastException
        val strList = listIntAny as List<String> // compiler allows that listIntAny can be string list
//        println("TypeCasted generic to String type : ${strList[0].toUpperCase()}") // runtime we get
        // java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String
    }

}

//function to convert any number to an Integer
/*
Here T is of Type 'Any?' => every class descends from type Nullable Any - 'Any?'
fun<T> convertToInt(collection: List<T>) {
    for (number in collection) {
        println("${number.toInt()}") // there's no guarantee that value will be integer convertible type
    }
}
*/

//CASE-1
// this function accepts list of elements which are subclass of Number type
fun<T:Number> convertToInt(collection: List<T>) { // T=> type is restricted to Number type
    for (number in collection) {
        println("${number.toInt()}") // there's guarantee that value will be integer convertible type
    }
}

//CASE-2
// use 'where' to mention the type parameters are more than one decedents type
// T can be CharSequence or Appendable - 2 upperbounds defined.
// Can have any number of interfaces in upperbound but we can have
// only one class in UpperBound, more than one class defined is error
//eg: fun<T> append(item1:T, item2:T) where T: CharSequence, T:Appendable, T:StringBuilder, T:StringBuffer{ //Only one of the upper bounds can be a class
fun<T> append(item1:T, item2:T) where T: CharSequence, T:Appendable, T:StringBuilder{
    println("Result is ${item1.append(item2)}")
}


//CASE3
// by default T accepts of type 'Any?' - we can pass Nullable as well as Non-Nullable types
fun<T> printAny(collection: List<T>) {

}
//to restrict that Type can be Any but it accepts only non-Nullable values
fun <T:Any> printAnyButOnlyNonNullableValues(collection: List<T>) {

}

