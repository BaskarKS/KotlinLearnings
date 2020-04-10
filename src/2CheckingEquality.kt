
class User(var name: String, val id: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is User) {
            return name == other.name && id == other.id
        }
        return false
    }
}

/*
* if equals() method is not overridden
*  == and === does reference comparison for equality
*  != and !== does reference comparison for not equality
*
* if equals() method is overridden to check for values equality
*  == does value comparison like equals()
*  === does reference comparison for equality
*  !=  does value comparison for non equality like equals and
*  !== does reference comparison for non equality
* */

fun main(args : Array<String>) {
    val userOne = User("mary", 1)
    val userTwo = User("john", 2)
    val userThree = User("john", 2)
    println(userOne == userTwo)
    println(userTwo == userThree)
    println(userOne.equals(userTwo))
    println(userTwo.equals(userThree))
    println("reference comparison : " + (userOne === userTwo))
    println("reference comparison : " + (userTwo === userThree))
    val userFour = userTwo
    println("reference comparison : " + (userTwo === userFour))

    println("Checking not-equal")
    println("reference comparison : " + (userTwo !== userFour))
    println("reference comparison : " + (userTwo !== userThree))
    println(userTwo != userThree)
    println(userOne != userFour)
}