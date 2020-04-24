package files

import java.io.File

fun main() {
    walkTopDownFileTree()
    // walkBottomUpFileTree()
}
fun walkTopDownFileTree() {
    File("src/files/").walkTopDown().forEach { println(it) }
    // directories are visited first, then files
    println()
    println()
    println("Walking Top Down then filtering only source files")
    File("src/files/").walkTopDown()
        .filter { it.name.endsWith(".kt")}.forEach { println(it) }
}
fun walkBottomUpFileTree() {
    File("src/").walkBottomUp().forEach { println(it) }
}


/*
walk function will mention a direction, whether to walk up a tree / walk down a tree

walkBottomUp() will walk 'up' a file tree- first files are visited then directories
walkTopDown() will walk 'down' a file tree. directories are visited first then the files

walkTopDown() / walkBottomTop() will return a sequence, we can either terminate
the sequence by fetching values using forEach{} or we can operate on the
sequence using a map / filter ....
*/