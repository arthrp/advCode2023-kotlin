import java.io.File

fun main(args: Array<String>) {
    val filePath = args[0]
    val content = File(filePath).readText()

    val result = Day1().solve(content)
    println("Result is $result")
}