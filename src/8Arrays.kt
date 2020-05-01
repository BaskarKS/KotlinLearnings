import java.util.*

fun main(args: Array<String>) {
    // 2 types(Collection Arrays, Primitive) =>  2 ways to create
    // 1st way. if we have/know values in advance
    // 2nd way. if we don't know the values in advance, create with some default values

    // collection array creating way, arrayOf() / Array<Int>(size){}
    // primitive array creating way, IntArrayOf(values), LongArrayOf(values) /
    // IntArray(size), LongArray(Size)
    // convert collection array to primitive array by .toIntArray(), .toLongArray
    // convert primitive array to collection array by .toTypedArray()

    //Type 1,  Way 1 (collection Arrays - know values in advance)
    val longArray = arrayOf(1L, 2L, 3L)
    println("is its Long Array ${longArray is Array<Long>}")

    val booleanArray = arrayOf(true, false, true)
    println("is its boolean Array ${booleanArray is Array<Boolean>}")

    val intArray = arrayOf(1, 2, 3, 4, 5)
    println("is its Integer Array ${intArray is Array<Int>}")

    val charArray = arrayOf('a', 'b', 'c')
    println("is its char Array ${charArray is Array<Char>}")

    //Type 1,  Way 2 (collection Arrays - don't know values in advance)
    println("Type 1,  Way 2 (collection Arrays - don't know values in advance)")
    val intArrayTwo = Array<Int>(10){0}
    println("is its Integer Array ${intArrayTwo is Array<Int>}")

    val longArrayTwo = Array<Long>(5) {i -> i.toLong()} // i is index value 0, 1, 2, 3, 4
    println("is its Long Array ${longArrayTwo is Array<Long>}")
    println(longArrayTwo.contentToString())

    val floatArray = Array<Float>(5){i -> i + 1.0f}
    println("is its Float Array ${floatArray is Array<Float>}")
    println(floatArray.contentToString())

    //Type 2,  Way 1 (primitive Arrays - don't know values in advance)
    println("Type 2,  Way 1 (primitive Arrays - know values in advance)")

    var primIntArray = intArrayOf(1, 2, 3, 4)
    println("is its primitive Int Array ${primIntArray is IntArray}")

    var shortPrimArray = shortArrayOf(11, 12, 13)
    println("is its primitive Short Array ${shortPrimArray is ShortArray}")

    var bytePrimArray = byteArrayOf(111, 112, 113)
    println("is its primitive Byte Array ${bytePrimArray is ByteArray}")

    var primCharArray = charArrayOf(65.toChar(), 66.toChar(), 67.toChar())
    println("is its primitive Char Array ${primCharArray is CharArray}")

    //Type 2,  Way 2 (primitive Arrays - don't know values in advance)
    println("Type 2,  Way 2 (primitive Arrays - don't know values in advance)")

    var primIntArrayTwo = IntArray(5)
    println("is its primitive Int Array ${primIntArrayTwo is IntArray}")
    println(primIntArrayTwo.contentToString())

    var primFloatArrayTwo = FloatArray(10)
    println("is its primitive Float Array ${primFloatArrayTwo is FloatArray}")
    println(primFloatArrayTwo.contentToString())

    println("Convert Collection Array to Primitive Array")
    var primLongArray = longArray.toLongArray()
    println("is its primitive Long Array ${primLongArray is LongArray}")

    var convertedPrimCharArray = charArray.toCharArray()
    println("is its primitive Char Array ${convertedPrimCharArray is CharArray}")

    println("Convert Primitive Array to Collection Array")
    var convertedLongArray = primLongArray.toTypedArray()
    println("is its Collection Long Array ${convertedLongArray is Array<Long>}")

    var convertedCollecCharArray = convertedPrimCharArray.toTypedArray()
    println("is its Collection Char\\] Array ${convertedCollecCharArray is Array<Char>}")
}