import java.io.File

fun main(args: Array<String>) {
    val filePath = args[0]
    val content = File(filePath).readText()

    val result = Day2().solveAdditional(content)
    println("Result is $result")
}