package generics

/*
"when a class is covariant, its meaning that we have used "out" keyword, which means
subtyping is preserved and  the class can only be used in the 'out' position.
*/

/*
Variance is a topic used for Generics

if we create a mutable or un-mutable list or any collection we will specify the type,
If we create a class and have some internal data structure which is used in member
functions, so that the class will provide some service.

If we try to create a Generic class which uses some data structure which is defined
as some generic type, while creating an instance of the class we have to specify
the type so that the internal data structure will be create for that type to get used
in the class

class Stack<T> {
    List<T> values = List<T>();
    int count = 0;
    void push(T value) {
        values.add(count++, value);
    }
    T pop() {
        return values.remove(--count);
    }
 }

 we can create a stack of integers, strings, floats, short...
 To restrict the Type to support only integers , not strings and other type we restrict the
 type to Numbers

 class Stack<T extends Numbers> {
    List<T> values = List<T>();
    int count = 0;
    void push(T value) {
        values.add(count++, value);
    }
    T pop() {
        return values.remove(--count);
    }
 }

 public void processStack(Stack<Numbers> stack) {
     we can pass any stack to this function, but the type should be any descendant
     of Number type.
 }

 Same way in kotlin we can pass the mentioned type / descendant type to
 functions only for immutable collections, which are covariant type

 we cant pass the descendant type for mutable type collections. as its invariant
 type.

 if we create a Generic class which is not restricted to some type like "Number", we
 can create instance of the class with some specific type only.
 if the class is used as parameter in methods outside the class(not member
 functions of class). we have to create class-type specific parameters for methods.
 public processClass(MyClass<String> list) {} , we can only pass MyClass<String> type
 to this method.
 if the method supports class of any type its fine to define
 the class as generic one,  and it behave like InVariant,
 only the mentioned specific type of class can be passed to the function.

 if we create a Generic class which is restricted to some type list "Number",
 we can create instance of the class of Number type or subclass of Number type,
 if the class is used as parameter in methods outside the class(not member
 functions of class). we want method to support class-type specific parameters and
 subclass type parameters for methods
 fun processClass(list: MyClass<Number>) {} , we should be allowed to pass
 MyClass<Int> / MyClass<Short> / .. to make this support to happen then
 we have to define our class to support covariant, only then the support to pass
 subtype of restricted type(Number) will be allowed

 we can define our class as covariant type by mentioning out at type parameter
 of class
 class MyClass<out T:Number> {}
 problems with covariance type is:
 now the method parameter is allowed to accept Number type class or any of the subtype
 class to the method
 but inside the class, the methods are not allowed to use the type as input parameter,
 only the type value can be used as return value which means we cant add/remove/edit
 the type mentioned data structure inside the class, we can only read the value and return
 the values in member functions

*/

fun main() {
    val shortList: List<Short> = listOf(1, 2, 3, 4, 5)
    convertToInt(shortList)

    val mutableShortList: MutableList<Short> = mutableListOf(1, 2, 3, 4, 5)
    //convertToIntMutable(mutableShortList) // we are not allowed to pass List of
                                            // subtype of Number which is List<Short> to this function
                                        //because mutable collections are not covariant
}

// This is public top line function which accepts a List of Number type which has
// implementation to convert any Number type into Integer.
// List type is immutable type we can pass any subtype of Number or the Number type
// itself
fun convertToInt(collection: List<Number>) {
    for (num in collection)
        println("${num.toInt()}")
}

// This is public top line function which accepts a MutableList of Number type which has
// implementation to convert any Number type into Integer.
// MutableList type is mutable type we can't pass any subtype of Number or the Number type
// itself

//in generics using type and subtype is more accurate than using class and subclass
// 'List' is a Class not a type, 'List of String' or 'List of Short' is a Type.

// 'List of Short' or 'List of Int' is subtype of 'List of Number'
// 'List of Int' is not a subclass of 'List of Number'

// we want to treat 'List of Short' like a 'List of Number' which comes the
// concept of covariance.

// 'List of Short' is subtype of 'List of Number', if we want the subtype information to
// be preserved when using generics we have to declare the type parameter to be
// covariant.

//'collection Interface' is covariant and 'Mutable collection' is not covariant.
// that's why subtype information is preserved for immutable lists and not preserved
// for mutable lists.
//Hence for mutable collections, subtype is not preserved because its not covariant.
// we are not allowed to pass List of "subtype of Number" to this function
fun convertToIntMutable(collection: MutableList<Number>) {
    for (num in collection)
        println("${num.toInt()}")
}


////// writing our own custom generic class like List
open class Flower{

}

class Rose: Flower() {

}

// Garden has been mentioned with some Type which is restricted to Flower type
// can create a instance of Garden of Rose / Garden of Daffodil / Garden of Daisies

// Garden is a custom generic class, restricted to use Flower type / Flower subclasses Type
// it can have a data structure / variables of T type inside and member functions operating
//on it.
/*
There's no restriction of 'in' and 'out' for construction parameters, we can use covariant type
 parameter in constructor. we cant use 'var' type variable, because kotlin will generate a setter
 for var variables which might allow other subtype to apply on variable and cause a corruption.
 we can have either val covariant type variable / it can be private variable of either val / var
class Garden<out T:Flower>(val someThing: T) // error
class Garden<out T:Flower>(val someThing: T) // allowed
class Garden<out T:Flower>(private val someThing: T) // allowed
class Garden<out T:Flower>(private var someThing: T) // allowed, from outside its not accessible
*/
class Garden<out T:Flower>(val someThing: T) { // now garden class is covariant
    //in the public / internal member functions the type value is restricted to use
    // only in 'out' position, cant be used in 'in'. no problem to use in 'in/out' for
    // private methods
    val flowers: List<T> = mutableListOf()
    fun pickFlower(flowerNo: Int)  = flowers[flowerNo]
/*
     cant use type T value in parameter of a function, can be used only in
     return type of function
     T can be used only in out position
*/

//    fun plantFlower(flower: T) { // error : Type parameter T is declared as 'out' but occurs in 'in' position in type T

/*
        if this T type is allowed as function parameter in 'in' position,
         any subtype can come inside this class and corrupt with different subclass
         values.
         */
        fun plantFlower(flower: @UnsafeVariance T) { // we can force the compiler to allow T type parameter in
            // 'in' position using "@UnSafeVariance" annotation , giving a commitment that T will not be
            // used to add/delete/change.  T is used only to read inside the function

        }
//    }

/*
     This class is made covariant, this class is allowed to get created with subtype
     of Flower. If this covariant class doesn't restrict this class to get modified from outside
     means, T type is allowed as in parameter for member functions, this class can
     get corrupted with multiple subclass (if the Number Type class is aloowed to pass
     with any of its subtypes, then chances are there to pass Short/Int/Float hence
     the type parameter is allowed to use only in out position, only we can read value
     we cant add/delete/modify values. only because of this corruption avoid, the restriction
     to use the type only in 'out' position.
     the because of this, any subclass can
*/
}

// function which calculates the amount to water to water the garden
// its a top level function outside the class
fun waterGarden(garden: Garden<Flower>) {

}

// function to tend our RoseGarden it also water the Rose garden.
fun tendGarden(roseGarden: Garden<Rose>) {
    // since Garden class is made covariant, now waterGarden() can accept Garden<Rose> , Rose is subtype of Flower is preserved
    // covariant class - restriction of "in" and "out" position is applicable only to member functions of garden class
    waterGarden(roseGarden) //Error
    // waterGarden expects a Garden<Flower> but we are passing Garden<Rose>
    // Rose is a subclass of Flower
    // Garden class is In-variant, (Subtype are not preserved)
    // waterGarden() expects a Garden<Flower>  we can pass only
    // only Garden<Flower> it wont accept Garden<Rose>(Rose is subclass of Flower)
    // subclass of Flower are not accepted.
    // function expecting MutableList<Number> will not accept MutableList<Short>

    // to make Garden<T:Flower> class to be more relaxed and to accept all of
    // Flower class subtypes, so that waterGarden(garden: Garden<Flower>) will
    // be able to accept a value Garden<Rose> and any of Flower class subtypes

    /*
     we have to make the Garden class (Invariant) to Covariant, we can do that by
     using 'out' keyword. 'out' is used in Mutable classes to make it covariant.
     class Garden<out T:Flower> {} // Garden class becomes Co-variant
     by making a class as covariant, its restricted to some usage like immutable classes
     "can read type values, but we cant add/delete/change them"
     function parameters are considered to be 'in' position
     function return type are considered to be 'out' position
    */

    /* covariant conclusion:
    1. we can create a generic class, if the class is restricted to someClass, if we want the subtypes to be allowed,
    we have to make it covariant by mentioning 'out' in type parameter of class
    2. in member functions of covariant class, the type parameter can be used only in 'out' position
    , cant be used in 'in' position.
    3. we can use annotation(@Unsafevariance) to allow it to use in 'in' position of member functions.
    4. no 'in' and 'out' constraints on constructor of covariant class, but we cant get a type value of 'var' in
    constructor as the var will allow a setter to change it from outside
    * */

}