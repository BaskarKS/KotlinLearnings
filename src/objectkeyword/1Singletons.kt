package objectkeyword

/*
There's a way to declare and define a class instance at the same time
*/

/*
3 use cases for 'object' keyword:
1. singletons (only single instance of class for entire application)
2. companion objects
3. object expressions
 */

/*
Singletons:
use object keyword for single instance, there can ever be only one instance of object class.
when we declare an object class, we imply that only one instance of the class
 */

import java.time.Year
//Singleton Class defined below
// no constructor is there, from outside nobody can create an instance of it
object CompanyCommunications {
    private val currentYear: Year? = Year.now()
    fun getTagLine() = "Our Company Values Lives!!"
    fun getCopyRightLine() = "Copyright \u00A9 ${currentYear ?:"2000"}. All Rights Reserved"
}
fun main() {
    //Instance on CompanyCommunication is created when its first used, below line is first use
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyRightLine())

    println()
    println(SingletonClassExtend.mustImplement())

}

// singleton can also extend a class and implement a interface
interface SingletonInterface { // no need to define open for interface
    val prop : Int // no need to make this variable open, this should be override in implemented class
    fun mustImplement(): Double
}
open class SingletonCheck(val count: Int): SingletonInterface {
    init {
        println("Singleton Check Class Init $count")
    }

    open fun someFunction() = println("some function")

    override val prop: Int
        get() = 213

    override fun mustImplement(): Double { // this is method of interface no need to make it open for subclass to override it
        return 122.2
    }
}

object SingletonClassExtend: SingletonCheck(100) {
    init {
        println("SingleTon Class")
    }

    override val prop: Int
        get() = super.prop + 10

    override fun someFunction() = println("Some Function in SingleTon Object")

    override fun mustImplement(): Double {
        return super.mustImplement() + 11
    }
}