/*
each Enum is a class object, we can get its name using name, and value using ordinal
*//*


enum class Department {
    HR, IT, ACCOUNT, SALES
}

fun main() {
    println(Department.HR.name)
    println(Department.HR.ordinal)
    println(Department.SALES.name)
    println(Department.SALES.ordinal)
}
*/

//CASE-2 - Enums with properties
/*
each Enum is a class object, we can get its name using name, and value using ordinal.
can also define properties and function to eah enums
*/

enum class Department(val fullName:String, val noOfEmployees: Int) {
    //objects are created here itself
    HR("Human Resources", 5),
    IT("Information Technology", 10),
    ACCOUNT("Accounting Section", 3),
    SALES("Sales Dept", 20);
    // need ; above to differentiate/end enums and its member function
    fun getDeptInfo() = "Department : $fullName has $noOfEmployees Employees"
}

fun main() {
    println(Department.HR.name)
    println(Department.HR.ordinal)
    println(Department.HR.getDeptInfo())
    println()
    println(Department.SALES.name)
    println(Department.SALES.ordinal)
    println(Department.SALES.getDeptInfo())
}

// Enums are used with "when" kotlin feature