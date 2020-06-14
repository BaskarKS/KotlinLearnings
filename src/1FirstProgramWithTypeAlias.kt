// only type alias are defined in file, cant define inside a function / class.
// if want to use this alias in some other file it can be imported
typealias list = ArrayList<String>

fun main(args: Array<String>) {
    println("kotlin Code")
    val number : Short = 10
    var number1 : Short = 11

    println(number)
    // number = 1
    val employee1 = Employee("Baskar", 11400)
    employee1.name = "Balu"
    println(employee1)

    val employee2 : Employee
    // below block can assign variable only once hence its valid for val type variables
    if (number1 > number)
        employee2 = Employee("number_one", number1.toInt())
    else
        employee2 = Employee("number", number.toInt())
    println(employee2)

    val ids : list // declare variable of typealias type,no problem even if its val type
    ids = getList() // define variable, val type can be defined and assigned once
    println(ids)

}

fun getList() : list {
    val nameList: list = ArrayList();
    nameList.add("a")
    return nameList;
}

class Employee(var name: String, val id: Int) {
    var nameList : list = ArrayList()

    init {
        nameList.add(name)
        //nameList.add(10) cant add other type apart from String
    }

    override fun toString(): String {
        return "Emp Name : $name, Emp Id : $id";
    }
}