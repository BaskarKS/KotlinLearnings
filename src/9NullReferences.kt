
fun main(args: Array<String>) {
    val str: String? =  getValue()
    // str variable has possibility to become null, hence its defined as nullable type
    // operation can be performed on str variable is restricted to force check for null
    // before using it

    //println(str.toLowerCase()) // Error here
    if (str != null) {
        // because of smart casting compiler can infer that str is already
        // checked for null, hence direct operation on variable is allowed here.
        val lowerCase = str.toLowerCase()
    }
     // Explicit "if" check can be avoided in kotlin by performing
    // ("?  SAFE ACCESS OPERATOR")
    println(str?.toLowerCase()) // before performing operation on str variable.
    // str is checked for null, if its null  it just returns null, otherwise it returns
    // the lowercase converted string // just to be safe using to avoid NullPointerException

    //below 6 lines of code is equivalent to "println(str?.toLowerCase())"
    val changedCase: String?
    if (str == null) {
        changedCase = null
    } else {
        changedCase = str.toLowerCase()
    }
    println(changedCase)

    // Elvis Operator
    var status: String? = getValue() ?: "Default Value"
    // here getValue() can possible to return null, if we in need of assigning "default
    // value" if the getValue() returns null, we can use
    // Elvis Operator - ?: => left expression/value ?: right expression/value

    // if left side expression of ElvisOperator returns some value then it returns it.
    // if left side expression is null, elvis operator will return the right side value

    // compiler can infer the type of "status" as String? because of Elvis operator used
    println(status)
    println(status is String?)

     // var status = getValue() ?: "Default Value" //=> is equivalent to below 5 lines.
    if (getValue() == null) { // left side of elvis operator
        status = "Default Value" //right side of  elvis operator
    } else {
        status = getValue() // left side of elvis operator
    }

    println("Checking SafeCast Operator")
    val someThing : Any = arrayOf(1, 2, 3, 4)
    val strVal = someThing as? String
    println(strVal)
    println(strVal is String?) // compiler can infer and make type of "strVal" as String?
    // because if cast fails it returns null, hence the variable should be nullable type

    //val newStrVal : String = someThing as String // will cause null pointer
    // exception if the cast fails.
    //println(newStrVal)

    //To Safely Cast
    // val newCaseString: String = someThing as? String // not valid
    // we cant explicitly define / force newCaseString as "String" type, its error
    // since we use safe cast operator, safe-cast operator it has possibility of
    // return null value

    val newCaseString: String? = someThing as? String // valid
    //not newCaseString is restricted to use safe access operator to use it for other operations
    println(newCaseString) // null

    val hasStringAlways : String? = "Has Some value Always"

    println("Using NOT-NULL ASSERT (!!)")
    println(hasStringAlways)

    val defaultValue: String = hasStringAlways!! // <= raise exception if hasStringAlways is null otherwise use it

    // better to avoid not-null assert !! in a series of expression and use safe operator ?

    val first : First? = First()
    var getThird : First.Second.Third? = first!!.second!!.third
    // if any of the variable is null (first / second / third) will raise a exception
    //better to use safe-operator
    getThird = first?.second?.third
    // above line will not raise a exception, instead the getThird will become null
    // if any of variable (first / second / third) is null

    val str4: String? = null
    val str5 = "its not nullable"
    val str6 = "its not nullable"
    println(str4 == str5) // this does content comparison .equals(), but doesn't cause
    // NPE because == is safe-operator null check is done internally
    println(str6 === str5)

    println("Checking Let:")
    val checkLet: String? = "somE vaLUE"
    val getLet: String?

    // sometimes we need to use nullable value(String?)
    // and pass it to non-nullable type(String)

    // if we extract nullable type using (!! not-null) we may get exception if
    // nullable variable is null
    //Better to use Let to extract value from nullable type in safe way, return value otherwise null
    checkLet?.let { println(it is String) }
    var getString = checkLet?.let { it }
    println(getString is String)

    var checkingLet = null
    var usingLet = checkingLet?.let { it }
    println(usingLet)

    getLet = checkLet?.let { it.toLowerCase()
                                                it.toUpperCase()
                                                it.capitalize()} // last statement is returned
    println(getLet)


    // collection arrays are not allowed to get created without size and initial values
    // to avoid the arrays having null values in it.
    // primitive arrays are allowed to get created with just size, compile will set the
    // default value for it
    // if the need is to create a collection array (we don't know the values initially)
    // we can create a collection array with null values with explicit way of creating it
    val nullableArray = arrayOfNulls<Int>(5)
    nullableArray[0] = 10
    val nullableArrayOfNullable = arrayOfNulls<Int?>(5)
    nullableArrayOfNullable[0] = 15
    println("Checking Nullable Arrays::")
    for (i in nullableArray)
        println(i)
    println(nullableArray[0] is Int)
    println(nullableArray[0] is Int?)
    println(nullableArrayOfNullable[0] is Int)
    println(nullableArrayOfNullable[0] is Int?)

    println("Checking Safe Cast")
    val intValue  = 10
    var inString: String?
    inString = intValue as? String // if we are unsure that casting can happen or not. Better to use safe-cast "as?"
    println(inString)
}

fun getValue() : String? {
    return null
}

class First{
    val second : Second? = Second()
    class Second {
        val third : Third? = Third()
        class Third  {

        }
    }
}