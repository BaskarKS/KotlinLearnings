package collections.list

// All readOnly lists are Co-Variants (we can treat a class like its one of its parent type)
// ( can assign a 'BigDecimal' type List to of type 'Any'

// kotlin has immutable and mutable types of List, kotlin collections classes are available
// in kotlin.collections

// when working with a immutable collections, the instance will never change. if we try to
// use some inbuilt function which may change its contents then that function will return a
// new instance

// mutable collection types are not covariant type, mutable 'big-decimal' cant be
// assigned to mutable collection of 'Any'

// lists of 2 types , list and mutable list

fun main() {
    createImmutableLists()

    listToArraysToLists()

    createMutableLists()

    // Special Kotlin Functions on List
    kotlinCollectionFunctionOnList()
}

fun createImmutableLists() {
    //TYPE-1 = immutable list of items can contain null
    // immutable list of Strings, can contain null values
    val strings = listOf("spring", "summer", "winter", null)
    println(strings.javaClass) //class java.util.Arrays$ArrayList
    for (item in strings) {
        val someitem = item?:"null"
        println(someitem)
    }

    // can't add / remove an item from this type of list
    // kotlin in enforcing immutable characteristics using interface, if the same instance
    // is passed to java code, it can be used as mutable data structure, but in kotlin
    // it remains immutable. kotlin makes this data-type immutable by not having functions
    // in kotlin list interface that can change the array-list

    //TYPE-2 = immutable list of empty list
    val emptyListOne: List<String> = emptyList()
    val emptyListTwo = emptyList<String>() // immutable empty list which can be passed as
    // a function parameter of empty items instead of null, to avoid null interference
    println(emptyListOne.javaClass) //class kotlin.collections.EmptyList
    // emptyListOne[0] = "Baskar" // index referencing not allowed

    //TYPE-3 = immutable list of items cannot contain null
    val noNull = listOfNotNull(10) // List<Int>
    println("EmptyList - ${noNull.javaClass}") //class java.util.Collections$SingletonList
    val notNullList = listOfNotNull("One", "Two", "Three", null) //List<String>
    println(notNullList.javaClass) //class java.util.ArrayList
    for (item in notNullList)
        println(item.toLowerCase())
}

fun listToArraysToLists() {
    //Checking Array and Lists
    val array = arrayOf("black", "white", "red") //Array<String>
    var colorList = listOf(array) // List<Array<String>>
    println(colorList)
    val unpackList = listOf(*array) //List<String>
    println(unpackList)
    val listColors = array.toList() // List<String>

    val primInts = intArrayOf(1, 2, 3)
    val primList = primInts.toList() // List<Int>
}

fun createMutableLists() {
    // Creating Mutable List, can add / remove items
    //CASE-4 - Mutable List - Type 1
    val mutableListTypeOne = arrayListOf<Int>(1, 2, 3) // ArrayList<Int>
    println(mutableListTypeOne.javaClass) //class java.util.ArrayList
    //CASE-5 - Mutable List - Type 2
    val mutableListTypeTwo = mutableListOf(1, 2, 3) // MutableList<Int>
    println(mutableListTypeTwo.javaClass) //class java.util.ArrayList

    // ACCESS Mutable Lists
    println(mutableListTypeOne[1])
    mutableListTypeOne[1] = 20
    println(mutableListTypeOne)
    mutableListTypeOne.set(0 , 15)
    println(mutableListTypeOne)
}

fun kotlinCollectionFunctionOnList() {
    println("kotlinCollectionFunctionOnList()")
    val strings = listOf("spring", "summer", "fall", "winter", "fall", "winter")
    val colorList = listOf("red", "black", "green", "white", "red")

    println(strings.last()) // retrieves last element
    println(strings.reversed()) // returns new instance of list of String in reverse order
    println(strings)

    // println(strings[5]) //ArrayIndexOutOfBoundsException
    if (strings.size > 5)
        println(strings[5])
    //equivalent to
    println(strings.getOrNull(5)) // return null if index 5 is not available

    val ints = listOf(1, 2, 3, 4, 10, 9, 8)
    println(ints.max()) // gets max value i.e 10

    val pairs = colorList.zip(strings) //List<Pair<String, String>>
    println(pairs)
    println(pairs[0].javaClass) //class kotlin.Pair
    //zip can be used to bring together the related info of two lists

    //combining Lists
    val mergedLists = listOf(colorList, strings) // List<List<String>>
    println(mergedLists) // [[red, black, green, white, red], [spring, summer, fall, winter, fall, winter]]
    val extractMerge = colorList + strings // List<String> // + is overloaded
    println(extractMerge) // [red, black, green, white, red, spring, summer, fall, winter, fall, winter]

    // + will merge 2 list but will not avoid duplicates
    // to merge and have only unique values
    val noDupes = colorList.union(strings)
    println(noDupes) //[red, black, green, white, spring, summer, fall, winter]

    val noDupesSecondWay = colorList.distinct() // remove dupes from existing list and create new one with distinct values
    println(noDupesSecondWay) //[red, black, green, white]

    //Create a new mutable List from an immutable List
    val mutableColors = colorList.distinct().toMutableList() // MutableList<String>
    mutableColors.add("grey")
    println(mutableColors) //[red, black, green, white, grey]
}

// Use of EmptyList
// here the default value is set as null, and check for null is performed to find items is empty
class AcademicProfileWithNullPassed(val courseGradesAsPercent : List<Double>? = null) {

    fun displayAverage() {
        if (courseGradesAsPercent == null)
            println("No average to calculate, please sign-up for a course!")
        else {
            val sum = courseGradesAsPercent.reduce { accumulator, value -> accumulator + value }
            val average = sum / courseGradesAsPercent.count()
            println("Your unweighted average is $average")
        }
    }
}
// here we set the default value is set as empty-list, null type checking is avoided
class AcademicProfileWithEmptyListPassed(val courseGradesAsPercent : List<Double> = emptyList()) {

    fun displayAverage() {
        if (courseGradesAsPercent.isEmpty())
            println("No average to calculate, please sign-up for a course!")
        else {
            val sum = courseGradesAsPercent.reduce { accumulator, value -> accumulator + value }
            val average = sum / courseGradesAsPercent.count()
            println("Your unweighted average is $average")
        }
    }
}