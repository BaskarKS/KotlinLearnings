package collections.more.functions

import collections.maps.DataCar
import javax.xml.crypto.Data

// Sequences are similar to Streams in java, we can create/get a stream from a collection
// process it with multiple conditions and convert/create the processed sequence into a
// required collection data type.

// on each collection we can use functions like filter(), map(), count(), find(), groupBy()
// all(), any(), sortBy().. when working on large set of data, each will output a
// collection / data set which is unnecessary intermediate instance. If we do a
// complex sequence of operations, we can use sequence in that case

// in sequence each item is evaluated one by one. if we use a set/sequence of above mentioned
// operations at each step the entire data set is processed and a intermediate instance is
// created and passed to the next step. But sequence will process the entire steps for each
// element in collection

// can convert a sequence by calling the sequence()
fun main() {
    val mutableCarMap = mutableMapOf<Int, DataCar>(
        1 to DataCar("green", "Toyota", 2015),
        2 to DataCar("red", "Ford", 2013),
        3 to DataCar("silver", "Honda", 2013),
        12 to DataCar("Black", "Benz", 2018),
        33 to DataCar("White", "RangeRover", 2019),
        11 to DataCar("silver", "BMW", 2012)
    )

    //usingMapAndFilterOnSequence(mutableCarMap)

    usingConditionalTerminalOperations()
}
fun usingConditionalTerminalOperations() {
    val nameList = listOf<String>("ramu", "somu", "damu", "sunny", "bunny", "chinny", "durga")
    // result is 'String?' // can be null if any condition doesn't satisfy
    val result = nameList.asSequence()
        .filter { println("filtering: $it"); it[0] == 's'}
        .map { println("mapping : $it"); it.toUpperCase()}
        .find { println("Find End Letter is 'Y' : $it"); it.endsWith('Y') }
    // once the terminal operation is satisfied, will return immediately. doesn't process
    // remaining elements in collection, when 'find' returns true then the operation is
    // terminated by returning the current element // here find is satisfied with "SUNNY" hence
    // that element is returned
    println(result)
}

fun usingMapAndFilterOnSequence(carMap: Map<Int, DataCar>) {
    val filteredMapped = carMap.asSequence().filter { it.value.makeYear >= 2015 }.map {
        it.value.model } //kotlin.sequences.TransformingSequence -
    // sequence has intermediate and terminal operations
    // intermediate will again return a sequence to do more computation on them
    // terminal operation will return the result/final output

    // if there's no terminal operation in the sequences, there' s no need to compute the
    // values / process the sequence. only if a sequence has a terminal operation,
    // each item from collection is processed in the steps of sequences and computed value
    // is added to terminal operation and next value from collection is taken for processing

    println(filteredMapped)
    //List<String>
    val silverColorCarMakers = carMap.asSequence().filter {
                                                        println("Filtering : $it")
                                                        it.value.color == "silver"
                                                    }.map {
                                                        println("Mapping : $it")
                                                        it.value.model
                                                    }.toList() // toList() is a terminal operation, result is added in a new created list

    println(silverColorCarMakers)
}

// in sequence, the order of processing the elements can determine the length of
// processing,

// if our intention is to find a element "sunny" in the list,

//METHOD -1
//steps => collection.filter(first letter is 'S')-> map() -> find(last item is 'Y')
// we can first filter the item and then map and then find the item, which will avoid
// unnecessary process of mapping of some items, because most of item will fail in
// filtering itself

//METHOD-2
//steps => collection.map().filter(first letter is 'S')-> find(last item is 'Y')
// in the above methodology we unnecessarily map the unwanted items which will fail
// in filtering steps

// hence the order of processing sometime determines the optimizing the process.