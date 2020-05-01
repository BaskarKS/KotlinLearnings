import list

class User(var name: String, val id: Int) {
    init {
        val nameList: list = ArrayList()
        nameList.add(name)
    }
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

    println(userOne == userTwo) //User defines equals(), does content equality, false
    println(userTwo == userThree) //User defines equals(), does content equality, true
    println(userOne.equals(userTwo)) //does content equality, false
    println(userTwo.equals(userThree)) //does content equality, true

    println("reference comparison : " + (userOne === userTwo)) //User defines equals(), does reference equality, false
    println("reference comparison : " + (userTwo === userThree)) //User defines equals(), does reference equality, false
    val userFour = userTwo
    println("reference comparison : " + (userTwo === userFour)) //User defines equals(), does reference equality, true

    println("Checking not-equal")
    println("reference comparison : " + (userTwo !== userFour))//User defines equals(), does reference inequality, false
    println("reference comparison : " + (userTwo !== userThree)) //User defines equals(), does reference equality, true
    println(userTwo != userThree) //User defines equals(), does content inequality, false
    println(userOne != userFour)  //User defines equals(), does content inequality, true
}