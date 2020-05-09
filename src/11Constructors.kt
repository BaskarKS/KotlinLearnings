fun main(args: Array<String>) {
/*
    val employee = GlobalEmployee("Baskar")
    println(employee.firstName)
*/

    val employee = GlobalEmployee()
    println(employee.firstName)

}

/*
// Version 1: Defining explicit primary constructor and defining class variables inside class
class GlobalEmployee constructor(firstName: String) {
    // constructor(firstName: String) => primary constructor
    // primary constructor cant contain code block, can use init instead
    public val firstName: String
    init {
        this.firstName = firstName
    }
    // init block will execute in conjunction with the primary constructor,
    // class can have multiple init blocks
}
*/

/*
// Version 2: Defining explicit primary constructor and defining class variables inside class
// without init block
class GlobalEmployee constructor(firstName: String) {
    // constructor(firstName: String) => primary constructor
    // primary constructor cant contain code block, can use init instead
    public val firstName: String = firstName  // direct assignment without init block
}
*/

/*
// Version 3: Defining explicit primary constructor and create and init class variables in it
class GlobalEmployee constructor(val firstName: String) {
    // constructor(firstName: String) => primary constructor
    // primary constructor cant contain code block, can use init instead

}
*/

/*
// Version 4: remove the "constructor" keyword which is adjacent to class definition
class GlobalEmployee (val firstName: String) {
    // constructor(firstName: String) => primary constructor, can
    // remove the constructor keyword if its 'public'
    // primary constructor cant contain code block, can use init instead
}
*/

/*
// Version 5: Defining explicit primary constructor and create and initialize class variables in it,
// should have constructor keyword in primary constructor if the access modifier
// is different than 'public'
class GlobalEmployee internal constructor(val firstName: String) {
    // constructor(firstName: String) => primary constructor, should use 'constructor'
    // keyword if its other than 'public'
    public fun getInstance() : GlobalEmployee {
        return this
    }
}
*/

/*
// Version 6: Defining overloaded secondary constructor ,should delegate values to primary constructor
// cant define variables using val/var in secondary constructor like we did in primary constructor
class GlobalEmployee (val firstName: String) {
    // (firstName: String) => primary constructor, remove the constructor keyword since its public
    // keyword if its 'public', can define variables which are class fields and will get initialised simultaneously
    // private var fullTe: Boolean = false

    // cant define variables using val/var in secondary constructor like done in primary constructor
    constructor(firstName: String, val fullTime: Boolean) : this(firstName) {
        // it has to delegate its values to primary constructor using ': this(variable value)'
        // this.fullTe = fullTime
    }
}
*/

/*
// Version 7: Defining explicit secondary constructor , delegate values to primary constructor
// cant create variables using val/var in secondary constructor like we did in primary constructor
// create explicit class variables and initialize it with secondary constructor values
class GlobalEmployee (val firstName: String) {
    // (firstName: String) => primary constructor, remove the constructor keyword if its 'public'
    // Can define variables that will be class variables and init simultaneously
    var fullTime: Boolean = false

    constructor(firstName: String, fullTime: Boolean) : this(firstName) {
        // it has to delegate its values to primary constructor using ': this(variable value)'
        // cant define variables using val/var in secondary constructor like done in primary constructor
        // can just use the value to initialize it as below
        this.fullTime = fullTime
    }
}
*/

/*
// Version 8:  Avoiding the use of secondary constructor and achieve same with primary constructor itself
class GlobalEmployee (val firstName: String, val fullTime: Boolean = false) {
    // (firstName: String) => primary constructor, remove the constructor keyword if its 'public'
    // Can define variables that will be class variables and init simultaneously

    // now we can create this class instance by just passing firstName or both values
}
*/

// Version 9:  Avoiding the use of primary constructor itself by not including parenthesis after name of class
class GlobalEmployee {
    val firstName: String
    val fullTime: Boolean = false

    constructor() { // no primary constructor defined, no need to delegate anything
        firstName = "Hello"
    }
/*
    init {
        firstName = "Dummy"
    }*/
}
