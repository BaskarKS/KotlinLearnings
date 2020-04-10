fun main(args: Array<String>) {
    val change = 4.22
    println("value of change \$change")
    println("value of change $$change")
    // use $ to substitute a value in a string
    // use ${expression} to evaluate a expression and substitute the value in string

    val numerator = 10.99
    val denominator = 20.00
    println("value of $numerator divided by $denominator is ${numerator / denominator}")

    var employee = Employee("Baskar", 11400)
    print("Employee name is ${employee.name} and his Emp ID is  ${employee.id}")
}