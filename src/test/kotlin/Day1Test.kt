import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1Test {

    @Test
    fun solveDay1_works() {
        val input = "1abc2\n" +
                "pqr3stu8vwx\n" +
                "a1b2c3d4e5f\n" +
                "treb7uchet\n"

        val result = Day1().solve(input)
        assertEquals(142, result)
    }
}