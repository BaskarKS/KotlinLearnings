package javacode.interoperability.javacode.to.kotlincode.access.member.properties

class Car(val color: String, val model: String, val year: Int) {

}

open class Truck(color: String, @JvmField val model: String, val year: Int, capacity: Int) {
    //open  @JvmField var engineNo: Long = 291929129110
    open  var engineNo: Long = 291929129110
    var truckColor = color
    set (value) {
        field = "Green Always"
    }
    var truckCapacity = capacity
    private set(value) {
        field = 10
    }
}

class HeavyTruck():Truck("Red", "BMW", 2020, 100) {
    override var engineNo: Long = 150
}