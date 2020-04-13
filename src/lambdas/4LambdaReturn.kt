package lambdas

fun main() {
    val employees = listOf(Employee("john", "smith", 2012),
        Employee(joiningYear = 1999, firstName = "mike", lastName = "jones"),
        Employee("mary", "johnson", 2010),
        Employee("jane", "wilson", 2015)
    )

    findByLastNameLambdaWithName(employees, "wilson")

    // using name label with apply, name the apply lambda which can be used to refer
    // the receiver object of apply
    "some string".apply someStr@{
        "ANOTHER STRING".apply {
            println(toLowerCase()) // the receiver object associated with this lambda block
                                                        // is "ANOTHER STRING" string, public method toLowerCase()
                                                        // can be called directly
            println(this@someStr.toUpperCase()) // receiver object associated with
                                                    // "some string".apply lambda is referred here
        }
    }
}

internal fun findByLastNameNormal(employees: List<Employee>, nameToFind: String) {
    for (employee in employees) {
        if (employee.lastName == nameToFind) {
            println("yes, employee present with the last name '$nameToFind'")
            return
        }
    }
    println("there's not employee with last name : $nameToFind")
}

internal fun findByLastNameLambda(employees: List<Employee>, nameToFind: String) {
    employees.forEach {
        if (it.lastName == nameToFind) {
            println("yes, employee present with the last name '$nameToFind'")
            return // this statement will return from both lambda(ForEach) and
            // the function(findByLastNameLambda()). Since the lambda of ForEach() is an inline function
            // the 'return' will return from the function also. this is called "non-local return".
            // just to return/break the control of forEach() lambda, instead of returning from the function
            // its called "local return" which can be achieved by "naming the lambda"
        }
    }
    println("there's not employee with last name : $nameToFind")
}

//Naming the Lambda has 2 uses,
// 1. can be used to do "local return"
// 2. can be used to refer the particular lambda receiver object
internal fun findByLastNameLambdaWithName(employees: List<Employee>, nameToFind: String) {
    employees.forEach lambdaName@{
        // here the receiver object is Employee type
        if (it.lastName == nameToFind) {
            println("yes, employee present with the last name '$nameToFind'")
            return@lambdaName // this statement will break the loop and control continues
            // in this function
        }
    }
    println("there's not employee with last name : $nameToFind")
}

// we can name label to loops, lambdas, etc and we can use the named label with
// break, continue, return etc


