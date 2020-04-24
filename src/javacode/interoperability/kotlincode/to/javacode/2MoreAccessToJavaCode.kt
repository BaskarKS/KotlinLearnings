package javacode.interoperability.kotlincode.to.javacode

fun main() {
    //1. ACCESSING PROPERTIES FROM JAVA CODE
    // the properties of Java class is accessed directly as properties in Kotlin,
    // the properties are accessed directly, if the java class methods define getters
    // and setters for the properties in Java class file.
    val car = JavaCar("black", "Toyota", "SUV", "Diesel", 2020)
    car.color = "Maroon"
    car.year = 2019 // year is public even if it doesn't have setter defined, its accessible
    // as properties in kotlin
//    car.FCYear = 2040 // this property is not accessible directly because its private
    car.fcYear = 2040 // but we can access it by its public setter method

    //2. JAVA WILD CARD FUNCTIONS SIGNATURES WILL BE CONVERTED TO USE-SITE
    // VARIANTS / COVARIANCE / CONTRAVARIANCE

    // add(list: (MutableList<out Number!>..List<Number!>?))
    val numberList: MutableList<Int> = mutableListOf(1, 2 , 3)

    car.add(numberList)
    //<? extends SomeClass> is converted to SomeClass<out T> - Covariance
    //<? super SomeClass> is converted to SomeClass<in T> - ContraVariance

    // printOnlyIntegerClassOrSuperClass(list: MutableList<in Int!>!)
    car.printOnlyIntegerClassOrSuperClass(numberList)

    //3. Exceptions
    // if we call a java method that throws an exception and if we don't handle
    // the exception inside the java method, we declare throws in function method
    // signature, calling that method in kotlin code, we are not forced to declare the
    // throws in kotlin method, kotlin doesn't distinguish between checked and
    // unchecked exceptions


    checkCarValidity(car,1993)// we didn't add any throw in method signature
    // of checkCarValidity() method, internally java called method checkYearValidity()
    // will throw a Exception of invalid year value of less than 1990, kotlin
    // doesn't have difference between checked and unchecked exception
    // java should handle the checked Exception or it should throw it to its callers
    //to handle it

    //4. CHECKING VAR_ARGS FUNCTIONS
    car.variableArgMethod(10, "Ford", "Toyota", "Honda", "BMW")

    println()
    val carBrands = arrayOf("Ford", "Toyota", "Honda", "BMW")
    car.passingArrayToVarArgMethod(10, carBrands)

    // In Java an array can be passed directly to a function which accepts var-arg param
    // like passingArrayToVarArgMethod(array)

    //from kotlin we cant pass an array to java function which accept a vararg
    //car.variableArgMethod(10, carBrands)
    // Type mismatch.    Required: String!    Found:    Array<String>

    // we have to unpack the array and pass it to the java function which accepts a
    // var-arg arguments, can be achieved by unpack operator (*) in kotlin
    println()
    car.variableArgMethod(10, *carBrands)

    //5. VOID Return TYPE in Java, Unit is in Kotlin
    // kotlin doesn't have Void return type, when a Java method returns 'void'
    // kotlin method will return 'Unit'
    // variableArgMethod() will return void in JavaCar class, if its called from kotlin
    // it return Unit in kotlin

    // 6. CONCLUSION ON ARRAY TYPES PASSING FROM KOTLIN TO JAVA
    val years = arrayOf(1990, 1991, 1999, 2020, 2002)
    //years is Kotlin array of Int objects which cant be passed to java method
    // which accepts primitive array, we have to pass only primitive array from
    // kotlin

    //Code: car.passingArrayToJavaMethod(years) //Error

    // passing primitive array from kotlin to java code - 2 ways
    println()
    car.passingArrayToJavaMethod(years.toIntArray()) // Way One
    println()
    car.passingArrayToJavaMethod(intArrayOf(1990, 1991, 1999, 2020, 2002)) // way two

    // 7. CONCLUSION ON OBJECT class in JAVA
    // * like Object class as top of Java Hierarchy, Any? is the top of Kotlin hierarchy
    // * some instance treated as 'Object in java' is considered as 'Any in kotlin'
    // * Any has only implementations of toString90, hashCode() and equals()
    // * 'Any' doesn't have methods like wait(), notify(), getClass(), finalize() which java
    // 'Object' class has in it.
    val getObj = car.someObj   // type of getObj is 'Any!'
    // getObj contains only equals(), hashCode() and toString() because its Any! type

    // if we want to use other functions of Object class in Kotlin

    val asObject = (getObj as java.lang.Object) // type of asObject is 'Object'
    //asObject.notify() // we will be able to use Object java class methods in Kotlin

    // 8. Static Fields and Methods access from Java Code
    //static are converted into companion objects in kotlin. cant pass these
    //companion objects as a value, but can use these static members
    println("Using Static::")
    println(JavaCar.staticMember)
    JavaCar.staticMemberFunction("\"Called from Kotlin Code\"")

    // 9. SAM conversion (Single Abstract Method)
    /*
        When a java interface has a single abstract method, we can use a lambda
        expression instead of a anonymous instance to the method which expects
        the interface instance as parameter

        Runnable Interface is a SAM interface
        interface Runnable {
            public void run();
        }

    */
    car.samDemoMethod()
    car.samDemoMethodUsingLambda()
    car.samDemoRunnablePassed({ println("Runnable passed from Kotlin")})
    // function signature in interface should match the lambda in kotlin
}
fun checkCarValidity(car: JavaCar, year: Int) : Boolean{
    return car.checkYearValidity(year)
}