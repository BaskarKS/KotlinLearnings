package files

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main() {
    val reader: InputStreamReader = File("src/files/Resume.txt").reader()
    // check readLines(), readText(), use{}, forEachLine{}, useLines{}
    // readText() have to explicitly close the reader() resource
    // useLines{it} will return a sequence, again iterate sequence to get each line text

    val bufferReader: BufferedReader = File("src/files/Resume.txt").bufferedReader()
    //check use{}

    val fileResource: File = File("src/files/Resume.txt")
    // check readText()

    // readLinesFromReader(reader)
    // readTextFromReader(reader)
    // useBlockFromStreamReader(reader)
    // useBlockFromBufferedReader(bufferReader)
    // useFileAndRead(fileResource)
    // forEachLineOnStreamReader(reader)
    useLinesOnStreamReader(reader)

}

/*
This readLines() will return a List<String> each entry in list is the 'line in text file'
better not to use it for large files because it loads the entire file in memory
 */
fun readLinesFromReader(reader: InputStreamReader) {
    val fileList: List<String> = reader.readLines() // entire file is read as single string
    fileList.forEach { println(it) } // each 'it' is each 'entry in list' which is 'line in text file'
}


/*
readText() will read the entire file into a string, but doesn't close the reader() resource
 */
fun readTextFromReader(reader: InputStreamReader) {
    val lines: String = reader.readText()
    println(lines)
    reader.close() // using readText(), have to explicitly close the reader
}

/*
use block{it -> each line} on streamReader will read line by line as string and
compose as a single string. Close the reader resource.
*/
fun useBlockFromStreamReader(reader: InputStreamReader) {
    val lines: String = reader.use { it.readText() }
    println(lines)
}

/*
use block{it -> each line}on bufferedReader, will read line by line as string and
compose as a single string. Close the reader resource.
*/

fun useBlockFromBufferedReader(reader: BufferedReader) {
    val lines:String = reader.use { it.readText() }
    println(lines)
}

/*
readText() function on File resource is an extension function in File class,
closes the file resource implicitly, not recommended for large files
*/
fun useFileAndRead(fileResource: File) {
    val lines: String = fileResource.readText()
    println(lines)
}

/*
forEachLine{} Its extension function of InputStreamReader Class
read one line at a time, does'nt read the entire file, close the resource for us
*/
fun forEachLineOnStreamReader(reader: InputStreamReader) {
    reader.forEachLine { println(it) }
}

/*
useLines{} Its extension function of InputStreamReader Class
read a sequence, does'nt read the entire file, close the resource for us
*/
fun useLinesOnStreamReader(reader: InputStreamReader) {
    //reader.useLines { println(it) } //kotlin.sequences.ConstrainedOnceSequence@7ef20235
    reader.useLines {it.forEach { eachLine -> println(eachLine) }}
    // useLines{it} -> it is a Sequence -> have to again use foreach{}
    // to read from sequence
}