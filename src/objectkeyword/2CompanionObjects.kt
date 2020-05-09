package objectkeyword

/*
'static' is not there in Kotlin, can achieve the same using
top-level functions,
top level variables,
inside a class without its instance we cant access its methods and variables.

to achieve the access of methods and variables inside the class without class instance,
use 'companion objects'
*/

//Case-1 : companion object without a Name, use 'Companion' to refer it
class CheckCompanion {
    companion object {
        private val privateValue = 123
        fun accessPrivateValue() = "access private value $privateValue"
    }
}
/*
fun main() {
    println(CheckCompanion.Companion.accessPrivateValue())
}*/

/*
//Case-2 - companion object with a name
class CheckCompanion {
    companion object SharePrivate{
        private val privateValue = 123
        fun accessPrivateValue() = "access private value $privateValue"
    }
}

fun main() {
    println(CheckCompanion.SharePrivate.accessPrivateValue())
}
*/

/*
//Case-3 - access elements in companion object directly
class CheckCompanion {
    companion object SharePrivate{
        // all items described below block will behave as static, can access directly
        private val privateValue = 123
        fun accessPrivateValue() = "access private value $privateValue"
    }
}

fun main() {
    println(CheckCompanion.accessPrivateValue())
}
*/

//Case-4 - making a class with private primary constructor(from outside we cant create a
// instance) and use companion object to return its instance (Factory Pattern)
class CompanionAsFactory(private val someString: String) {
    companion object {
        // all items described below block will behave as static, can access directly
        private var privateValue = 123
        fun accessPrivateValue() = "access private value $privateValue"
        fun justAssignValue(str: String) = CompanionAsFactory(str)
        fun getInstanceUpperOrLower(str: String, makeUpper: Boolean):CompanionAsFactory {
            return if (makeUpper)
                CompanionAsFactory(str.toUpperCase())
            else
                CompanionAsFactory(str.toLowerCase())
        }
    }
}

fun main() {
    val factoryInstance = CompanionAsFactory.getInstanceUpperOrLower("india", true)
    println(factoryInstance)
}


