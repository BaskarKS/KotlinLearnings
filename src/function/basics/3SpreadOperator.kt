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
    lotOfCars = arrayOf(*manyCars, *moreCars, car5) // lotOfCars is already defined above which is Array<Any>
    println("Checking type of LotOfCars: ")
    for ( item  in lotOfCars) {
        println(item)
        println("item is Any : ${item is Any}")
    }

    println("************ Just Checking *************")
    var extractCars: List<Any> = lotOfCars.toList().filter { it -> (it as Car).year >= 2010}
    for (car in extractCars)
        println(car)
    println("************ Just Checking *************")

    //to pass the lotOfCars to printColors() function we need to unpack the Array<Car> in lotOfCars
    var totalCars: Array<Car> = arrayOf(*manyCars, *moreCars, car5)
    for ( item  in totalCars)
        println(item)

     // now totalCars contains only Car elements, we can just unpack and pass it to printColors()
    printColors(*totalCars)

    //lotOfCars is Array<Any>, below ways will help to create a Array<Car?> type from lotOfCars
    var allCars = lotOfCars.asList().map{ it as Car }.toTypedArray() // allCars is Array<Car>
    println(allCars is Array<Car>) // true

    var getCars: Array<Car?> = arrayOfNulls(lotOfCars.size)
    System.arraycopy(lotOfCars, 0, getCars, 0, lotOfCars.size)
    println(getCars is Array<Car?>) // getCars is Array<Car?>

    var newCars: Array<Car?> = arrayOfNulls(lotOfCars.size) // newCars is Array<Car?>
    for (index in lotOfCars.indices)
        newCars[index] = lotOfCars[index] as Car
    println(newCars is Array<Car?>)

    printCarColors(*newCars)

    println("Checking Extension Function")
    val someString = "december"
    println(someString.upperCaseFirstAndLastCharSimple())
}

fun printColors(vararg cars: Car) {
    println("printColors() method")
    for (car in cars)
        println(car)
}

fun printCarColors(vararg cars: Car?) {
    println("printColors() method")
    for (car in cars)
        println(car)
}