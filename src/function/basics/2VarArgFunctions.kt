package function.basics
/*
* var-args - variable number of arguments
*
* vararg is keyword used in function parameters to define that
*  the function accepts variable number of arguments
*
* 3 cases:
* 1. a function can have maximum of single vararg argument, more than one
* vararg parameter is error.
* 2. var-arg argument being the last parameter of function
* 3. vararg argument not being as last parameter of function.
* */
fun main() {
    var car1 = Car("Black", "Honda", 1990)
    var car2 = Car("Blue", "Ford", 2020)
    var car3 = Car("Red", "Toyota", 1998)
    checkVarArgs(car1, car2, car3)

    // case 2: since var-arg is being as last parameter, the starting values passed are
    // first assigned to fixed params, rest is passed to var-args. No conflict here for compiler

    val carOne = "Toyota"
    val carTwo = "Honda"
    val carThree = "Maruti"
    val carType = "Sedan"
    varArgsAsLastParam(carType, carOne, carTwo, carThree)
    varArgsAsLastParam(carOne, carType, carTwo, carThree)

    // case-3 : since vararg is defined as first parameter, compiler dont understand at
    // which all passed value it has to consider for vararg parameter.
    //Hence its compulsory to define other parameters as named values like carType below
    varArgsAsFirstParam(carOne, carTwo, carThree, carType = carType)

    // even varargs is middle parameter, no need to define first parameter as named value
    // compiler can allocate the first value passed to first parameter and the following parameters
    // to var-args, compiler gets confused to which passed parameter it has to stop considering
    // for var-args parameter, hence its compulsory to define parameters followed after var-args
    // as named parameters
    val carOwner = "First"
    varArgsAsMiddleParam(carOwner, carOne, carTwo, carThree,carType = carType)

    // var-args followed by different type needs named-value?
    // it needs to be named type, compiler will face error if it interprets other type for var-args
    varArgsAsFirstParamFollowByDifferentType(carOne, carTwo, carThree, price = 100000)
}

data class Car(val color: String, val model: String, val year: Int) {

}

fun checkVarArgs(vararg cars: Car) {
    for (car in cars) {
        println("${car.color}")
    }
}
/*
//case 1: more than one var-arg parameters is error
fun moreVarArgs(vararg cars:Car, price: Int, vararg moreCars:Cars) {

}
*/
//case 2: var-arg as last parameter defined for the function
fun varArgsAsLastParam(carType: String, vararg cars: String) {

    println("\nfun varArgsAsLastParam()")
    println("Car Type is : $carType")
    for (car in cars) {
        println(car)
    }
}

fun varArgsAsFirstParam(vararg cars:String, carType: String) {

    println("\nfun varArgsAsFirstParam()")
    println("Car Type is : $carType")
    for (car in cars) {
        println(car)
    }
}

fun varArgsAsMiddleParam(carOwner: String, vararg cars:String, carType: String) {

    println("\nfun varArgsAsMiddleParam()")
    println("Car Owner is : $carOwner")
    println("Car Type is : $carType")
    for (car in cars) {
        println(car)
    }
}

fun varArgsAsFirstParamFollowByDifferentType(vararg cars:String, price: Int) {
    println("\nfun varArgsAsFirstParamFollowByDifferentType()")
    println("Car Price is : $price")
    for (car in cars) {
        println(car)
    }
}