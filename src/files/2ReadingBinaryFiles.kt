package files

import java.io.DataInputStream
import java.io.EOFException
import java.io.File
import java.io.FileInputStream

fun main() {
    val path: String = "src/files/sample.bin"
    readingBinaryFile(path)
}

fun readingBinaryFile(path: String) {
    val file = File(path)
    val data = file.readBytes() // read the entire file in memory, max file size is 2GB
    // Best to read binary data in chunks
    var si: String
    val stream = DataInputStream(FileInputStream(path))
    /*try {
        while(true) {
            si = stream.readUTF() // this method is aware its reading UTF and that's
            // going to be length 2 bytes and convert to string
            println(si)
        }
    }catch (e: EOFException) {
        println(e)
    }*/
    // when a UTF-8 string is written into a Binary string, length of the string is written
    //  before the string itself. this length is useful to read it back.

    // in kotlin no great enhancements on binary file reading.
    // most of the convenience functions and enhancements are added to text files processing
    // object streams, no support is added in kotlin
    // kotlin has added Writer and BufferedWriter extension functions

    // try with resources will take care of closing resources implicitly, resources
    //do have to implement the Closeable(I)
    // in kotlin use lambda, it does the same action as try with resources does,
    //close the resources even if exception is raised
}