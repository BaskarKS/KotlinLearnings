package inheritence

/*
*   classes, top-level functions, member functions, properties - everything is 'public final'
* by default in kotlin.
*
*
* */

/*
//CASE 1, 2
open class Printer {

}
*/

/* CASE - 1
* 2 problems here:
* 1.  base class is 'final public' by default, need to make base class as 'open' to make it eligible
* for extension.
* 2. constructor delegation from subclass to base class. - by having parenthesis after class name
* is the way to delegate to default compiler generated constructor - primary constructor delegation
* *//*

class LaserPrinter() : Printer() {

}

fun main() {
    var laserPrinter = LaserPrinter()
    println(laserPrinter)
}
*/

/* CASE - 2
* 2 problems here:
* 1.  base class is 'final public' by default, need to make base class as 'open' to make it eligible
* for extension.
* 2. constructor delegation from subclass to base class. - by having parenthesis after class name
* is the way to delegate to default compiler generated constructor. secondary constructor delegation
* *//*

class LaserPrinter : Printer {
    constructor():super() {
        //secondary constructor - supper delegates to base class
        println("secondary constructor - supper delegates to base class")
    }
}
*/
/*

//CASE-3
//Base class and subclass has primary constructors and subclass delegates values to base class
// through primary constructor
open class Printer(val modelName: String) {

}
class LaserPrinter(modelName: String):Printer(modelName) {

}
fun main() {
    var laserPrinter = LaserPrinter("CanonLaserPrinter")
    println(laserPrinter)
}
*/

/*
//CASE-4
//since printer is base class, making it abstract
// since base class is abstract, its not required to make it open to make it available to
// extend by subclass, because the abstract class is useful only if we extend it, its default open
abstract class Printer(val modelName: String) {

}
class LaserPrinter(modelName: String):Printer(modelName) {

}
*/

/*
//CASE-5
// abstract Base class can have normal member functions
abstract class Printer(val modelName: String) {
    fun printModel(): Unit = println("Printer Model Name is $modelName")
}
class LaserPrinter(modelName: String):Printer(modelName) {

}
fun main() {
    var laserPrinter = LaserPrinter("CanonLaserPrinter")
    laserPrinter.printModel()
}
*/
/*
//CASE-6
// abstract Base class - normal member functions is override in sub-class
// to override member function in subclass, need to make it open in base class
abstract class Printer(val modelName: String) {
    open fun printModel(): Unit = println("Printer Model in base class $modelName")
}
class LaserPrinter(modelName: String):Printer(modelName) {
    override fun printModel():Unit = println("Printer Model in subclass $modelName")
}
fun main() {
    var laserPrinter = LaserPrinter("CanonLaserPrinter")
    laserPrinter.printModel()
}
*/
/*
//CASE-7
// adding abstract function in base class and it should be override in subclass
// no need to make abstract base class method to open, since abstract classes are
// need not to make it open to subclass it. in same-way abstract methods are not
// needed to make it open to override it.
abstract class Printer(val modelName: String) {
    open fun printModel(): Unit = println("Printer Model in base class $modelName")
    abstract fun bestSellingPrice(): Double
}
class LaserPrinter(modelName: String):Printer(modelName) {
    override fun printModel():Unit = println("Printer Model in subclass $modelName")
    override fun bestSellingPrice() = 122.50
}
fun main() {
    var laserPrinter = LaserPrinter("CanonLaserPrinter")
    laserPrinter.printModel()
    println("Printer price : ${laserPrinter.bestSellingPrice()}")
}
*/

/*
//CASE-8
// AdvancedLaserPrinter class extends LaserPrinter class, still LaserPrinter need to make
// it open for extension/subclassed.
// Methods are not required to make it 'open' explicitly. since its already been override
// from base class, we can directly override it. override(internally supply meaning as open)

// fun methodName() - base class -> override fun methodName() - child class => mark the
// base class method as 'open' to support override.

// abstract fun methodName() - base class -> override fun methodName() - child class =>
// abstract methods are default open to override it in subclass, no explicit open required.

// override fun methodName() - sub class -> override fun methodName() - child class of
// subclass => , no explicit 'open' required in subclass. because subclass has already
// override it from base class, child of subclass can directly override it.
abstract class Printer(val modelName: String) {
    open fun printModel(): Unit = println("Printer Model in base class $modelName")
    abstract fun bestSellingPrice(): Double
}
open class LaserPrinter(modelName: String):Printer(modelName) {
    override fun printModel():Unit = println("Printer Model in subclass $modelName")
    override fun bestSellingPrice() = 122.50
}

class AdvancedLaserPrinter(modelName: String): LaserPrinter(modelName) {
    override fun printModel() {
        println("AdvancedLaserPrinter - Delegating call to its BaseClass")
        super.printModel()
    }

    override fun bestSellingPrice(): Double {
        println("AdvancedLaserPrinter - bestSellingPrice - delegating to parent class")
        return super.bestSellingPrice()
    }
}

fun main() {
    var laserPrinter = AdvancedLaserPrinter("Canon1500D")
    laserPrinter.printModel()
    println("Printer price : ${laserPrinter.bestSellingPrice()}")
}*/

/*
//CASE-9
// to restrict AdvancedLaserPrinter to override the printModel() method make it 'final' in
// LaserPrinter which is the parent/baseclass for AdvancedLaserPrinter
abstract class Printer(val modelName: String) {
    open fun printModel(): Unit = println("Printer Model in base class $modelName")
    abstract fun bestSellingPrice(): Double
}
open class LaserPrinter(modelName: String):Printer(modelName) {
    final override fun printModel():Unit = println("Printer Model in subclass $modelName")
    override fun bestSellingPrice() = 122.50
}

class AdvancedLaserPrinter(modelName: String): LaserPrinter(modelName) {
    // printModel() in LaserPrinter is restricted to override in this class
    // with final keyword
*/
/*
    override fun printModel() {
        println("AdvancedLaserPrinter - Delegating call to its BaseClass")
        super.printModel()
    }
*//*


    override fun bestSellingPrice(): Double {
        println("AdvancedLaserPrinter - bestSellingPrice - delegating to parent class")
        return super.bestSellingPrice()
    }
}

fun main() {
    var laserPrinter = AdvancedLaserPrinter("Canon1500D")
    laserPrinter.printModel()
    println("Printer price : ${laserPrinter.bestSellingPrice()}")
}
*/
/*
//CASE-10
// constructors of baseclass and subclass need not required to match
//  but the delegation of parameters of primary constructor of subclass should match
//  parameters passed to the base class primary constructor
abstract class Printer(val modelName: String) {
    open fun printModel(): Unit = println("Printer Model in base class $modelName")
    abstract fun bestSellingPrice(): Double
}
// primary constructor of base class (Printer) is expecting only one param, that is forced
// to be delegated from the below subclass (LaserPrinter)
open class LaserPrinter(modelName: String, ppm: Int):Printer(modelName) {
    override fun printModel():Unit = println("Printer Model in subclass $modelName")
    override fun bestSellingPrice() = 122.50
}

// primary constructor of base class (LaserPrinter) is expecting two param, that is forced
// to be delegated from the below subclass (AdvancedLaserPrinter)
// primary constructor of base class(2 params), subclass is (3 params)
class AdvancedLaserPrinter(modelName: String, ppm: Int, index: Int): LaserPrinter(modelName, ppm) {

    override fun printModel() {
        println("AdvancedLaserPrinter - Delegating call to its BaseClass")
        super.printModel()
    }

    override fun bestSellingPrice(): Double {
        println("AdvancedLaserPrinter - bestSellingPrice - delegating to parent class")
        return super.bestSellingPrice()
    }
}

fun main() {
    var laserPrinter = LaserPrinter("Canon1500D", 220)
    laserPrinter.printModel()
    println("Printer price : ${laserPrinter.bestSellingPrice()}")
}
*/

//CASE -11
/*
 base class has no primary constructor, has only secondary constructor:

 child class can delegate to base class secondary constructor only from a child
 class secondary constructor though super(), child class cant delegate to
 base class secondary constructor from child class primary constructor( in other
 words, child class should not have a primary constructor if base class has only
 secondary constructor.
*/

//case -2
/*
base class has primary constructor

child class can delegate parameters to base class(primary / secondary constructor)
from its secondary constructor, child class should not have a primary constructor,

if child class has a primary constructor and a secondary constructor, child class secondary
constructor can only delegate to its primary constructor, from child class primary constructor
it can delegate only to parent/base class primary constructor.
*/
/*

//case 11-a
open class Something {
    val someProperty: String
    constructor(someParam: String) {
        someProperty = someParam
    }
}

class SomeThingElse: Something {
    constructor(someOtherParam: String):super(someOtherParam)
}

fun main() {
    val some = SomeThingElse("Test")
}
*/

//case 11-b
/*
open class Something(val x: Int) {
    var someProperty: String = "some"
    constructor(someParam: String, y: Int):this(y) {
        this.someProperty = someParam
    }
}

class SomeThingElse : Something{
    constructor(extraParam: String, value: Int): super(extraParam, value) {

    }
}

fun main() {
    val some = SomeThingElse("Baskar", 10)
}
*/

/*
//case 11-c
open class Something(val x: Int) {
    var someProperty: String = "some"
    constructor(someParam: String, y: Int):this(y) {
        this.someProperty = someParam
    }
}

class SomeThingElse : Something {
    constructor(extraParam: String, value: Int): super(value)
}

fun main() {
    val some = SomeThingElse("Baskar", 10)
}
*/

//case-11d
open class Something(val x: Int) {
    var someProperty: String = "some"
    constructor(someParam: String, y: Int):this(y) {
        this.someProperty = someParam
    }
}

class SomeThingElse(value: Int): Something(value) {
    constructor(extraParam: String, value: Int): this(value)
}

fun main() {
    val some = SomeThingElse("Baskar", 10)
}

//conclusions related to DATA Classes
/*
Dataclass cannot be extended, by making it 'open', it cant be made abstract, cant be
inner class.

A class can be extended and become a data class. a data class cant be extended
Inheritance stops right with them.


data class DataSomeThing(val data: Int) : Something(data) {

}
*/
