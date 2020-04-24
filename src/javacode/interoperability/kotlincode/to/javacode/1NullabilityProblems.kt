package javacode.interoperability.kotlincode.to.javacode


/*
kotlin compiler does interoperability by default, if programmer wants to do extra
operations / do something different can use special annotations

Null Management is done using annotations like "@nullable, @notnull" annotations
should be used in Java code which we like to use it in Kotlin code.
These annotation will help the programmer and compiler in managing/using the code

With in kotlin the nullable/non-nullable types are very well managed, if we try to
use Java code in kotlin, the interoperability related to null management is done
by using these annotations. The java code which we use in kotlin is compile by kotlin
compiler, hence its better to use these annotations to educate the compiler to supply
or get the values from the java code and use it on a nullable/non-nullable type in Kotlin
These annotations will help Kotlin compiler to decide on using nullable/non-nullable type
variables in kotlin.
*/
fun main() {
    val car : JavaCar = JavaCar("Blue", "Ford", "Sedan", null,  2015)
//------SET NULL FROM KOTLIN CODE TO JAVA CODE, JAVA CODE HAS @NOTNULL---
//  java doesn't have inbuilt nullability protection, but kotlin has
//    car.color = null // without annotations in "public void setColor(String color)" - can set
//    println(car)

    // added @NotNull annotation to setColor(@NotNull String color)
    // we get runtime exception if we call setColor(null) with null
    //car.color = null //" java.lang.IllegalArgumentException: Argument for @NotNull parameter 'color' of
    println(car)

//------GET VALUE FROM JAVA TO KOTLIN CODE, NO ANNOTATIONS IN JAVA CODE---
//------JAVA RETURNED VALUE CAPTURED IN UNDEFINED TYPE VARIABLE  IN KOTLIN-----------------------
    //CASE-2
    var model = car.model // for getModel() function we didn't annotate
    // type of model variable in kotlin is not explicitly defined, hence its
    //default java free type and it will be nullable type, we can assign null to this variable
    model = null // type of model is String!, because we get value from Java Code and
    // no explicit type defined here

    //when you get a value from java code, and its not annotated at java code,
    //can assign that to a nullable/non-nullable type variable in kotlin code

//------JAVA RETURNED VALUE CAPTURED IN NON_NULLABLE TYPE VARIABLE  IN KOTLIN-----------------------
    //CAN TREAT VALUES COMING FROM JAVA CODE AS NON-NULLABLE and
    //protect it against NullPointerExceptions
    var carModel:String = car.model
    // carModel = null
    // we explicitly defined carModel as NonNullable type in kotlin code,
    // we cant assign null to it

//------JAVA RETURNED VALUE CAPTURED IN NULLABLE TYPE VARIABLE  IN KOTLIN-----------------------
    //CAN WE TREAT VALUES COMING FROM JAVA AS NULLABLE Values? YES
    var carModelCanEmpty: String? = car.model
    carModelCanEmpty = null
    // we can assign carModelCanEmpty with null, possible

//------ NOT POSSIBLE TO FIND CLASS OF THE JAVA CODE RETURNED VALUE-----------
    // println(carModelCanEmpty.javaClass) // since we get this value from java code
    // we cant find the java class of this variable

/*--- POSSIBLE TO ASSIGN A NON-NULLABLE VALUE FROM JAVA CODE TO A
   NULLABLE TYPE VARIABLE IN KOTLIN CODE */
    var carType: String? = car.type
    carType  = null
    println(car)

/*--- NOT  POSSIBLE TO ASSIGN A NULLABLE VALUE FROM JAVA CODE TO A
   NON-NULLABLE TYPE VARIABLE IN KOTLIN CODE */
    var carFuelType: String = car.fuelType // Exception in thread "main" java.lang.IllegalStateException: car.fuelType must not be null
    println(carFuelType)
    println(car)
    /*
    car.fuelType which will use getter method of GetFuelType() in Java code which is
    annotated with @Nullable on return value. This getter can possibly return a null
    value which cant be used to capture on non-nullable type variable in kotlin
    */

    /*
    NON-NULLABLE annotation used in java code can be captured in a
    NULLABLE TYPE / NON-NULLABLE TYPE variable in KOTLIN CODE

    NULLABLE annotation used in Java code can be captured only in
    NULLABLE TYPE Variable in Kotlin code

    NULLABLE TYPE VARIABLE IS WIDER THAN NON-NULLABLE Variable

    NO ANNOTATIONS DEFINED IN JAVA CODE CAN BE CAPTURED IN
    NULLABLE TYPE / NON-NULLABLE TYPE / UNDEFINED TYPE in Kotlin code

     * UNDEFINED TYPE IN KOTLIN CODE WHICH RECEIVES VALUES FROM
     JAVA CODE are Called platform types, which cannot be created explicitly in kotlin
     val color = car.getColor()
     * the type of color variable is "String!" which is platform type, null checks has to
      be explicitly done in kotlin code, compiler don't care.
     * no problem to assign null value / non-null values to platform type variable in kotlin
     * platform types are created only when kotlin code is mixed with other language
 */
    car.color = "Red"
    println(car)
}