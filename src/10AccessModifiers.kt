/*
* public, private Internal - can be defined for top level class
* protected - can't define for top-level classes
*
***Group of files compiled together are called modules
*
*** Any number of public classes can present in a file
*
*** In kotlin, meaning of access modifiers is different depending on whether we deal
* something at top-level of file or something that's a class member
*
*** top-level items without modifiers are 'public' by default, public can be accessed
* anywhere
*
*** top-level private items can be accessed only with in the file
*
*** top-level internal modifier is visible only inside the module
*
*** class-members access modifiers mean the same as they do in java, only difference
* is internal modifier
*
***anything inside the same module that can see a class can see its internal members
* Eg: public class -> internal members can be accessed
*
*** private class -> internal members are visible / accessed only with in the file
*
*** kotlin access modifiers should be compiled in such a wayJVM can understand
* ** 'private' access modifier is compiled to 'default'
* ** 'internal' access modifier is compiled to 'public'
*

* ** kotlin enforce its visibility rules at compile time, it wont lead to visibility rules
* being broken for java access
*
* */

internal class ABC {
    public val accessOnlyWithInModule = true
    internal val accessWithInModule = true
}

private class DEF {
    internal val onlyWithInFile = true
}

class GHI {
    internal var accessAnywhere = true
}

