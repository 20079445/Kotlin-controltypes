package ie.setu.controlflow
import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    println("The max number is: " + maxOf(4,6))
    println(printValue(7))
    printRange(30)
    println( printExpressionResult(12, "12"))
    printInferredType()
    println(printAnimal("elephant"))
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
    forEachStandard()
    forEachIndices()
    forEachWithIndex()
    whileWithList()
    doWhileExample()
    workingWithStrings()
    workingWithTemplates()
    nullSafety()
}

fun nullSafety() {
    var aString :String? = "abc"
    val size = aString?.length ?: -1
    aString = null
}

fun workingWithTemplates(){
    var firstString = "This is a String"
    var secondString = "and this is another String"

    //using simple names
    println ("Simple names: $firstString $secondString")

    //using arbitrary expressions in {}
    println("Expressions (cases): ${firstString.uppercase()} ${secondString.lowercase()}")
    println("Expressions (string size): first string is ${firstString.length}")
    println("Expressions (substring): ${firstString.substring(0,2)}")
}

fun workingWithStrings(){
    val aString = "An escaped string!\n"
    print(aString)

    val einstein = """
        Learn from yesterday
        Live for today
        Hope for tomorrow
        The important thing
        is not to stop questioning.
        (Albert Einstein)
    """.trimIndent()
    println(einstein)

    val franklin = """
        |Tell me and i forget.
        |Teach me and i remember.
        |Involve me and i learn.
        | (Benjamin Franklin)
    """.trimIndent()
    println(franklin)
}

fun doWhileExample(){
    var index = 0
    do {
        println("Do While Index is: " + index)
        index++
    } while (index < 5)
}

fun whileWithList(){
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size){
        println ("Item at index: " + index + " is: " +  items[index])
        index++
    }
}

fun forEachWithIndex(){
    val items = listOf("apple", "banana", "kiwi")
    for ((index, value) in items.withIndex()){
        println("The item at $index" + " is: $value")
    }
}

fun forEachIndices(){
    val items = listOf("apple", "banana", "kiwi")
    for (index in items.indices){
        println("item at " + index + " is: " + items[index])
    }
}

fun forEachStandard(){
    val items = listOf("apple", "banana", "kiwi")
    for (item in items){
        println("Item is: $item")
    }
}

fun describe(obj: Any): String = when(obj) {
        1 ->   "One"
        "Hello" ->   "A Greeting"
        is Long ->   "Long Var"
        !is String ->   "Not a String"
        else ->   "Unknown"
}

fun printAnimal(aString: String) = when {
    aString.equals("Dog") -> "A dog"
    aString.equals("Cat") -> "A cat"
    aString.contains("pig") -> "A pig of some sort"
    aString.length == 0 -> "Empty String..no Animal"
    else -> "No identifiable animal"
}

fun printInferredType(){
    val number = 3;
    when(number){
        is Int -> println ("My inferred type is Int")
    }
}

fun printExpressionResult(numberValue: Int, stringValue: String) = when (numberValue){
    parseInt(stringValue) -> "stringValue holds the same number as numberValue"
    else -> "stringValue is not the same number as numberValue"
}

fun printRange(value: Int){
    when(value){
        in 1..10 -> println ("Between 1..10");
        !in 10..20 -> println ("Outside 10..20")
    }
}

fun printValue(value : Int) = when(value){
    1 -> "The value is One"
    2 -> "The value is Two"
    in 3..5 -> "This value is between three and five"
    6, 7, 8 -> "The value is either Six, Seven or Eight"
    else -> "The value is: $value"
}

//if as an expression
fun maxOf(a: Int, b: Int) =
    if (a > b) {
        print("a is greater than b.  ")
        a
    }else {
        print("b is greater than a.  ")
        b
    }