package javacode.interoperability.javacode.to.kotlincode.access.top.level;

import javacode.interoperability.javacode.to.kotlincode.BikeStaticClass;

public class Main {
    public static void main(String[] args) {
        CarKt.topLevel();
        // compiler will generate a static class under the covers for all top level
        // items, it gives the class name same as the File Name (Carkt - ClassName)
        // all top level items in file Car.kt are considered as static items, Compiler
        // will generate a class same as file name including extension as Carkt and all
        // top level items are accessed using the class name.
        BikeStaticClass.bikeTopLevel();
        BikeStaticClass.printBikeName("this extension function is operated on String");
    }
}
