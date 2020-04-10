fun main(args : Array<String>) {
    var x = 0x00101101
    var y = 0x11011011
    var bitAnd = x and y // kotlin uses "and" instead of & for bitwise operation
    var bitOr = x or y // kotlin uses "or" instead of |  for bitwise operation
    var bitExOr = x xor y // kotlin uses "xor" instead of ^ for bitwise operation
    System.out.printf("%x\n", bitAnd)
    System.out.printf("%x\n", bitOr)
    System.out.printf("%x\n", bitExOr)
}