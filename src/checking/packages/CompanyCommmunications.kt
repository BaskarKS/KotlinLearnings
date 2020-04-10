package checking.packages

import objectkeyword.CheckCompanion
import objectkeyword.SingletonClassExtend as SingletonExtendingClass //useful when
// two different implementations needed to import here which has same name, can
/// use 'as' and make different names and use it here
fun main() {
    println(CheckCompanion.accessPrivateValue())
    println(SingletonExtendingClass.mustImplement())
}