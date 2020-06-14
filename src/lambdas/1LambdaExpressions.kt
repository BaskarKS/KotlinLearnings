package lambdas

/*
- Lambdas has to be in curly braces
- can store them in variables
- can instantiate them directly using helper method run()
*/

fun main() {
    run {
        println("this line is printed from a lambda")
    }

    val employees = listOf(Employee("john", "smith", 2012),
        Employee(joiningYear = 1999, firstName = "mike", lastName = "jones"),
        Employee("mary", "johnson", 2010),
        Employee("jane", "wilson", 2015)
    )

    println(employees.minBy({ it -> it.joiningYear })) // returns the employee object which has minimum year
    // here the lambda takes single input argument 'it', can mention any variable like 'it'

    // rule is => can move out the lambda out of parenthesis when it is last argument of
    // the function call, if the lambda is not the last argument then we cant move it out of
    // the parenthesis

    // the only parameter for minBy function is lambda, hence its moved out of parenthesis
    println(employees.minBy{it: Employee -> it.joiningYear })
    // Or
    println(employees.minBy{it.lastName })

    //CASE-2 - Lambda Conclusion of variable access
    // lambda can use local variable, only if its defined before lambda statement
    // lambda used in a function can use the function params
    val name = "Baskar K S"
    var num = 10
    run {
        num += 10
        println("Access local variable : $name")
        //println("Access local defined below $numTwo" // can't access 'numTwo' as
                                                                                            //  its defined below run{} lambda)
    }
    println("Incremented value : $num")
    val numTwo = 112

    println()
    println("Check Lambda use function params")
    lambdaUseParam(employees, 990)

    //CASE-3 - member referencing
    // member referencing can be used in place of Lambda expression if
    // lambda just reference/access a property like we access JoiningYear in this case
    // Or
    // lambda just call a top level function which doesn't take any parameters
    // member referencing has to be in parenthesis, using :: operator
    println(employees.minBy(Employee::joiningYear)) // which is same as below, member referencing should be done in parenthesis
    println(employees.minBy{it.joiningYear})

    println("Member referencing top level functions")
    run (::topLevelFunction)
    // which is same as below
    run {
        topLevelFunction()
    }
}

fun topLevelFunction()  = println("Just do some computation")


private fun lambdaUseParam(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it)
        println(num) //using function parameter which is "num"
    }
    // num += 10 // error: function parameters are val by default
}

//internal class Employee(val firstName: String, val lastName: String, val joiningYear: Int) {
data class Employee(val firstName: String, val lastName: String, val joiningYear: Int) {

/*    override fun toString(): String {
        return "FirstName:'$firstName' - LastName:'$lastName' - JoiningYear:'$joiningYear'"
    }*/
}