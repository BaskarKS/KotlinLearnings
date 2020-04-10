package function.basics
/*
* extension function will extend any class without changing the class code
* here we add a custom functionality to String class, its just a syntactical illusion
*
* */
fun main() {
    val name = "baskar"
    println(name.upperCaseFirstAndLastChar())
    println(name.upperCaseFirstAndLastCharSimple())

}

// this method is not visible outside this file
fun String.upperCaseFirstAndLastChar(): String {
    // here 'this' is referred to as String object, as we do extension function to String class
    val makeFirstCharCaps = this.substring(0, 1).toUpperCase() + this.substring(1)
    return makeFirstCharCaps.substring(0, this.length - 1) +
            makeFirstCharCaps.substring(this.length - 1, this.length).toUpperCase()
}

//this method is visible only in this package/module. visible everywhere if its 'public'
internal fun String.upperCaseFirstAndLastCharSimple(): String {
    // without referring 'this' object we can call public methods or properties directly
    val makeFirstCharCaps = substring(0, 1).toUpperCase() + substring(1)
    return makeFirstCharCaps.substring(0, length - 1) +
            makeFirstCharCaps.substring(length - 1, length).toUpperCase()
}
