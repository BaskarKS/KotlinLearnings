package collections.maps

class Car(val color: String, val model: String, val year: Int) {

}

fun main() {
    val immutableMap = mapOf<Int, Car>(1 to Car("green", "toyota", 2015),
                                            2 to Car("red", "RangeRover", 2010),
                                            3 to Car("blue", "Hyundai", 2012))
    println(immutableMap.javaClass) //java.util.LinkedHashMap
    println(immutableMap)

    val mutableMap = mutableMapOf<String, Car>("baskar car" to Car("Silver", "Honda", 2014),
                                                        "Deni Car" to Car("Maroon", "Maruti", 1999))
    println(mutableMap.javaClass) // java.util.LinkedHashMap

    // kotlin prefers to use LinkedHashMap for both mutable and immutable map,
    // because it has predictable iteration order its easy for
    // kotlin to convert list <-> map <-> set

    //if we want to use HashMap instead of linkedHashMap as underlying Data structure
    val mutableHashMap = hashMapOf<String, Car>()
    mutableHashMap.put("baskar car", Car("Silver", "Honda", 2015))
    mutableHashMap.put("deni car", Car("maroon", "Maruti", 2008))
    println(mutableHashMap.javaClass) //java.util.HashMap


    destructuringDeclarations() // to unpack the data from a Data structure
}

fun destructuringDeclarations() {
    val pair = Pair(10, "ten")
    val first = pair.first
    val second = pair.second
    println("pair first Value : $first, pair second value : $second")

    //another way of unpacking
    val (firstVal, SecondVal) = pair
    println("2nd way to unpack => pair first Value : $first, pair second value : $second")

    val mutableMap = mutableMapOf<String, Car>("Baskar car" to Car("Silver", "Honda", 2014),
        "Deni Car" to Car("Maroon", "Maruti", 1999))
    println("Printing Mutable Map")
    for (entry in mutableMap) {
        println(entry.javaClass)
        println("key is ${entry.key} and value is ${entry.value}")
    }

    println("unpacking key and value")
    for ((key, value) in mutableMap) {
        println("key is $key and value is $value")
    }

    // to have such unpacking functionality for our custom defined class we have to
    // implement the component functions explicitly, for data class it has inbuilt support
    val customCar = CustomCar("Baskar", "Honda", 2015)
    val (color, model, year) = customCar
    println("CustomCar - color=$color, model=$model, year=$year")

    val dataCar = DataCar("Red", "RangeRover", 2020)
    val (dataColor, dataModel, dataMakeYear) = dataCar
    println("DataCar - color=$dataColor, model=$dataModel, year=$dataMakeYear")
}

class CustomCar(val color: String, val model: String, val year: Int) {
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}

data class DataCar(val color: String, val model: String, val makeYear: Int) {
    // no need to define component function for unpacking value for Data Class
    // it has default support for primary constructor params
}