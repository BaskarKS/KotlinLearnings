package collections.sets

// sets are very similar to list, cant contain duplicate elements, sets can be created
// 1. immutable sets - setOf()
// 2. mutable sets - mutableSetOf()

 fun main() {
     val setOfInts = setOf(10, 15, 19, 5, 3, -22)
     println(setOfInts.plus(55)) // adds the element if not present and returns new set
     println(setOfInts.plus(3)) // doesn't add the element if present, returns new set
     println(setOfInts.minus(3))// println(setOfInts.minus(3))// remove the element if present and returns new setremove the element if present and returns new set
     println(setOfInts.minus(11))// element if not present, ignores and returns new set
     println(setOfInts)
     println(setOfInts.average()) // prints average of values
     println(setOfInts.drop(1))
     println(setOfInts)
     println(setOfInts.drop(3)) // drops the passed number of values from beginning and returns new set

     val mutableSetInts = mutableSetOf<Int>(1, 2, 3, 4, 5)
     println(mutableSetInts)
     println(mutableSetInts.add(10)) // returns true on success
     println(mutableSetInts.add(10))// returns false if element already present
     println(mutableSetInts)

     // plus() and minus() are methods of immutable interface
     // mutable interface is sub-interface of immutable interface
     // drop() works on all type of collections
     // collection that don't implement collection interfaces are called 'sequences'
 }