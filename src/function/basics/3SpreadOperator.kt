package function.basics

fun main() {
    val car = Car("black", "Honda", 2020)
    val car1 = Car("brown", "Reva", 2000)
    val car2 = Car("red", "Maruti", 2008)
    val car3 = Car("blue", "Ford", 1999)
    val car4 = Car("green", "Hyundai", 2010)
    val car5 = Car("silver", "Toyota", 2014)
    val manyCars = arrayOf(car, car1, car2)
/*
    printColors(manyCars)
    Type mismatch.
    Required:
    Car
    Found:
    Array<Car>
*/
    // to pass individual elements of array to function
    printColors(*manyCars)
    println()
    val moreCars = arrayOf(car3, car4)
    var lotOfCars = arrayOf(manyCars, moreCars, car5)
    // lotOfCars is Array<Any>
    // lotOfCars[0] is Array<Car>
    // lotOfCars[1] is Array<Car>
    // lotOfCars[2] is Car
    lotOfCars = arrayOf(*manyCars, *moreCars, car5)
    for ( item  in lotOfCars)
        println(item)

    println("************ Just Checking *************")
    var extractCars = lotOfCars.toList().filter { it -> (it as Car).year >= 2010}
    for (car in extractCars)
        println(car)
    println("************ Just Checking *************")

    //to pass the lotOfCars to printColors() function we need to unpack the Array<Car> in lotOfCars
    var totalCars: Array<Car> = arrayOf(*manyCars, *moreCars, car5)
    for ( item  in totalCars)
        println(item)

     // not totalCars contains only Car elements, we can just unpack and pass it to printColors()
    printColors(*totalCars)


    var allCars = lotOfCars.asList().map{ it as Car }.toTypedArray()
    println(allCars is Array<Car>)

    var getCars: Array<Car?> = arrayOfNulls(lotOfCars.size)
    System.arraycopy(lotOfCars, 0, getCars, 0, lotOfCars.size)
    println(getCars is Array<Car?>)

    var newCars: Array<Car?> = arrayOfNulls(lotOfCars.size)
    for (index in lotOfCars.indices)
        newCars[index] = lotOfCars[index] as Car
    println(newCars is Array<Car?>)

    printColors(*newCars)

    println("Checking Extension Function")
    val someString = "december"
    println(someString.upperCaseFirstAndLastCharSimple())
}

fun printColors(vararg cars: Car?) {
    println("printColors() method")
    for (car in cars)
        println(car)
}