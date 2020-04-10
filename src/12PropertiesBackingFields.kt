/*
* all variables in class are properties by default in Kotlin
*
* all properties in class is defined by default by kotlin to have default accessors
* (get() and set() method under the covers), only through the get/set methods the values
* are read and written
*
* if the property is 'val', kotlin will generate only get() methods, by only through it values
* are set. we may access the variables using object.variable-name, but its get through getters
*
* if the property is 'var', kotlin will generate get() and set() methods, by only through it values
* are set and get.
* we may access the variables using object.variable-name, but its get/set through getters and
* setters
*
* if we need a custom getters / setters where we need to do extra operations before we
* set / get the value. we need to define custom accessors, should be defined
* very immediate to the variable is defined, because of this condition we cant define
* custom accessors for the memory defined variables in primary constructor
*
* custom accessors can be defined for variable modifiers public, internal, protected, private
*
* if the variable is private, custom accessors can be defined, but the variables are not visible
* or accessed from outside the class using object.variable-Name, need to define
* extra functions which can set / get the private variables
*
* custom accessors which are defined to do custom operation before we get/set the
* variable value, the variable can be accessed inside get() / set() method using 'field'
* we cant refer the variable name directly with in get() / set(). we can refer the variable
* using 'field' which is generated when we do extra operation,
*
*  if we don't do extra operation, the field variable is never generated for the variable (argFour)
*
*  field identifier is used only in custom accessors get() / set() in kotlin, nowhere its used
* */

fun main(args: Array<String>) {
    var propertyObj= CheckingProperties(11400, "Baskar", false)
    //println(propertyObj.argOne)
    println(propertyObj.getPrivate())
    propertyObj.setPrivate(1)
    println(propertyObj.getPrivate())



    println()
    println(propertyObj.argFour)
    propertyObj.argFour = 11

    println("Employment Status")
    println(propertyObj.getStatus())
    propertyObj.setStatus(true)
    println(propertyObj.getStatus())


}

class CheckingProperties(argOne: Int, val argTwo: String, private var employment_status: Boolean) {
    var argOne = argOne
    get() {
        println("argOne Getter")
        return if (field > 0) field - 1 else field
    }
    set(value) {
        println("argOne Setter")
        field = value + 1
    }

    private var argThree: Int = 999 // not visible outside the class
    get() {
        println("argThree Getter")
        return field + 1
    }
    set(value) {
        println("argThree Setter")
        field = value + 1
    }

    fun getPrivate():Int {
        println("getPrivate()")
        return argThree // extra getter method to return private variable
    }
    fun setPrivate(value: Int) {
        println("setPrivate()")
        argThree = value // extra getter method to return private variable
    }

    var argFour: Int
    get() {
        println("argFour Getter")
        return 10
    }
    set(value) {
        println("argFour Setter")
        //didn't set any value
    }

    fun setStatus(status: Boolean) {
        employment_status = status
    }

    fun getStatus():Boolean {
        return employment_status
    }

}