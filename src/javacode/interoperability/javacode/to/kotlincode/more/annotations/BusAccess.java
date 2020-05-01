package javacode.interoperability.javacode.to.kotlincode.more.annotations;

import java.io.IOException;

public class BusAccess {
    public static void main(String[] args) {
        //---------------------USING @JvmStatic-------------------------------------------------------
        Bus.Companion.busComp(); // compiler generates only one version function
        // which cause to access the function through companion object

        // To use busComp() function without using Companion object is to define the
        // function with @JvmStatic annotation
        Bus.busDirectAccess(); // 1st version, @JvmStatic annotation used,
        // can be accessed directly
        Bus.Companion.busDirectAccess(); //2nd version, accessed using Companion


        // ACCESSING SINGLETON OBJ
        // When Kotlin compiler compiles a object class, it generates a static class
        // and adds a filed named "INSTANCE" to it, "INSTANCE" is the single instance
        // of the object class, we can refer the functions in the singleton object using the
        // INSTANCE field
        BusSingletonObj.INSTANCE.doSomething();

        // if the function inside the singleton object use @JvmStatic, that method can be
        // accessed directly without INSTANCE field
        BusSingletonObj.accessDirect();

        //---------------------USING @JvmStatic-------------------------------------------------------

        //---------------------USING @JvmField-------------------------------------------------------
        // to access the fields of companion object, use companion keyword to
        // access it
        System.out.println(Bus.Companion.isBus()); // isBus() is a getter for
                                                    // isBus Field in companion object
        System.out.println(Bus.nameOfCompanion); //nameOfCompanion is defined
        // as @JvmField, it can be accessed directly without Companion and its not getter
        // its field

        // CASE -2 if fields are defined as "Const" then it can be accessed directly without
        // Companion and @JvmField annotation
        System.out.println(Bus.intConstant); // its Const value, accessed directly
        // CASE-3: late init values also can be accessed directly in Java like
        // "Const" fields

        //---------------------USING @JvmField-------------------------------------------------------

        //---------------------Null SAFETY not there when called from Java Code-----------
        Bus bus = new Bus("Green", "Tata", 2019);
//        bus.printThePassedValue(null); // this method param is defined as
        // non-nullable param but we are allowed to pass null value from java code
        //---------------------Null SAFETY not there when called from Java Code-----------

        //---------------------When if a checked exception is thrown from Kotlin code-----------
        bus.doInputOutputOperation(); // this function throws a checked exception
        //from kotlin code, but compiler will not alert programmer to handle it in code

        // to make the java code to get alert about the checked exception thrown
        // by kotlin code, use annotation @Throws(IOException::class)
        try {
            bus.alertJavaCheckedException(); // here its forced to handle the checked exception
        } catch (IOException e) {
            e.printStackTrace();
        }
        //---------------------When if a checked exception is thrown from Kotlin code-----------

        //---------------------How to handle kotlin function has default arguments-----------
        BusKt.defaultArgs("India", 1);
        // we should pass both the arguments, even num is assigned with
        // default value in kotlin. we cant use that signature from Java

        // to use the default param assigned signature in Java, use @JvmOverloads annotation                                                                        
        BusKt.usingDefaultArgsInJava("Singapore");
        BusKt.usingDefaultArgsInJava("Singapore", 99);
        BusKt.usingDefaultArgsInJava("Singapore", 11, false);
    }
}
