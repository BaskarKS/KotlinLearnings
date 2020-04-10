package inheritence

interface MyInterface {
    fun myFunction(Str: String): String
}

// 'open' keyword is not necessary for base class to extend it
interface SubInterface: MyInterface {
    fun subFunction(num: Int): String
}

/*
class InterfaceFunctionality: SubInterface {
    override fun subFunction(num: Int): String {
        return "subFunction called $num"
    }

    override fun myFunction(Str: String): String {
        return "myFunction called $Str"
    }

}

fun main() {
    val interfaceObj = InterfaceFunctionality()
    println(interfaceObj.myFunction("Corona"))
    println(interfaceObj.subFunction(10))
}
*/

////////////////////////////////////////////////////////////////////////////////////////////////
/*
abstract class Printer(val modelName: String) {
    open fun printModel(): Unit = println("Printer Model in base class $modelName")
    abstract fun bestSellingPrice(): Double
}
open class LaserPrinter(modelName: String, ppm: Int):Printer(modelName), SubInterface {
    override fun subFunction(num: Int): String {
        return "subFunction called $num"
    }

    override fun myFunction(Str: String): String {
        return "myFunction called $Str"
    }

    override fun bestSellingPrice(): Double {
        return 122.50
    }

}

fun main() {
    val laserPrinter = LaserPrinter("Canon1100", 20)
    println(laserPrinter.myFunction("Canon Printer"))
    println(laserPrinter.subFunction(10))
}
*/
////////////////////////////////////////////////////////////////////////////////////////////////
// properties in interface don't have backing fields, custom accessor, get() / set() can't
// use field identifier.
interface InterfaceProperties {
    //below properties can be override in implementation class

    val number: Int // can define a abstract property in interface
                                        // and it should be defined in implemented class

    // val numberTwo: Int = 50 // property initializer are not allowed in interfaces

    val numberTwo: Int  // can define custom accessors
        get() = number * 10
}

open class InterfacePropertyClass: InterfaceProperties {
    override val number: Int
        get() = 100

    override val numberTwo: Int
        get() = super.numberTwo / 5
}

fun main() {
    val interfaceObj = InterfacePropertyClass()
    println(interfaceObj.number)
    println(interfaceObj.numberTwo)
}