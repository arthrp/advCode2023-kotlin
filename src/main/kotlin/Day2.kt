class Day2 {
    val MAX_RED = 12
    val MAX_GREEN = 13
    val MAX_BLUE = 14
    fun solve(input: String): Int {
        val lines = input.split("\n")
        var sum = 0
        for (line in lines){
            if(line.isEmpty()) continue
            sum += processLine(line)
        }

        return sum
    }

    fun solveAdditional(input: String): Int {
        val lines = input.split("\n")
        var sum = 0
        for (line in lines){
            if(line.isEmpty()) continue
            sum += getGameCubePower(line)
        }

        return sum
    }

    private fun processLine(line: String): Int {
        val gameId = Regex("Game (\\d+)").find(line)!!.groupValues[1].toInt()
        if (!isColorCubeCountValid(line, Regex("(\\d+) red"), MAX_RED) ||
            !isColorCubeCountValid(line, Regex("(\\d+) green"), MAX_GREEN) ||
            !isColorCubeCountValid(line, Regex("(\\d+) blue"), MAX_BLUE)){
                return 0
        }
        return gameId
    }

    private fun getGameCubePower(line: String): Int {
        val red = getMaxColorCubeCount(line, Regex("(\\d+) red"))
        val green = getMaxColorCubeCount(line, Regex("(\\d+) green"))
        val blue = getMaxColorCubeCount(line, Regex("(\\d+) blue"))

        return red * green * blue
    }

    private fun isColorCubeCountValid(input: String, r: Regex, max: Int): Boolean {
        val matches = r.findAll(input)
        for (match in matches){
            if (match.groupValues[1].toInt() > max)
                return false
        }
        return true
    }

    private fun getMaxColorCubeCount(input: String, r: Regex): Int {
        val matches = r.findAll(input)
        val counts = matches.map { it.groupValues[1].toInt() }

        return counts.max()
    }
}