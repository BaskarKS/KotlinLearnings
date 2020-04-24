package generics

/*
 Contravariance
 */

fun main() {
    // create a Rose ContraGarden - need to pass List of Roses and Implementation
    // instance of FlowerCare(I)
    val roseTender = object: FlowerCare<ContraRose> {
        override fun prune(flower: ContraRose) {
            println("I am Pruning a ${flower.name}")
        }
    }
    // we have created a RoseGarden of type ContraRose, pass list of ContraRose() and an implementation of
    // FlowerCare interface of type ContraRose. ContraRose is subtype of ContraFlower
    //  ContraGarden is created with a list of ContraRose type of instance and Interface implementation of type
    // ContraRose type where there's no problem of accepting ContraRose type instance in prune method of Interface
    val contraRoseGarden = ContraGarden<ContraRose>(listOf(ContraRose(), ContraRose()),
                                                        roseTender)
    contraRoseGarden.tendFlower(0) //"I am Pruning a Roses"

    val daffodilTender = object: FlowerCare<Daffodil> {
        override fun prune(flower: Daffodil) {
            println("I am pruning $flower.name")
        }
    }
    val daffodilGarden = ContraGarden<Daffodil>(listOf(Daffodil(), Daffodil()), daffodilTender)
    daffodilGarden.tendFlower(1)

    //Tender is just cutting / getting the flower, its generic for all garden. No need to create seperate instance for
    // each type of flower
    // can create a generic Tender instance and use it for RoseGarden and DaffodilGarden
    val flowerTender = object: FlowerCare<ContraFlower> {
        override fun prune(flower: ContraFlower) {
            println("Tend the flower : ${flower.name}")
        }
    }

    /* we cant pass this GenericTender implementation to roseGarden / daffodilGarden
      because the RoseGarden expects/accept a RoseTender implementation and DaffodilGarden will
     expect / accept a DaffodilTender implementation, we cant pass a parent class type (ContraFlower is
     parent class of ContraRose and Daffodil) FlowerCare<ContraFlower> implementation to the RoseGarden/DaffodilGarden
     which expects the subType implementation of FlowerCare<ContraRose> / FlowerCare<Daffodil>, here our
     need is to accept the parent class type implementation of FlowerCare<ContraFlower> which raise the
     concept of ContraVariance( its opposite of CoVariance)
     CoVariance preserve the subtype from superclass to subclasses(we look down the In-Heritence tree)
    ContraVariance preserve the subtype from subclass and towards its superclasses(we look up the In-Heritence tree)

    We are starting at a point on the Inheritence tree, if we want to accept that point and anything above it its
    contravariant and if we want to accept that point and anything below it then its covariance.

    covariant types will appear at the 'out' positions. contravariant types will appear at the 'in' positions
    (member function parameters are the 'in' positions

    */
    val daffodilGardenGenericTender = ContraGarden<Daffodil>(listOf(Daffodil(), Daffodil()), flowerTender)
    daffodilGardenGenericTender.tendFlower(1)
    val contraRoseGardenGenericTender = ContraGarden<ContraRose>(listOf(ContraRose(), ContraRose()),
        flowerTender)
    contraRoseGardenGenericTender.tendFlower(0) //"I am Pruning a Roses"
    // now ContraGarden<ContraRose> / ContraGarden<Daffodil> classes are able to accept  FlowerCare<ContraFlower>
    // instead of  FlowerCare<ContraRose> and  FlowerCare<Daffodil> because of FlowerCare<in T>
    // made contravariant to accept type T or any of its super classes
    // contravariant classes can be uses only as parameters and we can only write them, we cant use them as
    // return types and we cant read them
}

class Daffodil: ContraFlower("Daffodil") {

}
open class ContraFlower(val name: String) {

}
class ContraRose: ContraFlower("Rose"){

}

interface FlowerCare<in T> { // making this interface as Contravariant, Any type T or its super classes will
                                                 // be accepted. T will be allowed only in function parameters, restricted on return types
    fun prune(flower: T)
    //fun pick(i : Int): T // after making this interface as contravariant, its not
                                        // possible to have function with return as T type
    // if compiler allows to return T type, its possible to return superclass instance when T type is of subclass Type
    // if the T is subclass type is Rose and if compiler allows to return Contravariant, its possible to return Flower Instance
    // if the T is subclass type of Rose and if the interface returns Flower instance, its not correct. Hence compiler
    // restricts to return T type for contravariant class / interface implementations
    //covariance = we do widening the Type by include the Type and subclasses of Type - 'out' is used only for return types
    //contravariance  = we do narrowing the Type by include only Type and its super classes - 'in' is uses only for function parameters

    //covariance and contravariance are declaration site variants - we use it when we declare the class or interface
    // class Garden<out T: Flower> {}
    // interface FlowerCare<in T> {}
    //  in java we don't have 'declaration site variance' we have only 'use site variance'

}

class ContraGarden<T: ContraFlower> (val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]

    fun tendFlower(i:Int) {
        flowerCare.prune(flowers[i])
    }
}