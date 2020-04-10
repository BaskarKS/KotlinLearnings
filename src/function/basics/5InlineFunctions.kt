package function.basics

/*
* if a function is defined 'inline' , the function is compiled in a way that its substituted for
* the function call. its not called as function call.
*
* inline is often done on function expects a lambda expression for the parameter,
* (under the covers, lambdas has an overhead of creation of class and an object) this
* overhead is avoided when the function is made inline.
*
* functions are inlined which depend on "how function parameters are used"
* even if a function is not  requested to be a inline function,
* JVM will optimize functions when its required to optimize
*
* 'inline' keyword should be added before fun keyword to request a function to be an
* inline function
* */
fun main() {
    var arg1 = 11
    var arg2 = 12
    var result = labelProduct(arg1, arg2)
    println(result)
}

inline fun labelProduct(argOne: Int, argTwo: Int, label: String = " Result is ")
        = "$label ${argOne * argTwo}"