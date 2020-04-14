package collections.more.functions

import collections.maps.CustomCar
import collections.maps.DataCar


fun main() {
    val carImmutableMap = mapOf<Int,DataCar>(1 to DataCar("green", "toyota", 2015),
                                                    2 to DataCar("red", "ford", 2016),
                                                    3 to DataCar("silver", "honda", 2013))
    val immutableSetOfInts = setOf<Int>(10, 15, 19, 5, 3, -22)

    val mutableCarMap = mutableMapOf<Int, DataCar>(
        1 to DataCar("green", "Toyota", 2015),
        2 to DataCar("red", "Ford", 2013),
        3 to DataCar("silver", "Honda", 2013),
        12 to DataCar("Black", "Benz", 2018),
        33 to DataCar("White", "RangeRover", 2019),
        11 to DataCar("silver", "BMW", 2012))

    //usingFilterFunction(immutableSetOfInts, carImmutableMap)

    //usingFilterFunction(immutableSetOfInts, mutableCarMap)

    //usingMapFunction(immutableSetOfInts, mutableCarMap)

    //usingFilterAndMapTogether(immutableSetOfInts, mutableCarMap)

    //usingAllAndAnyAndCount(immutableSetOfInts, mutableCarMap)

    //usingFindAndGroupBy(immutableSetOfInts, mutableCarMap)

    usingSortFunctionsOnCollections(immutableSetOfInts, mutableCarMap)
}

fun usingFilterFunction(intSet:Set<Int>, carMap: Map<Int, DataCar>) {
    println(intSet.filter { it % 2 != 0}) // get set of Ints in ListFormat which satisfy the filter criteria
    println(carMap.filter { it.value.makeYear >= 2016}) // get a map objects which satisfy the filter criteria
    println(carMap.filter { it.value.color == "silver" })
}

fun usingMapFunction(intSet:Set<Int>, carMap: Map<Int, DataCar>) {
    val ints = arrayOf(1, 2, 3, 4, 5, 6)
    val createNewIntList = ints.map { it + 10} // List<Int>
    println(createNewIntList)
    println(createNewIntList.javaClass)

    println("Extract a single property from a map and form a List")
    val carMakeYearList = carMap.map { it.value.makeYear }
    println(carMakeYearList)
    println(carMakeYearList.javaClass)
}

fun usingFilterAndMapTogether(intSet:Set<Int>, carMap: Map<Int, DataCar>) {
    val filteredColorModel = carMap.filter { it.value.makeYear >=2015 }.map { it.value.model }
    println(filteredColorModel)
    println(filteredColorModel.javaClass)
}

fun usingAllAndAnyAndCount(intSet:Set<Int>, carMap: Map<Int, DataCar>) {
    // all is used to check that all elements in a collection satisfies a condition, returns boolean
    println(carMap.all { it.value.makeYear >= 2014 }) // return true if all elements in collection satisfies a condition
    // any is used to check that any one element in a collection satisfies a condition, returns boolean
    println(carMap.any { it.value.makeYear <= 2012 })
    //return the count of elements which satisfy the passed condition
    println(carMap.count{ it.value.makeYear >= 2015})
}

fun usingFindAndGroupBy(intSet:Set<Int>, carMap: Map<Int, DataCar>) {
    // we can apply find and group on list / set. cant apply it on maps

    // find() will go through the collection items one by one and
    // return the item immediately when the passed condition is satisfied
    val cars = carMap.values
    println(cars.find { it.makeYear == 2013 })

    //groupBy(), we pass a parameter type, items in the collection are groupBy the parameter type
    // here we want to group the cars based on its color
    val group = cars.groupBy { it.color } // Map<String, List<DataCar>>
    println(group)
    // group is a map, the "key" are the "colors" and "values" are the list of collection items

/*
    val list: List<DataCar> = carMap.values.toMutableList()
    list.groupBy { it.makeYear }
*/
}

fun usingSortFunctionsOnCollections(intSet:Set<Int>, carMap: Map<Int, DataCar>) {
    println(carMap)
    val sortOnKeys = carMap.toSortedMap() // SortedMap<Int, DataCar>
    //keys are arranged in sorted order in sortOnKeys(SortedMap)
    println(sortOnKeys)

    val cars = carMap.values.toMutableList()
    val sortedCars = cars.sortedBy { it.makeYear } // here we want items to sort based on makeYear
    println(sortedCars)
    //sortedCars is a List of DataCar which are in sorted order based on the car makeYear
}