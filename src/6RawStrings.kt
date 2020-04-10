fun main(args: Array<String>) {
    var filePath = "c:\\someDirOne\\someDirTwo"
    println(filePath) // need to escape some characters in a String eg: \

    // no need to escape special characters explicitly in raw strings
    var path = """c:\someDirOne\someDirTwo"""
    println(path)

    /*
    * Raw Strings - using """ """
    * no need to escape some special characters
    * can contain line breaks also
    * cant contain tab and new line
    * */
    val checkNewLine = """cheking new line \n"""
    println(checkNewLine)
    val checkTab = """cheking new line \t"""
    println(checkTab)

    println()
    //have to trim the spaces in multiline strings - explicitly using trimMargin()
    val multiLineStringWithoutTrim = """Humpty Dumpty sat on a Wall
                                            |Humpty Dumpty has a great fall
                                            |All the King's Horse's and All the King's Men
                                            |Could'nt put humpty together again"""
    println(multiLineStringWithoutTrim)

    println("")
    //default trim character is "|"
    val multiLineStringWithTrim = """Humpty Dumpty sat on a Wall
                                            |Humpty Dumpty has a great fall
                                            |All the King's Horse's and All the King's Men
                                            |Could'nt put humpty together again""".trimMargin()
    println(multiLineStringWithTrim)

    println()
    // using explicit trim character "*"
    val multiLineStringExTrim = """Humpty Dumpty sat on a Wall
                                            *Humpty Dumpty has a great fall
                                            *All the King's Horse's and All the King's Men
                                            *Could'nt put humpty together again""".trimMargin("*")
    println(multiLineStringExTrim)

    println()
    val name = "Humpty"
    val multiLineWithTemplate = """$name Dumpty sat on a Wall
                                            |$name Dumpty has a great fall
                                            |All the King's Horse's and All the King's Men
                                            |Could'nt put $name together again""".trimMargin()
    println(multiLineWithTemplate)

}