class Day1 {
    fun solve(input: String): Int {
        val lines = input.split("\n")
        var sum = 0
        for (line in lines) {
            if(line.isEmpty()) continue

            val lineNum = processLine(line)
            sum += lineNum.toInt()
        }

        return sum
    }

    private fun processLine(line: String): String {
        val regex = Regex("\\d")
        val matches = regex.findAll(line)
        if (matches.count() == 1) return "${matches.first().value}${matches.first().value}"

        return "${matches.first().value}${matches.last().value}"
    }
}