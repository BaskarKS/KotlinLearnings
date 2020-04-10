import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper

fun main(args: Array<String>) {
   val genericEmployee: Any = Employee("Baskar", 11400)
    println(genericEmployee is Employee)
    if (genericEmployee is Employee) {
        // if the condition satisfy and entered this block, generic employee is automatically
        // typecast to Employee, we don't need to explicit typecast in every statement this
        // is called SmartCast. Here we don't need to externally typecast using "as" keyword
        println(genericEmployee.name)
        // if its Java we need to explicit typecast
        // println(((Employee)genericEmployee).name)
    }
    println(genericEmployee !is Employee)
    // "is" is used to check an object is an instance-of a class
    // "!is" is used to check an object is not an instance-of a class
    if (genericEmployee !is Employee) {
        // only if the genericEmployee is not Employee object we have to externally
        // typecast otherwise its automatically type-cast because of SmartCast
        val newEmployee = genericEmployee as Employee // externally typecast to Employee object
        println(newEmployee.name)
        println(newEmployee.id)
    }
}