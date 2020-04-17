package generics

import java.math.BigDecimal

/*
even for function parameters, generics are erased at runtime.
 when a function accepts a parameter with a generic type,
 there's no way to determine which type the generic type parameter holds.

*/
fun main() {
    val genericList = mutableListOf<Any>(1, 1,5f, "hello", BigDecimal(10.1), "Hai")
    val strList = getElementsOfSpecificType<String>(genericList)
    for (str in strList)
        println(str)
}

// function wants to iterate through a generic list and return T type elements
fun<T> getElementsOfType(list: List<Any>):List<T> {
    var newList = mutableListOf<T>()
    for (element  in list) {
/*
        if (element is T) { // this check is not possible as Type T is erased at runtime
                                    // to check for a Type parameter at runtime, have inline with reified type parameter function
            newList.add(element)
        }
*/
    }
    return newList
}

//benefits of Inline Function
// 1. when a function has lambda parameter, function is replace inline where its called
// 2. when function has generic type as parameter and inline function can be reified

// Reification is kotlin feature to prevent the TYPE to be erased at runtime

// To check the type of value passed from a generic parameter passed in a function,
// make function inline and specify the TYPE as reified
inline fun<reified T> getElementsOfSpecificType(list: List<Any>): List<T> {
    var newList = mutableListOf<T>()
    for (element in list) {
        if (element is T) // now the TYPE is not erased at compile time
            newList.add(element)
    }
    //val typeInstance: T = T() //// cant create a instance of TYPE T with in a function
    // compiler thinks the line as function invocation instead of new instance creation
    return newList
}
// reification is needed only to check a particular TYPE inside a function which has generic data
// reification cant be done on class properties and non-inline functions
// cant create a instance of TYPE T with in a function

// Reification need: check the type T with in a function and function should be inline