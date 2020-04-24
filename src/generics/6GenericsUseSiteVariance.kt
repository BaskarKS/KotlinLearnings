package generics

fun main() {
    val carsOne = mutableListOf<Car>(Car(), Car())
    val carsTwo: MutableList<Car> = mutableListOf()
    copyCars(carsOne, carsTwo)

    val fordOne = mutableListOf(Ford(), Ford())
    val fordTwo: MutableList<Ford> = mutableListOf()
    copyCars(fordOne, fordTwo)

    copyCars(fordOne, carsTwo)
    val carHolder : MutableList<Car> = mutableListOf(Ford(), Ford())
    // able to assign Ford to Car type, assigning subclass type to its parent type
}

//using covariance and contravariance in this individual function (use-site declaration)
// rather defining during class or interface declaration
//use-site covariant and contravariant is also called "Type projection"

// good use of this use-site variant is when working working with third party class
// thats invariant writing a function that use instances
// of class which are invariant and use it in a covariant way
// in java we use list List<? extends Car> - covariant in method declarations
// in java we use list List<? super Ford> - contravariant in method declarations
fun<T> copyCars(source: MutableList<out T>, dest: MutableList<in T>) {
    for (car in source) {
        dest.add(car)
    }
}

open class Car {

}

class Ford: Car() {

}

class Toyota: Car() {

}